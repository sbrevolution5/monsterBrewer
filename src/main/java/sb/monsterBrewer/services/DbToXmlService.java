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

    private void unparseDamageTypes(Monster source, MonsterXml res) {
        var vulnerable = new StringJoiner(" ");
        var immune = new StringJoiner(" ");
        var resist = new StringJoiner(" ");
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
        //check each type, if default ignore, if vulnerable add to v, etc
        Map<String, DamageSeverity> damageSeverityMap= new HashMap<>();
        for (String damageType : damageTypes) {
            DamageSeverity severity;
            switch (damageType) {
                case "fire" -> severity = source.getFire();
                case "cold" -> severity = source.getCold();
                case "lightning" -> severity = source.getLightning();
                case "thunder" -> severity = source.getThunder();
                case "force" -> severity = source.getForce();
                case "bludgeoning" -> severity = source.getBludgeoning();
                case "piercing" -> severity = source.getPiercing();
                case "slashing" -> severity = source.getSlashing();
                case "poison" -> severity = source.getPoison();
                case "psychic" -> severity = source.getPsychic();
                case "necrotic" -> severity = source.getNecrotic();
                case "radiant" -> severity = source.getRadiant();
                case "acid" -> severity = source.getAcid();
                case "bludgeoning, piercing, slashing from nonmagical attacks" -> severity = source.getNonMagicPiercing();
                default -> throw new IllegalStateException("Unexpected value: " + damageType);
            }
            damageSeverityMap.put(damageType,severity);

        }
        for (String damageType :
                damageTypes) {
            switch (damageSeverityMap.get(damageType)){
                case IMMUNE -> immune.add(damageType);
                case RESISTANT -> resist.add(damageType);
                case VULNERABLE -> vulnerable.add(damageType);
            }
        }
        res.setResist(resist.toString());
        res.setImmune(immune.toString());
        res.setVulnerable(vulnerable.toString());
    }

    private void unparseTraits(Monster source, MonsterXml res) {
        TraitXml[] traitList= new TraitXml[source.getTraits().size()];
        for (int i = 0; i < source.getTraits().size(); i++) {
            TraitXml t = unparseTrait(source.getTraits().get(i));
            traitList[i]=t;
        }
        res.setTrait(traitList);
    }

    private TraitXml unparseTrait(Trait trait) {
        TraitXml t = new TraitXml();
        t.setName(trait.getName());
        t.setText(trait.getDescription().split("\n"));
        return t;
    }

    private void unparseLegendaryActions(Monster source, MonsterXml res) {
        if (source.isHasLegendaryActions()){
            return;
        }
        LegendaryXml[] legendaryActions= new LegendaryXml[source.getLegendaryActions().size()];
        for (int i = 0; i < source.getLegendaryActions().size(); i++) {
            LegendaryXml l = unparseLegendary(source.getLegendaryActions().get(i));
            legendaryActions[i]=l;
        }
        res.setLegendary(legendaryActions);
    }

    private LegendaryXml unparseLegendary(LegendaryAction legendaryAction) {
        LegendaryXml l = new LegendaryXml();
        l.setName(legendaryAction.getName());
        l.setText(legendaryAction.getDescription().split("\n"));
        return l;
    }

    private void unparseReactions(Monster source, MonsterXml res) {

        ReactionXml[] reactions = new ReactionXml[source.getReactions().size()];
        for (int i = 0; i < source.getReactions().size(); i++) {
            ReactionXml a = unparseReaction(source.getReactions().get(i));
            reactions[i]=a;
        }
        res.setReaction(reactions);
    }

    private ReactionXml unparseReaction(Reaction reaction) {
        ReactionXml r = new ReactionXml();
        r.setName(reaction.getName());
        r.setText(reaction.getDescription().split("\n"));
        r.setAttack(reaction.getAttack());
        return r;
    }

    private void unparseActions(Monster source, MonsterXml res) {
        ActionXml[] actions = new ActionXml[source.getActions().size()];
        for (int i = 0; i < source.getActions().size(); i++) {
            ActionXml a = unparseAction(source.getActions().get(i));
            actions[i]=a;
        }
        res.setAction(actions);
    }

    private ActionXml unparseAction(Action action) {
        ActionXml r = new ActionXml();
        r.setName(action.getName());
        r.setText(action.getDescription().split("\n"));
        r.setAttack(action.getAttack());
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
