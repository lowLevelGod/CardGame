package cardgame.AttackTypes;

import cardgame.Coord;
import cardgame.GameException;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.Damage;

public class AttackAllLanes implements AttackBehavior
{
    public void performAttack(Coord src)
    {
        Troop attacker = GameManager.getCardAtPos(src);
        
        for (int lane = 0; lane < GameManager.LANES; ++lane)
        {
            int attackedRow = GameManager.getNthOppositeTroop(new Coord(src.row, lane), 1);

            if (attackedRow != GameException.OUT_OF_BOUNDS)
            {
                Coord attackedCoords = new Coord(attackedRow, lane);
                Troop attackedTroop = GameManager.getCardAtPos(attackedCoords);
    
                attackedTroop.onHit(attackedCoords, attacker.getDamage());
            }
        }
    }
}