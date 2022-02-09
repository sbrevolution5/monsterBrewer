package sb.monsterBrewer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DamageTypes {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
