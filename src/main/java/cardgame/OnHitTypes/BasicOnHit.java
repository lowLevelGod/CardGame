package cardgame.OnHitTypes;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;

public class BasicOnHit implements OnHitBehavior
{
    public void onHit(Coord src, int damage)
    {
        Troop troop = GameManager.getCardAtPos(src);
        troop.addToBasePower(-damage);
    }

    public void onHit(Troop troop, int damage)
    {
        troop.addToBasePower(-damage);
    }
}
