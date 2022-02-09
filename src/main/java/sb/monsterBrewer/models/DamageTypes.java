package sb.monsterBrewer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DamageTypes {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public DamageSeverity bludgeoning;
    public DamageSeverity piercing;
    public DamageSeverity slashing;
    public DamageSeverity nonmagicBludgeoning;
    public DamageSeverity nonmagicPiercing;
    public DamageSeverity nonmagicSlashing;
    public DamageSeverity thunder;
    public DamageSeverity force;
    public DamageSeverity lightning;
    public DamageSeverity necrotic;
    public DamageSeverity radiant;
    public DamageSeverity poison;
    public DamageSeverity acid;
    public DamageSeverity psychic;
    public DamageSeverity Cold;
    public DamageSeverity Fire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
