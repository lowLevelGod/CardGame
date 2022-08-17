package cardgame.AttackTypes;

import cardgame.Coord;
import cardgame.GameException;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;

public class BasicAttack implements AttackBehavior
{
    public void performAttack(Coord src)
    {
        int attackedRow = GameManager.getNthOppositeTroop(src, 1);

        if (attackedRow != GameException.OUT_OF_BOUNDS)
        {
            Troop attackedTroop = GameManager.getCardAtPos(new Coord(attackedRow, src.lane));
            attackedTroop.onHit(new Coord(attackedRow, src.lane), 1);
        }
    }
}