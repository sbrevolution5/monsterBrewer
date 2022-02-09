package sb.monsterBrewer.models;

import javax.persistence.*;

@Entity
public class Trait {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "monster_id")
    private Monster monster;

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
