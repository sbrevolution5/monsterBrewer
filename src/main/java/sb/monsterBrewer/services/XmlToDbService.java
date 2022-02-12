package sb.monsterBrewer.services;

import sb.monsterBrewer.dtos.MonsterXml;
import sb.monsterBrewer.models.Monster;

public class XmlToDbService {
    public Monster ReadXmlMonster(MonsterXml source){
        Monster res = new Monster();
        res.setName(source.getName());
        res.setDescription(source.getDescription());
        res.setAlignment(source.getAlignment());
        res.setSenses(source.getSenses());
        res.setAc(source.getAc());
        res.setEnvironment(source.getEnvironment());
        res.setSpeed(source.getSpeed());
        res.setHp(source.getHp());
        parseStats(source, res);
        parseSkills(source, res);
        return res;

    }

    private void parseSkills(MonsterXml source, Monster res) {
        String skillList = source.getSkill();
        //Check if we find each skill in the list
        //if not found, set to 0

    }

    private void parseStats(MonsterXml source, Monster res) {
        res.setDexterity(Integer.parseInt(source.getDex()));
        res.setStrength(Integer.parseInt(source.getStr()));
        res.setConstitution(Integer.parseInt(source.getCon()));
        res.setCharisma(Integer.parseInt(source.getCha()));
        res.setWisdom(Integer.parseInt(source.getWis()));
        res.setIntelligence(Integer.parseInt(source.getIntel()));
    }
}
