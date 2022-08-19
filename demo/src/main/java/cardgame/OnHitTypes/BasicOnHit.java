package cardgame.OnHitTypes;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.Damage;

public class BasicOnHit implements OnHitBehavior
{
    public void onHit(Coord src, Damage damage)
    {
        Troop troop = GameManager.getCardAtPos(src);
        troop.getProtection().addToProtection(-damage.getDamageAgainst(src));
    }
}
