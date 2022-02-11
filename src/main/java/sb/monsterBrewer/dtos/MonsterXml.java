package sb.monsterBrewer.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MonsterXml {
    private String con;

    private String senses;

    private String hp;

    private String save;

    private String description;

    private String type;

    private String speed;

    private String conditionImmune;

    private String vulnerable;

    private String dex;

    private LegendaryXml legendary;

    private String skill;

    private TraitXml trait;

    private ActionXml action;

    private String spells;

    private String cha;

    private String wis;

    private String ac;

    private String immune;

    private ReactionXml reaction;

    private String languages;

    private String resist;

    private String passive;

    private String intel;

    private String cr;

    private String str;

    private String slots;

    private String environment;

    private String size;

    private String name;

    private String alignment;

    public String getCon ()
    {
        return con;
    }

    public void setCon (String con)
    {
        this.con = con;
    }

    public String getSenses ()
    {
        return senses;
    }

    public void setSenses (String senses)
    {
        this.senses = senses;
    }

    public String getHp ()
    {
        return hp;
    }

    public void setHp (String hp)
    {
        this.hp = hp;
    }

    public String getSave ()
    {
        return save;
    }

    public void setSave (String save)
    {
        this.save = save;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getSpeed ()
    {
        return speed;
    }

    public void setSpeed (String speed)
    {
        this.speed = speed;
    }

    public String getConditionImmune ()
    {
        return conditionImmune;
    }

    public void setConditionImmune (String conditionImmune)
    {
        this.conditionImmune = conditionImmune;
    }

    public String getVulnerable ()
    {
        return vulnerable;
    }

    public void setVulnerable (String vulnerable)
    {
        this.vulnerable = vulnerable;
    }

    public String getDex ()
    {
        return dex;
    }

    public void setDex (String dex)
    {
        this.dex = dex;
    }

    public LegendaryXml getLegendary ()
    {
        return legendary;
    }

    public void setLegendary (LegendaryXml legendary)
    {
        this.legendary = legendary;
    }

    public String getSkill ()
    {
        return skill;
    }

    public void setSkill (String skill)
    {
        this.skill = skill;
    }

    public TraitXml getTrait ()
    {
        return trait;
    }

    public void setTrait (TraitXml trait)
    {
        this.trait = trait;
    }

    public ActionXml getAction ()
    {
        return action;
    }

    public void setAction (ActionXml action)
    {
        this.action = action;
    }

    public String getSpells ()
    {
        return spells;
    }

    public void setSpells (String spells)
    {
        this.spells = spells;
    }

    public String getCha ()
    {
        return cha;
    }

    public void setCha (String cha)
    {
        this.cha = cha;
    }

    public String getWis ()
    {
        return wis;
    }

    public void setWis (String wis)
    {
        this.wis = wis;
    }

    public String getAc ()
    {
        return ac;
    }

    public void setAc (String ac)
    {
        this.ac = ac;
    }

    public String getImmune ()
    {
        return immune;
    }

    public void setImmune (String immune)
    {
        this.immune = immune;
    }

    public ReactionXml getReaction ()
    {
        return reaction;
    }

    public void setReaction (ReactionXml reaction)
    {
        this.reaction = reaction;
    }

    public String getLanguages ()
    {
        return languages;
    }

    public void setLanguages (String languages)
    {
        this.languages = languages;
    }

    public String getResist ()
    {
        return resist;
    }

    public void setResist (String resist)
    {
        this.resist = resist;
    }

    public String getPassive ()
    {
        return passive;
    }

    public void setPassive (String passive)
    {
        this.passive = passive;
    }

    public String getIntel ()
    {
        return intel;
    }

    public void setInt (String intel)
    {
        this.intel = intel;
    }

    public String getCr ()
    {
        return cr;
    }

    public void setCr (String cr)
    {
        this.cr = cr;
    }

    public String getStr ()
    {
        return str;
    }

    public void setStr (String str)
    {
        this.str = str;
    }

    public String getSlots ()
    {
        return slots;
    }

    public void setSlots (String slots)
    {
        this.slots = slots;
    }

    public String getEnvironment ()
    {
        return environment;
    }

    public void setEnvironment (String environment)
    {
        this.environment = environment;
    }

    public String getSize ()
    {
        return size;
    }

    public void setSize (String size)
    {
        this.size = size;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAlignment ()
    {
        return alignment;
    }

    public void setAlignment (String alignment)
    {
        this.alignment = alignment;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [con = "+con+", senses = "+senses+", hp = "+hp+", save = "+save+", description = "+description+", type = "+type+", speed = "+speed+", conditionImmune = "+conditionImmune+", vulnerable = "+vulnerable+", dex = "+dex+", legendary = "+legendary+", skill = "+skill+", trait = "+trait+", action = "+action+", spells = "+spells+", cha = "+cha+", wis = "+wis+", ac = "+ac+", immune = "+immune+", reaction = "+reaction+", languages = "+languages+", resist = "+resist+", passive = "+passive+", intel = "+intel+", cr = "+cr+", str = "+str+", slots = "+slots+", environment = "+environment+", size = "+size+", name = "+name+", alignment = "+alignment+"]";
    }
}