package cardgame;

public abstract class Card {
    protected String name;
    protected int inventorySpace;

    public abstract void performAbility(Coord src);

    public String getName()
    {
        return name;
    }

    public String getPrintString()
    {
        return name + "\n";
    }
}

