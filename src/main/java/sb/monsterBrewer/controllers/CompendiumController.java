package sb.monsterBrewer.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sb.monsterBrewer.dtos.CompendiumImportDto;
import sb.monsterBrewer.dtos.MonsterXml;
import sb.monsterBrewer.models.*;
import sb.monsterBrewer.repositories.*;
import sb.monsterBrewer.services.XmlService;
import sb.monsterBrewer.services.XmlToDbService;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CompendiumController {
    private final XmlService xmlService;
    private final XmlToDbService xmlToDbService;
    private final CompendiumRepository repository;
    private final MonsterRepository monsterRepository;
    private final ActionRepository actionRepository;
    private final LegendaryActionRepository legendaryActionRepository;
    private final ReactionRepository reactionRepository;
    private final TraitRepository traitRepository;

    public CompendiumController(XmlService xmlService, XmlToDbService xmlToDbService, CompendiumRepository repository, MonsterRepository monsterRepository, ActionRepository actionRepository, LegendaryActionRepository legendaryActionRepository, ReactionRepository reactionRepository, TraitRepository traitRepository) {
        this.xmlService = xmlService;
        this.xmlToDbService = xmlToDbService;
        this.repository = repository;
        this.monsterRepository = monsterRepository;
        this.actionRepository = actionRepository;
        this.legendaryActionRepository = legendaryActionRepository;
        this.reactionRepository = reactionRepository;
        this.traitRepository = traitRepository;
    }

    @PostMapping("/Compendium")
    List<Monster> newCompendiumFromXml(@RequestBody CompendiumImportDto comp) throws XMLStreamException, JAXBException {
        var compendium = xmlService.unmarshalXml(comp.getComp());
        var monsters = new ArrayList<Monster>();
        var actions = new ArrayList<Action>();
        var legendaries = new ArrayList<LegendaryAction>();
        var reactions = new ArrayList<Reaction>();
        var traits = new ArrayList<Trait>();
        for (MonsterXml mx : compendium.getValue().getMonster()) {

            Monster monster = xmlToDbService.parseMonster(mx);
            monsters.add(monster);
            actions.addAll(monster.getActions());
            legendaries.addAll(monster.getLegendaryActions());
            reactions.addAll(monster.getReactions());
            traits.addAll(monster.getTraits());
        }

        actionRepository.saveAll(actions);
        legendaryActionRepository.saveAll(legendaries);
        reactionRepository.saveAll(reactions);
        traitRepository.saveAll(traits);
        return monsterRepository.saveAll(monsters);
    }
}
