package cardgame;

public abstract class Card {
    protected String name;
    protected int provisions;

    public abstract void performAbility(Coord src);

    public String getName()
    {
        return name;
    }
}

