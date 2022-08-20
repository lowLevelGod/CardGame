package cardgame.CardTypes.Troops;

import java.util.ArrayList;

import cardgame.Card;
import cardgame.Coord;
import cardgame.CardTypes.ProtectionTypes.Protection;
import cardgame.DamageTypes.Damage;
import cardgame.Effects.Effect;
import cardgame.Effects.Passives.Passive;
import cardgame.OnDeathTypes.BasicOnDeath;
import cardgame.OnDeathTypes.OnDeathBehavior;
import cardgame.OnHitTypes.BasicOnHit;
import cardgame.OnHitTypes.OnHitBehavior;

public abstract class Troop extends Card {
    protected Protection protection;
    protected Damage damage;
    protected OnHitBehavior onHitBehavior;
    protected OnDeathBehavior onDeathBehavior;

    protected ArrayList<Passive> passiveEffects = new ArrayList<Passive>();
    protected ArrayList<Effect> activeEffects = new ArrayList<Effect>();

    public String getPrintString()
    {
        String result = super.getPrintString();

        result += ("BP: " + getProtection().getBaseProtection());
        result += "\n";
        
        result += ("BD: " + getDamage().getBaseDamage());
        result += "\n";

        result += "PE: ";
        for (Passive p : getPassives())
            result += p.getName() + " ";
        result += "\n";

        result += "AE: ";
        for (Effect a : getActives())
            result += a.getName() + " ";
        result += "\n";

        return result;
    }

    private void removeExpiredActiveEffects()
    {
        activeEffects.removeIf(a -> a.getTurns() <= 0);
    }

    public void performActiveEffects(Coord src)
    {
        for (Effect a : activeEffects)
            a.performEffect(src);
        
        removeExpiredActiveEffects();
    }

    public void performPassiveEffects()
    {
        for (Passive p : passiveEffects)
        {
            p.performEffect(this);
        }
    }

    public void addActiveEffect(Effect e)
    {
        activeEffects.add(e);
    }

    public void addPassiveEffect(Passive p)
    {
        passiveEffects.add(p);
    }

    public void onHit(Coord src, Damage damage)
    {
        onHitBehavior.onHit(src, damage);
        if (this.protection.getBaseProtection() <= 0)
            onDeathBehavior.onDeath(src);
    }

    public void onDeath(Coord src)
    {
        onDeathBehavior.onDeath(src);
    }

    public void addToBaseProtection(int val)
    {
        this.protection.addToProtection(val);
    }

    public void setOnHitBehavior(OnHitBehavior o)
    {
        onHitBehavior = o;
    }

    public void setOnDeathBehavior(OnDeathBehavior o)
    {
        onDeathBehavior = o;
    }

    public void setProtection(Protection p)
    {
        this.protection = p;
    }

    public void setDamage(Damage d)
    {
        this.damage = d;
    }

    public Protection getProtection()
    {
        return protection;
    }

    public Damage getDamage()
    {
        return damage;
    }

    public ArrayList<Passive> getPassives()
    {
        return passiveEffects;
    }

    public ArrayList<Effect> getActives()
    {
        return activeEffects;
    }

    public Troop()
    {
        onHitBehavior = new BasicOnHit();
        onDeathBehavior = new BasicOnDeath();
        this.damage = new Damage();
    }
    public Troop(int bp)
    {
        this();
        this.protection = new Protection(bp);
    }
}
