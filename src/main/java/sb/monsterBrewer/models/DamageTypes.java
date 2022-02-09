package sb.monsterBrewer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DamageTypes {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public DamageSeverity bludgeoning = DamageSeverity.DEFAULT;
    public DamageSeverity piercing= DamageSeverity.DEFAULT;
    public DamageSeverity slashing= DamageSeverity.DEFAULT;
    public DamageSeverity nonmagicBludgeoning= DamageSeverity.DEFAULT;
    public DamageSeverity nonmagicPiercing= DamageSeverity.DEFAULT;
    public DamageSeverity nonmagicSlashing= DamageSeverity.DEFAULT;
    public DamageSeverity thunder= DamageSeverity.DEFAULT;
    public DamageSeverity force= DamageSeverity.DEFAULT;
    public DamageSeverity lightning= DamageSeverity.DEFAULT;
    public DamageSeverity necrotic= DamageSeverity.DEFAULT;
    public DamageSeverity radiant= DamageSeverity.DEFAULT;
    public DamageSeverity poison= DamageSeverity.DEFAULT;
    public DamageSeverity acid= DamageSeverity.DEFAULT;
    public DamageSeverity psychic= DamageSeverity.DEFAULT;
    public DamageSeverity Cold= DamageSeverity.DEFAULT;
    public DamageSeverity Fire= DamageSeverity.DEFAULT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
