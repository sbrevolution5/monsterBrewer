package sb.monsterBrewer.services;

import sb.monsterBrewer.dtos.*;
import sb.monsterBrewer.models.*;

import java.util.*;

public class DbToXmlService {
    public MonsterXml unparseMonster(Monster source) {
        MonsterXml res = new MonsterXml();
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
        res.setType(source.getType());
        res.setSize(source.getSize());
        res.setCr(source.getCr());
        unparseStats(source, res);
        unparseSaves(source, res);
        unparseSkills(source, res);
        unparseActions(source, res);
        unparseLegendaryActions(source, res);
        unparseTraits(source, res);
        unparseReactions(source, res);
        unparseDamageTypes(source, res);

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
        if (source.getTrait()==null){
            return;
        }
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
        if (source.getLegendary() == null){
            res.setHasLegendaryActions(false);
            return;
        }else{
            res.setHasLegendaryActions(true);
        }
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
        if (source.getReaction() == null){
            return;
        }
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

    private void unparseSaves(Monster source, MonsterXml res) {
        StringJoiner sb = new StringJoiner(" ");
        String[] saveList = new String[]{"str","dex","con","int","wis","cha"};
        for(String saveName:saveList){
            int saveNum=0;
            switch (saveName) {
                case "str" -> saveNum = source.getStrengthSave();
                case "dex" -> saveNum = source.getDexteritySave();
                case "con" -> saveNum = source.getConstitutionSave();
                case "int" -> saveNum = source.getIntelligenceSave();
                case "wis" -> saveNum = source.getWisdomSave();
                case "cha" -> saveNum = source.getCharismaSave();
            }
            if (saveNum!=0){
                sb.add(saveName);
                String op = "+";
                if (saveNum<0){
                    op="-";
                }
                sb.add(op+saveNum);

            }
        }
        res.setSave(sb.toString());
    }

    private void unparseSkills(Monster source, MonsterXml res) {
        StringJoiner sb = new StringJoiner(" ");
        //Check if we find each skill in the list
        String[] skillList = new String[]{"athletics", "acrobatics","arcana","animal handling", "deception","history","insight","intimidation","investigation","medicine","nature","perception","performance","persuasion","religion","sleight of hand","stealth","survival"};
        for(String skillName:skillList){
            int skillNum=0;
            switch (skillName) {
                case "athletics" -> skillNum = source.getAthletics();
                case "acrobatics" -> skillNum = source.getAcrobatics();
                case "arcana" -> skillNum = source.getArcana();
                case "animal handling" -> skillNum = source.getAnimalHandling();
                case "deception" -> skillNum = source.getDeception();
                case "history" -> skillNum = source.getHistory();
                case "insight" -> skillNum = source.getInsight();
                case "intimidation" -> skillNum = source.getIntimidation();
                case "investigation" -> skillNum = source.getInvestigation();
                case "medicine" -> skillNum = source.getMedicine();
                case "nature" -> skillNum = source.getNature();
                case "perception" -> skillNum = source.getPerception();
                case "performance" -> skillNum = source.getPerformance();
                case "persuasion" -> skillNum = source.getPersuasion();
                case "religion" -> skillNum = source.getReligion();
                case "sleight of hand" -> skillNum = source.getSleightOfHand();
                case "stealth" -> skillNum = source.getStealth();
                case "survival" -> skillNum = source.getSurvival();
            }
            if (skillNum!=0){
                sb.add(skillName);
                String op = "+";
                if (skillNum<0){
                    op="-";
                }
                sb.add(op+skillNum);

            }
        }
        res.setSkill(sb.toString());

    }

    private void unparseStats(Monster source, MonsterXml res) {
        res.setDex(String.valueOf(source.getDexterity()));
        res.setStr(String.valueOf(source.getStrength()));
        res.setCon(String.valueOf(source.getConstitution()));
        res.setCha(String.valueOf(source.getCharisma()));
        res.setWis(String.valueOf(source.getWisdom()));
        res.setInt(String.valueOf(source.getIntelligence()));
    }
}
