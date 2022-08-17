package cardgame.CardTypes.Troops;

import cardgame.Card;
import cardgame.Coord;
import cardgame.OnDeathTypes.BasicOnDeath;
import cardgame.OnDeathTypes.OnDeathBehavior;
import cardgame.OnHitTypes.BasicOnHit;
import cardgame.OnHitTypes.OnHitBehavior;

public abstract class Troop extends Card {
    protected int basePower;
    protected OnHitBehavior onHitBehavior;
    protected OnDeathBehavior onDeathBehavior;

    public void onHit(Coord src, int damage)
    {
        onHitBehavior.onHit(src, damage);
        if (basePower <= 0)
            onDeathBehavior.onDeath(src);
    }

    public void onDeath(Coord src)
    {
        onDeathBehavior.onDeath(src);
    }

    public void addToBasePower(int val)
    {
        basePower += val;
    }

    public void setOnHitBehavior(OnHitBehavior o)
    {
        onHitBehavior = o;
    }

    public void setOnDeathBehavior(OnDeathBehavior o)
    {
        onDeathBehavior = o;
    }

    public int getBasePower()
    {
        return basePower;
    }

    public Troop(int bp)
    {
        onHitBehavior = new BasicOnHit();
        onDeathBehavior = new BasicOnDeath();
        basePower = bp;
    }
}
