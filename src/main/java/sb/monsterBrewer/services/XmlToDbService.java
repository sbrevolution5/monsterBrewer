package sb.monsterBrewer.services;

import sb.monsterBrewer.dtos.*;
import sb.monsterBrewer.models.*;

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
        parseLegendaryActions(source, res);
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
        for (String damageType : damageTypes) {
            DamageSeverity resType = DamageSeverity.DEFAULT;
            if (vulnerable.contains(damageType.toLowerCase(Locale.ROOT))) {
                resType = DamageSeverity.VULNERABLE;
            } else if (resist.contains(damageType.toLowerCase(Locale.ROOT))) {
                resType = DamageSeverity.RESISTANT;
            } else if (immune.contains(damageType.toLowerCase(Locale.ROOT))) {
                resType = DamageSeverity.IMMUNE;
            }
            switch (damageType) {
                case "fire" -> res.setFire(resType);
                case "cold" -> res.setCold(resType);
                case "lightning" -> res.setLightning(resType);
                case "thunder" -> res.setThunder(resType);
                case "force" -> res.setForce(resType);
                case "bludgeoning" -> res.setBludgeoning(resType);
                case "piercing" -> res.setPiercing(resType);
                case "slashing" -> res.setSlashing(resType);
                case "poison" -> res.setPoison(resType);
                case "psychic" -> res.setPsychic(resType);
                case "necrotic" -> res.setNecrotic(resType);
                case "radiant" -> res.setRadiant(resType);
                case "acid" -> res.setAcid(resType);
                case "bludgeoning, piercing, slashing from nonmagical attacks" -> {
                    res.setNonMagicSlashing(resType);
                    res.setNonMagicBludgeoning(resType);
                    res.setNonMagicPiercing(resType);
                }
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
        StringBuilder desc = new StringBuilder();
        for (String s:
             trait.getText()) {
            desc.append(s);
        }
        t.setDescription(desc.toString());
        return t;
    }

    private void parseLegendaryActions(MonsterXml source, Monster res) {
        List<LegendaryAction> legendaryActions= new ArrayList<>();
        for (LegendaryXml legendaryXml : source.getLegendary()){
            LegendaryAction l = parseLegendary(legendaryXml);
            legendaryActions.add(l);
        }
        for(LegendaryAction l: legendaryActions){
            l.setMonster(res);
        }
        res.setLegendaryActions(legendaryActions);
    }

    private LegendaryAction parseLegendary(LegendaryXml legendaryXml) {
        LegendaryAction l = new LegendaryAction();
        l.setName(legendaryXml.getName());
        StringBuilder desc = new StringBuilder();
        for (String s:
                legendaryXml.getText()) {
            desc.append(s);
        }
        l.setDescription(desc.toString());
        return l;
    }

    private void parseReactions(MonsterXml source, Monster res) {
        List<Reaction> reactions = new ArrayList<>();
        for (ReactionXml reactionXml :
                source.getReaction()) {
            Reaction r = parseReaction(reactionXml);
            reactions.add(r);
        }
        for (Reaction r:
             reactions) {
            r.setMonster(res);
        }
        res.setReactions(reactions);
    }

    private Reaction parseReaction(ReactionXml reactionXml) {
        Reaction r = new Reaction();
        r.setName(reactionXml.getName());
        StringBuilder desc = new StringBuilder();
        for (String s :
                reactionXml.getText()) {
            desc.append(s);
        }
        r.setDescription(desc.toString());
        r.setAttack(reactionXml.getAttack());
        return r;
    }

    private void parseActions(MonsterXml source, Monster res) {
        List<Action> actions = new ArrayList<>();
        for (ActionXml actionXml :
                source.getAction()) {
            Action a = parseAction(actionXml);
            actions.add(a);
        }
        for (Action a:
                actions) {
            a.setMonster(res);
        }
        res.setActions(actions);
    }

    private Action parseAction(ActionXml actionXml) {
        Action r = new Action();
        r.setName(actionXml.getName());
        StringBuilder desc = new StringBuilder();
        for (String s :
                actionXml.getText()) {
            desc.append(s);
        }
        r.setDescription(desc.toString());
        r.setAttack(actionXml.getAttack());
        return r;
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
                case "str" -> res.setStrengthSave(skillNum);
                case "dex" -> res.setDexteritySave(skillNum);
                case "con" -> res.setConstitutionSave(skillNum);
                case "int" -> res.setIntelligenceSave(skillNum);
                case "wis" -> res.setWisdomSave(skillNum);
                case "cha" -> res.setCharismaSave(skillNum);
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
                case "athletics" -> res.setAthletics(skillNum);
                case "acrobatics" -> res.setAcrobatics(skillNum);
                case "arcana" -> res.setArcana(skillNum);
                case "animal handling" -> res.setAnimalHandling(skillNum);
                case "deception" -> res.setDeception(skillNum);
                case "history" -> res.setHistory(skillNum);
                case "insight" -> res.setInsight(skillNum);
                case "intimidation" -> res.setIntimidation(skillNum);
                case "investigation" -> res.setInvestigation(skillNum);
                case "medicine" -> res.setMedicine(skillNum);
                case "nature" -> res.setNature(skillNum);
                case "perception" -> res.setPerception(skillNum);
                case "performance" -> res.setPerformance(skillNum);
                case "persuasion" -> res.setPersuasion(skillNum);
                case "religion" -> res.setReligion(skillNum);
                case "sleight of hand" -> res.setSleightOfHand(skillNum);
                case "stealth" -> res.setStealth(skillNum);
                case "survival" -> res.setSurvival(skillNum);
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
