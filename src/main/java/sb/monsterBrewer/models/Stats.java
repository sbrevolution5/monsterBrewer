package sb.monsterBrewer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stats {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public int strength;
    public int strengthSave;
    public int dexterity;
    public int dexteritySave;
    public int constitution;
    public int constitutionSave;
    public int intelligence;
    public int intelligenceSave;
    public int wisdom;
    public int wisdomSave;
    public int charisma;
    public int charismaSave;
    public int athletics;
    public int animalHandling;
    public int acrobatics;
    public int deception;
    public int history;
    public int insight;
    public int intimidation;
    public int medicine;
    public int nature;
    public int perception;
    public int performance;
    public int persuasion;
    public int religion;
    public int sleightOfHand;
    public int stealth;
    public int survival;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
