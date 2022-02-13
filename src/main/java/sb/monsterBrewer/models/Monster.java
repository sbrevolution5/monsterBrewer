package sb.monsterBrewer.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement(name="monster")
public class Monster {
    @Id @GeneratedValue
    private Long id;
    private String race;
    private String alignment;
    private String size;
    private String ac;
    private String hp;
    private String speed;
    private String senses;
    private boolean hasLegendaryActions;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "monster", orphanRemoval = true)
    private List<Action> actions = new ArrayList<>();

    @OneToMany(mappedBy = "monster", orphanRemoval = true)
    private List<LegendaryAction> legendaryActions = new ArrayList<>();

    @OneToMany(mappedBy = "monster", orphanRemoval = true)
    private List<Trait> traits = new ArrayList<>();

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    public List<LegendaryAction> getLegendaryActions() {
        return legendaryActions;
    }

    public void setLegendaryActions(List<LegendaryAction> legendaryActions) {
        this.legendaryActions = legendaryActions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }


    public String getSenses() {
        return senses;
    }

    public void setSenses(String senses) {
        this.senses = senses;
    }

    private int strength;
    private int strengthSave;
    private int dexterity;
    private int dexteritySave;
    private int constitution;
    private int constitutionSave;
    private int intelligence;
    private int intelligenceSave;
    private int wisdom;
    private int wisdomSave;
    private int charisma;
    private int charismaSave;
    private int athletics;
    private int animalHandling;
    private int acrobatics;
    private int deception;
    private int history;
    private int insight;
    private int intimidation;
    private int investigation;
    private int medicine;
    private int nature;
    private int perception;
    private int performance;
    private int persuasion;
    private int religion;
    private int sleightOfHand;
    private int stealth;
    private int survival;



    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthSave() {
        return strengthSave;
    }

    public void setStrengthSave(int strengthSave) {
        this.strengthSave = strengthSave;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexteritySave() {
        return dexteritySave;
    }

    public void setDexteritySave(int dexteritySave) {
        this.dexteritySave = dexteritySave;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getConstitutionSave() {
        return constitutionSave;
    }

    public void setConstitutionSave(int constitutionSave) {
        this.constitutionSave = constitutionSave;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligenceSave() {
        return intelligenceSave;
    }

    public void setIntelligenceSave(int intelligenceSave) {
        this.intelligenceSave = intelligenceSave;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdomSave() {
        return wisdomSave;
    }

    public void setWisdomSave(int wisdomSave) {
        this.wisdomSave = wisdomSave;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharismaSave() {
        return charismaSave;
    }

    public void setCharismaSave(int charismaSave) {
        this.charismaSave = charismaSave;
    }

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public int getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(int animalHandling) {
        this.animalHandling = animalHandling;
    }

    public int getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(int acrobatics) {
        this.acrobatics = acrobatics;
    }

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(int sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }
    private DamageSeverity bludgeoning = DamageSeverity.DEFAULT;
    private DamageSeverity piercing= DamageSeverity.DEFAULT;
    private DamageSeverity slashing= DamageSeverity.DEFAULT;
    private DamageSeverity nonMagicBludgeoning= DamageSeverity.DEFAULT;
    private DamageSeverity nonMagicPiercing= DamageSeverity.DEFAULT;
    private DamageSeverity nonMagicSlashing= DamageSeverity.DEFAULT;
    private DamageSeverity thunder= DamageSeverity.DEFAULT;
    private DamageSeverity force= DamageSeverity.DEFAULT;
    private DamageSeverity lightning= DamageSeverity.DEFAULT;
    private DamageSeverity necrotic= DamageSeverity.DEFAULT;
    private DamageSeverity radiant= DamageSeverity.DEFAULT;
    private DamageSeverity poison= DamageSeverity.DEFAULT;
    private DamageSeverity acid= DamageSeverity.DEFAULT;
    private DamageSeverity psychic= DamageSeverity.DEFAULT;
    private DamageSeverity Cold= DamageSeverity.DEFAULT;
    private DamageSeverity Fire= DamageSeverity.DEFAULT;


    public DamageSeverity getBludgeoning() {
        return bludgeoning;
    }

    public void setBludgeoning(DamageSeverity bludgeoning) {
        this.bludgeoning = bludgeoning;
    }

    public DamageSeverity getPiercing() {
        return piercing;
    }

    public void setPiercing(DamageSeverity piercing) {
        this.piercing = piercing;
    }

    public DamageSeverity getSlashing() {
        return slashing;
    }

    public void setSlashing(DamageSeverity slashing) {
        this.slashing = slashing;
    }

    public DamageSeverity getNonMagicBludgeoning() {
        return nonMagicBludgeoning;
    }

    public void setNonMagicBludgeoning(DamageSeverity nonMagicBludgeoning) {
        this.nonMagicBludgeoning = nonMagicBludgeoning;
    }

    public DamageSeverity getNonMagicPiercing() {
        return nonMagicPiercing;
    }

    public void setNonMagicPiercing(DamageSeverity nonMagicPiercing) {
        this.nonMagicPiercing = nonMagicPiercing;
    }

    public DamageSeverity getNonMagicSlashing() {
        return nonMagicSlashing;
    }

    public void setNonMagicSlashing(DamageSeverity nonMagicSlashing) {
        this.nonMagicSlashing = nonMagicSlashing;
    }

    public DamageSeverity getThunder() {
        return thunder;
    }

    public void setThunder(DamageSeverity thunder) {
        this.thunder = thunder;
    }

    public DamageSeverity getForce() {
        return force;
    }

    public void setForce(DamageSeverity force) {
        this.force = force;
    }

    public DamageSeverity getLightning() {
        return lightning;
    }

    public void setLightning(DamageSeverity lightning) {
        this.lightning = lightning;
    }

    public DamageSeverity getNecrotic() {
        return necrotic;
    }

    public void setNecrotic(DamageSeverity necrotic) {
        this.necrotic = necrotic;
    }

    public DamageSeverity getRadiant() {
        return radiant;
    }

    public void setRadiant(DamageSeverity radiant) {
        this.radiant = radiant;
    }

    public DamageSeverity getPoison() {
        return poison;
    }

    public void setPoison(DamageSeverity poison) {
        this.poison = poison;
    }

    public DamageSeverity getAcid() {
        return acid;
    }

    public void setAcid(DamageSeverity acid) {
        this.acid = acid;
    }

    public DamageSeverity getPsychic() {
        return psychic;
    }

    public void setPsychic(DamageSeverity psychic) {
        this.psychic = psychic;
    }

    public DamageSeverity getCold() {
        return Cold;
    }

    public void setCold(DamageSeverity cold) {
        Cold = cold;
    }

    public DamageSeverity getFire() {
        return Fire;
    }

    public void setFire(DamageSeverity fire) {
        Fire = fire;
    }
    private boolean blinded;
    private boolean charmed;
    private boolean deafened;
    private boolean frightened;
    private boolean grappled;
    private boolean incapacitated;
    private boolean invisible;
    private boolean paralyzed;
    private boolean petrified;
    private boolean poisoned;
    private boolean prone;
    private boolean restrained;
    private boolean stunned;
    private boolean unconscious;

    @Column(name = "passive")
    private String passive;

    private boolean exhaustion;

    @Column(name = "description")
    private String description;

    @Column(name = "environment")
    private String environment;

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBlinded() {
        return blinded;
    }

    public void setBlinded(boolean blinded) {
        this.blinded = blinded;
    }

    public boolean isCharmed() {
        return charmed;
    }

    public void setCharmed(boolean charmed) {
        this.charmed = charmed;
    }

    public boolean isDeafened() {
        return deafened;
    }

    public void setDeafened(boolean deafened) {
        this.deafened = deafened;
    }

    public boolean isFrightened() {
        return frightened;
    }

    public void setFrightened(boolean frightened) {
        this.frightened = frightened;
    }

    public boolean isGrappled() {
        return grappled;
    }

    public void setGrappled(boolean grappled) {
        this.grappled = grappled;
    }

    public boolean isIncapacitated() {
        return incapacitated;
    }

    public void setIncapacitated(boolean incapacitated) {
        this.incapacitated = incapacitated;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    public boolean isParalyzed() {
        return paralyzed;
    }

    public void setParalyzed(boolean paralyzed) {
        this.paralyzed = paralyzed;
    }

    public boolean isPetrified() {
        return petrified;
    }

    public void setPetrified(boolean petrified) {
        this.petrified = petrified;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }

    public boolean isProne() {
        return prone;
    }

    public void setProne(boolean prone) {
        this.prone = prone;
    }

    public boolean isRestrained() {
        return restrained;
    }

    public void setRestrained(boolean restrained) {
        this.restrained = restrained;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public boolean isUnconscious() {
        return unconscious;
    }

    public void setUnconscious(boolean unconscious) {
        this.unconscious = unconscious;
    }

    public boolean isExhaustion() {
        return exhaustion;
    }

    public void setExhaustion(boolean exhaustion) {
        this.exhaustion = exhaustion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public boolean isHasLegendaryActions() {
        return hasLegendaryActions;
    }

    public void setHasLegendaryActions(boolean hasLegendaryActions) {
        this.hasLegendaryActions = hasLegendaryActions;
    }

    public int getInvestigation() {
        return investigation;
    }

    public void setInvestigation(int investigation) {
        this.investigation = investigation;
    }
}
