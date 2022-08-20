package cardgame.CardTypes.Spells;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.WaterDamage;

public class Tsunami extends Spell {
    public void performAbility(Coord src)
    {
        for (int lane = 0; lane < GameManager.LANES; ++lane)
        {
            Coord spellCoords = new Coord(src.row, lane);

            int row = GameManager.getNthOppositeTroop(spellCoords, 1);

            Coord affectedCoords = new Coord(row, lane);
            Troop troop = GameManager.getCardAtPos(affectedCoords);
            if (troop != null)
                troop.onHit(affectedCoords, this.damage);
        }
    }

    public Tsunami()
    {
        this.damage = new WaterDamage(5);
    }
}
