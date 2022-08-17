package cardgame.OnHitTypes;

import cardgame.Coord;
import cardgame.CardTypes.Troops.Troop;

public interface OnHitBehavior {
    public void onHit(Coord src, int damage);
}