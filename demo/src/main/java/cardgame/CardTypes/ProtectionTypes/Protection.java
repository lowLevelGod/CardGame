package cardgame.CardTypes.ProtectionTypes;

public class Protection {
    protected String name;
    protected int baseProtection;

    public Protection()
    {
        name = "Basic";
        baseProtection = 100;
    }

    public Protection(int bp)
    {
        this();
        baseProtection = bp;
    }

    public String getName()
    {
        return name;
    }

    public int getBaseProtection()
    {
        return baseProtection;
    }

    public void addToProtection(int val)
    {
        baseProtection += val;
    }
}
