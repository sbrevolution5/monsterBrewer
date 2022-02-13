package sb.monsterBrewer.services;

import sb.monsterBrewer.dtos.MonsterXml;
import sb.monsterBrewer.models.Monster;

import java.util.Locale;

public class XmlToDbService {
    public Monster parseMonster(MonsterXml source){
        Monster res = new Monster();
        res.setName(source.getName());
        res.setDescription(source.getDescription());
        res.setAlignment(source.getAlignment());
        res.setSenses(source.getSenses());
        res.setAc(source.getAc());
        res.setEnvironment(source.getEnvironment());
        res.setSpeed(source.getSpeed());
        res.setHp(source.getHp());
        res.setPassive(source.getPassive());
        parseStats(source, res);
        parseSaves(source,res);
        parseSkills(source, res);
        parseActions(source, res);
        parseLegendary(source, res);
        parseTraits(source, res);
        parseReactions(source, res);

        return res;

    }

    private void parseSkills(MonsterXml source, Monster res) {
        String skillList = source.getSkill();
        //Check if we find each skill in the list
        String[] splitSkills = skillList.split(",");
        for (int i = 0; i < splitSkills.length; i++) {
            var skill = splitSkills[i].trim();
            boolean hasNegativeMod = skill.contains("-");
            var skillParts = skill.split("[+-]");
            var skillName = skillParts[0];
            int skillNum = Integer.parseInt(skillParts[1]);
            if (hasNegativeMod){
                skillNum *= -1;
            }
            switch (skillName.trim().toLowerCase(Locale.ROOT)){
                case "athletics" :
                    res.setAthletics(skillNum);
                    break;
                case "acrobatics" :
                    res.setAcrobatics(skillNum);
                    break;
                case "arcana" :
                    res.setArcana(skillNum);
                    break;
                case "animal handling" :
                    res.setAnimalHandling(skillNum);
                    break;
                case "deception" :
                    res.setDeception(skillNum);
                    break;
                case "history" :
                    res.setHistory(skillNum);
                    break;
                case "insight" :
                    res.setInsight(skillNum);
                    break;
                case "intimidation" :
                    res.setIntimidation(skillNum);
                    break;
                case "investigation" :
                    res.setInvestigation(skillNum);
                    break;
                case "medicine" :
                    res.setMedicine(skillNum);
                    break;
                case "nature" :
                    res.setNature(skillNum);
                    break;
                case "perception" :
                    res.setPerception(skillNum);
                    break;
                case "performance" :
                    res.setPerformance(skillNum);
                    break;
                case "persuasion" :
                    res.setPersuasion(skillNum);
                    break;
                case "religion" :
                    res.setReligion(skillNum);
                    break;
                case "sleight of hand" :
                    res.setSleightOfHand(skillNum);
                    break;
                case "stealth" :
                    res.setStealth(skillNum);
                    break;
                case "survival" :
                    res.setSurvival(skillNum);
                    break;
            }
        }

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
