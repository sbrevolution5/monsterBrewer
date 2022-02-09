package sb.monsterBrewer.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String senses;


    @Column(name = "name")
    private String name;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "stats_id")
    private Stats stats;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "damage_types_id")
    private DamageTypes damageTypes;

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

    public DamageTypes getDamageTypes() {
        return damageTypes;
    }

    public void setDamageTypes(DamageTypes damageTypes) {
        this.damageTypes = damageTypes;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
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
}
