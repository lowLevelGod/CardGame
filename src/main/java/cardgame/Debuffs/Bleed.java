package cardgame.Debuffs;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;

public class Bleed extends Debuff {
    public int performDebuff()
    {
        final int damage = 1;
        for (Coord c : affectedTroops)
        {
            Troop debuffedTroop = GameManager.getCardAtPos(c);
            if (debuffedTroop != null)
                debuffedTroop.onHit(c, damage);
        }

        return super.performDebuff();
    }

    public Bleed(int t)
    {
        super(t);
    }
}
