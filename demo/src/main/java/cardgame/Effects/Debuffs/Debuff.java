package cardgame.Effects.Debuffs;

import java.util.ArrayList;

import cardgame.Coord;
import cardgame.CardTypes.Troops.Troop;
import cardgame.Effects.Effect;

public abstract class Debuff extends Effect{
    
    public void performEffect(Coord src)
    {
        --turns;
    }

    public Debuff(int t)
    {
        turns = t;
    }
}
