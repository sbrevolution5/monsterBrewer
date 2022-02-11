package sb.monsterBrewer.dtos;

public class CompendiumXml {
    private String auto_indent;

    private String version;

    private MonsterXml[] monster;

    public String getAuto_indent ()
    {
        return auto_indent;
    }

    public void setAuto_indent (String auto_indent)
    {
        this.auto_indent = auto_indent;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    public MonsterXml[] getMonster ()
    {
        return monster;
    }

    public void setMonster (MonsterXml[] monster)
    {
        this.monster = monster;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [auto_indent = "+auto_indent+", version = "+version+", monster = "+monster+"]";
    }
}
