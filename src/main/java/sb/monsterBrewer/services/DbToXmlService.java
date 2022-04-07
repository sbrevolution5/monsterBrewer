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

    private void unparseLegendaryActions(Monster source, MonsterXml res) {
        if (source.isHasLegendaryActions()){
            return;
        }
        List<LegendaryXml> legendaryActions= new ArrayList<>();
        for (LegendaryAction legendary : source.getLegendaryActions()){
            LegendaryXml l = unparseLegendary(legendary);
            legendaryActions.add(l);
        }
        res.setLegendary((LegendaryXml[]) legendaryActions.toArray());
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
