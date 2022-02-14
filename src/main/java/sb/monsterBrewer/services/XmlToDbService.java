package sb.monsterBrewer.services;

import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import sb.monsterBrewer.dtos.MonsterXml;
import sb.monsterBrewer.dtos.TraitXml;
import sb.monsterBrewer.models.DamageSeverity;
import sb.monsterBrewer.models.Monster;
import sb.monsterBrewer.models.Trait;

import java.util.*;

public class XmlToDbService {
    public Monster parseMonster(MonsterXml source) {
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
        res.setLanguages(source.getLanguages());
        parseStats(source, res);
        parseSaves(source, res);
        parseSkills(source, res);
        parseActions(source, res);
        parseLegendary(source, res);
        parseTraits(source, res);
        parseReactions(source, res);
        parseDamageTypes(source, res);

        return res;

    }

    private void parseDamageTypes(MonsterXml source, Monster res) {
        var vulnerable = source.getVulnerable();
        var immune = source.getImmune();
        var resist = source.getResist();
        var damageTypes = new String[]{
                "fire",
                "cold",
                "lightning",
                "thunder",
                "force",
                "bludgeoning",
                "piercing",
                "slashing",
                "poison",
                "psychic",
                "necrotic",
                "radiant",
                "acid",
                "bludgeoning, piercing, slashing from nonmagical attacks"
        };
        //TODO: If we find all the phys types with nonmagical, then we shouldn't look for regular phys types
        for (int i = 0; i < damageTypes.length; i++) {
            DamageSeverity resType = DamageSeverity.DEFAULT;
            if (vulnerable.contains(damageTypes[i].toLowerCase(Locale.ROOT))) {
                resType = DamageSeverity.VULNERABLE;
            } else if (resist.contains(damageTypes[i].toLowerCase(Locale.ROOT))) {
                resType = DamageSeverity.RESISTANT;
            } else if (immune.contains(damageTypes[i].toLowerCase(Locale.ROOT))) {
                resType = DamageSeverity.IMMUNE;
            }
            switch (damageTypes[i]) {
                case "fire":
                    res.setFire(resType);
                break;
                case "cold":
                    res.setCold(resType);
                    break;
                case "lightning":
                    res.setLightning(resType);
                    break;
                case "thunder":
                    res.setThunder(resType);
                    break;
                case "force":
                    res.setForce(resType);
                    break;
                case "bludgeoning":
                    res.setBludgeoning(resType);
                    break;
                case "piercing":
                    res.setPiercing(resType);
                    break;
                case "slashing":
                    res.setSlashing(resType);
                    break;
                case "poison":
                    res.setPoison(resType);
                    break;
                case "psychic":
                    res.setPsychic(resType);
                    break;
                case "necrotic":
                    res.setNecrotic(resType);
                    break;
                case "radiant":
                    res.setRadiant(resType);
                    break;
                case "acid":
                    res.setAcid(resType);
                    break;
                case "bludgeoning, piercing, slashing from nonmagical attacks":
                    res.setNonMagicSlashing(resType);
                    res.setNonMagicBludgeoning(resType);
                    res.setNonMagicPiercing(resType);
                    break;
            }
        }
    }

    private void parseTraits(MonsterXml source, Monster res) {
        List<Trait> traitList= new ArrayList<>();
        for (TraitXml trait : source.getTrait()){
            Trait t = parseTrait(trait);
            traitList.add(t);
        }
        for(Trait t: traitList){
            t.setMonster(res);
        }
        res.setTraits(traitList);
    }

    private Trait parseTrait(TraitXml trait) {
        Trait t = new Trait();
        t.setName(trait.getName());
        String desc = "";
        for (String s:
             trait.getText()) {
            desc += s;
        }
        t.setDescription(desc);
        return t;
    }

    private void parseLegendary(MonsterXml source, Monster res) {

    }

    private void parseReactions(MonsterXml source, Monster res) {

    }

    private void parseActions(MonsterXml source, Monster res) {

    }

    private void parseSaves(MonsterXml source, Monster res) {
        String saveList = source.getSave();
        //Check if we find each skill in the list
        String[] splitSaves = saveList.split(",");
        for (String splitSave : splitSaves) {
            var save = splitSave.trim();
            boolean hasNegativeMod = save.contains("-");
            var saveParts = save.split("[+-]");
            var saveName = saveParts[0];
            int skillNum = Integer.parseInt(saveParts[1]);
            if (hasNegativeMod) {
                skillNum *= -1;
            }
            switch (saveName.trim().toLowerCase(Locale.ROOT)) {
                case "str":
                    res.setStrengthSave(skillNum);
                    break;
                case "dex":
                    res.setDexteritySave(skillNum);
                    break;
                case "con":
                    res.setConstitutionSave(skillNum);
                    break;
                case "int":
                    res.setIntelligenceSave(skillNum);
                    break;
                case "wis":
                    res.setWisdomSave(skillNum);
                    break;
                case "cha":
                    res.setCharismaSave(skillNum);
                    break;

            }
        }
    }

    private void parseSkills(MonsterXml source, Monster res) {
        String skillList = source.getSkill();
        //Check if we find each skill in the list
        String[] splitSkills = skillList.split(",");
        for (String splitSkill : splitSkills) {
            var skill = splitSkill.trim();
            boolean hasNegativeMod = skill.contains("-");
            var skillParts = skill.split("[+-]");
            var skillName = skillParts[0];
            int skillNum = Integer.parseInt(skillParts[1]);
            if (hasNegativeMod) {
                skillNum *= -1;
            }
            switch (skillName.trim().toLowerCase(Locale.ROOT)) {
                case "athletics":
                    res.setAthletics(skillNum);
                    break;
                case "acrobatics":
                    res.setAcrobatics(skillNum);
                    break;
                case "arcana":
                    res.setArcana(skillNum);
                    break;
                case "animal handling":
                    res.setAnimalHandling(skillNum);
                    break;
                case "deception":
                    res.setDeception(skillNum);
                    break;
                case "history":
                    res.setHistory(skillNum);
                    break;
                case "insight":
                    res.setInsight(skillNum);
                    break;
                case "intimidation":
                    res.setIntimidation(skillNum);
                    break;
                case "investigation":
                    res.setInvestigation(skillNum);
                    break;
                case "medicine":
                    res.setMedicine(skillNum);
                    break;
                case "nature":
                    res.setNature(skillNum);
                    break;
                case "perception":
                    res.setPerception(skillNum);
                    break;
                case "performance":
                    res.setPerformance(skillNum);
                    break;
                case "persuasion":
                    res.setPersuasion(skillNum);
                    break;
                case "religion":
                    res.setReligion(skillNum);
                    break;
                case "sleight of hand":
                    res.setSleightOfHand(skillNum);
                    break;
                case "stealth":
                    res.setStealth(skillNum);
                    break;
                case "survival":
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
