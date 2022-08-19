package cardgame.Effects.Passives;

import cardgame.CardTypes.Troops.Troop;

public abstract class Passive{
    protected String name;

    public abstract void performEffect(Troop troop);

    public String getName()
    {
        return name;
    }
}
