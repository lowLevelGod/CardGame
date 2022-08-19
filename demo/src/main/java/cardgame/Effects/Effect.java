package cardgame.Effects;

import cardgame.Coord;

public abstract class Effect {
    protected String name;
    protected int turns;

    public abstract void performEffect(Coord src);

    public String getName()
    {
        return name;
    }

    public int getTurns()
    {
        return turns;
    }

}
