package sb.monsterBrewer.models;

import java.util.ArrayList;

public class Monster {
    public int id;
    public String name;
    public String race;
    public String alignment;
    public String size;
    public String ac;
    public String hp;
    public String speed;
    public ArrayList<Action> actions;
    public ArrayList<LegendaryAction> legendaryActions;
    public ArrayList<Trait> traits;
    public String senses;
    public Stats stats;
    public DamageTypes damageTypes;
    public ConditionImmunities conditionImmunities;
}
