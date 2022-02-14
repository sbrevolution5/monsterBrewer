package sb.monsterBrewer.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sb.monsterBrewer.exceptions.MonsterNotFoundException;
import sb.monsterBrewer.models.Monster;
import sb.monsterBrewer.repositories.MonsterRepository;

@RestController
class MonsterController {

    private final MonsterRepository repository;

    MonsterController(MonsterRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/monsters")
    List<Monster> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/monsters")
    Monster newMonster(@RequestBody Monster newMonster) {
        return repository.save(newMonster);
    }

    // Single item

    @GetMapping("/monsters/{id}")
    Monster one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MonsterNotFoundException(id));
    }

    @PutMapping("/monsters/{id}")
    Monster replaceMonster(@RequestBody Monster newMonster,
                           @PathVariable Long id) {

        return repository.findById(id)
                .map(monster -> {
                    monster.setName(newMonster.getName());
                    monster.setAlignment(newMonster.getAlignment());
                    monster.setType(newMonster.getType());
                    monster.setHp(newMonster.getHp());
                    monster.setAc(newMonster.getAc());
                    monster.setSenses(newMonster.getSenses());
                    monster.setSize(newMonster.getSize());
                    monster.setTraits(newMonster.getTraits());
                    monster.setActions(newMonster.getActions());
                    monster.setHasLegendaryActions(newMonster.isHasLegendaryActions());
                    monster.setLegendaryActions(newMonster.getLegendaryActions());
                    monster.setSpeed(newMonster.getSpeed());
                    monster.setDescription(newMonster.getDescription());
                    monster.setEnvironment(newMonster.getEnvironment());
                    monster.setLanguages(newMonster.getLanguages());
                    //skills
                    monster.setDexterity(newMonster.getDexterity());
                    monster.setDexteritySave(newMonster.getDexteritySave());
                    monster.setStrength(newMonster.getStrength());
                    monster.setStrengthSave(newMonster.getStrengthSave());
                    monster.setConstitution(newMonster.getConstitution());
                    monster.setConstitutionSave(newMonster.getConstitutionSave());
                    monster.setIntelligence(newMonster.getIntelligence());
                    monster.setIntelligenceSave(newMonster.getIntelligenceSave());
                    monster.setWisdom(newMonster.getWisdom());
                    monster.setWisdomSave(newMonster.getWisdomSave());
                    monster.setCharisma(newMonster.getCharisma());
                    monster.setCharismaSave(newMonster.getCharismaSave());
                    monster.setAcrobatics(newMonster.getAcrobatics());
                    monster.setAnimalHandling(newMonster.getAnimalHandling());
                    monster.setAthletics(newMonster.getAthletics());
                    monster.setArcana(newMonster.getArcana());
                    monster.setDeception(newMonster.getDeception());
                    monster.setAcrobatics(newMonster.getAcrobatics());
                    monster.setStealth(newMonster.getStealth());
                    monster.setHistory(newMonster.getHistory());
                    monster.setInsight(newMonster.getInsight());
                    monster.setMedicine(newMonster.getMedicine());
                    monster.setNature(newMonster.getNature());
                    monster.setIntimidation(newMonster.getIntimidation());
                    monster.setInvestigation(newMonster.getInvestigation());
                    monster.setPerception(newMonster.getPerception());
                    monster.setPerformance(newMonster.getPerformance());
                    monster.setReligion(newMonster.getReligion());
                    monster.setPersuasion(newMonster.getPersuasion());
                    monster.setSurvival(newMonster.getSurvival());
                    monster.setSleightOfHand(newMonster.getSleightOfHand());
                    //Damage Types
                    monster.setThunder(newMonster.getThunder());
                    monster.setFire(newMonster.getFire());
                    monster.setLightning(newMonster.getLightning());
                    monster.setAcid(newMonster.getAcid());
                    monster.setNonMagicPiercing(newMonster.getNonMagicPiercing());
                    monster.setNonMagicBludgeoning(newMonster.getNonMagicBludgeoning());
                    monster.setNonMagicSlashing(newMonster.getNonMagicSlashing());
                    monster.setSlashing(newMonster.getSlashing());
                    monster.setBludgeoning(newMonster.getBludgeoning());
                    monster.setPiercing(newMonster.getPiercing());
                    monster.setCold(newMonster.getCold());
                    monster.setForce(newMonster.getForce());
                    monster.setNecrotic(newMonster.getNecrotic());
                    monster.setRadiant(newMonster.getRadiant());
                    monster.setPoison(newMonster.getPoison());
                    //conditions
                    monster.setPoisoned(newMonster.isPoisoned());
                    monster.setStunned(newMonster.isStunned());
                    monster.setUnconscious(newMonster.isUnconscious());
                    monster.setBlinded(newMonster.isBlinded());
                    monster.setCharmed(newMonster.isCharmed());
                    monster.setDeafened(newMonster.isDeafened());
                    monster.setExhaustion(newMonster.isExhaustion());
                    monster.setFrightened(newMonster.isFrightened());
                    monster.setGrappled(newMonster.isGrappled());
                    monster.setIncapacitated(newMonster.isIncapacitated());
                    monster.setInvisible(newMonster.isInvisible());
                    monster.setParalyzed(newMonster.isParalyzed());
                    monster.setProne(newMonster.isProne());
                    monster.setRestrained(newMonster.isRestrained());
                    return repository.save(monster);
                })
                .orElseGet(() -> {
                    newMonster.setId(id);
                    return repository.save(newMonster);
                });
    }

    @DeleteMapping("/monsters/{id}")
    void deleteMonster(@PathVariable Long id) {
        repository.deleteById(id);
    }
}