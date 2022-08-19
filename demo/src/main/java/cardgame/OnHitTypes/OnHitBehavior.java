package cardgame.OnHitTypes;

import cardgame.Coord;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.Damage;

public interface OnHitBehavior {
    public void onHit(Coord src, Damage damage);
}