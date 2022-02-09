package sb.monsterBrewer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Monster {
    @Id @GeneratedValue
    private Long id;
    private String race;
    private String alignment;
    private String size;
    private String ac;
    private String hp;
    private String speed;
    private ArrayList<Action> actions;
    private ArrayList<LegendaryAction> legendaryActions;
    private ArrayList<Trait> traits;
    private String senses;
    private Stats stats;
    private DamageTypes damageTypes;
    private ConditionImmunities conditionImmunities;

    @Column(name = "name")
    private String name;

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

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public ArrayList<LegendaryAction> getLegendaryActions() {
        return legendaryActions;
    }

    public void setLegendaryActions(ArrayList<LegendaryAction> legendaryActions) {
        this.legendaryActions = legendaryActions;
    }

    public ArrayList<Trait> getTraits() {
        return traits;
    }

    public void setTraits(ArrayList<Trait> traits) {
        this.traits = traits;
    }

    public String getSenses() {
        return senses;
    }

    public void setSenses(String senses) {
        this.senses = senses;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public DamageTypes getDamageTypes() {
        return damageTypes;
    }

    public void setDamageTypes(DamageTypes damageTypes) {
        this.damageTypes = damageTypes;
    }

    public ConditionImmunities getConditionImmunities() {
        return conditionImmunities;
    }

    public void setConditionImmunities(ConditionImmunities conditionImmunities) {
        this.conditionImmunities = conditionImmunities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
