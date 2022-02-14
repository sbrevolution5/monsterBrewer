package sb.monsterBrewer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compendium {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "compendium", orphanRemoval = true)
    private List<Monster> monsters = new ArrayList<>();

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
