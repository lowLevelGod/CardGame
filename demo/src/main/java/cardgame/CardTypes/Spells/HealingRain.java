package cardgame.CardTypes.Spells;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.WaterDamage;

public class HealingRain extends Spell {
    public void performAbility(Coord src)
    {
        int sign = GameManager.getFieldSide(src);

        for (int row = 0; row < GameManager.MID; ++row)
        {
            for (int lane = 0; lane < GameManager.LANES; ++lane)
            {
                Coord healedCoords = new Coord(GameManager.MID + (row + 1) * sign, lane);
                Troop healedTroop = GameManager.getCardAtPos(healedCoords);

                if (healedTroop != null)
                {
                    healedTroop.onHit(healedCoords, this.damage);
                }
            }
        }
    }

    public HealingRain()
    {
        this.damage = new WaterDamage(-5);
    }
}
