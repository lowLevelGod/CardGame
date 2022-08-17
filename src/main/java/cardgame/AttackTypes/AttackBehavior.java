package cardgame.AttackTypes;

import cardgame.Coord;
import cardgame.GameException;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;

public interface AttackBehavior {
    public void performAttack(Coord src);
}