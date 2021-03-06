package sb.monsterBrewer.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Action {
    @Id
    @Column(name = "id", nullable = false)
    @XmlTransient
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "monster_id")
    @XmlTransient
    private Monster monster;

    @Column(name = "attack")
    private String attack;

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
