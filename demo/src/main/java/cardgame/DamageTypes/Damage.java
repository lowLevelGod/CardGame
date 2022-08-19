package cardgame.DamageTypes;

import cardgame.Coord;

public class Damage {
    protected String name;
    protected int baseDamage;

    public int getDamageAgainst(Coord dest)
    {
        return baseDamage;
    }

    public int getBaseDamage()
    {
        return baseDamage;
    }

    public String getName()
    {
        return name;
    }

    public Damage()
    {
        name = "Basic";
        baseDamage = 1;
    }

    public Damage(int bd)
    {
        this();
        baseDamage = bd;
    }
}
