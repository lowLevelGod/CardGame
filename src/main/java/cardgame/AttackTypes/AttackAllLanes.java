package cardgame.AttackTypes;

import cardgame.Coord;
import cardgame.GameException;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;

public class AttackAllLanes implements AttackBehavior
{
    public void performAttack(Coord src)
    {
        for (int lane = 0; lane < GameManager.LANES; ++lane)
        {
            int attackedRow = GameManager.getNthOppositeTroop(new Coord(src.row, lane), 1);

            if (attackedRow != GameException.OUT_OF_BOUNDS)
            {
                Troop attackedTroop = GameManager.getCardAtPos(new Coord(attackedRow, lane));
                attackedTroop.onHit(new Coord(attackedRow, lane), 1);
            }
        }
    }
}