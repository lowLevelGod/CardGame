package cardgame.AttackTypes;

import cardgame.Coord;
import cardgame.GameException;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.Damage;

public class BasicAttack implements AttackBehavior
{
    public void performAttack(Coord src)
    {
        Troop attacker = GameManager.getCardAtPos(src);

        int attackedRow = GameManager.getNthOppositeTroop(src, 1);

        if (attackedRow != GameException.OUT_OF_BOUNDS)
        {
            Coord attackedCoords = new Coord(attackedRow, src.lane);
            Troop attackedTroop = GameManager.getCardAtPos(new Coord(attackedRow, src.lane));

            attackedTroop.onHit(attackedCoords, attacker.getDamage());
        }
    }
}