package sb.monsterBrewer.dtos;

import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

@XmlType(propOrder = {"name","text","attack"})
public class ActionXml {
    private String attack;

    private String name;

    private String[] text;

    public String getAttack ()
    {
        return attack;
    }

    public void setAttack (String attack)
    {
        this.attack = attack;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String[] getText ()
    {
        return text;
    }

    public void setText (String[] text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [attack = "+attack+", name = "+name+", text = "+ Arrays.toString(text) +"]";
    }
}
