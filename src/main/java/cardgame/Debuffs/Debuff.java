package cardgame.Debuffs;

import java.util.ArrayList;

import cardgame.Coord;
import cardgame.CardTypes.Troops.Troop;

public abstract class Debuff {
    protected ArrayList<Coord> affectedTroops = new ArrayList<Coord>();
    protected int turns;

    public int performDebuff()
    {
        --turns;
        return turns;
    }

    public void addAffectedTroop(Coord c)
    {
        affectedTroops.add(c);
    }

    public Debuff(int t)
    {
        turns = t;
    }
}
