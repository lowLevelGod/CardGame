package cardgame.CardTypes.Spells;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.Damage;
import cardgame.DamageTypes.FireDamage;

public class Volcano extends Spell {
    public void performAbility(Coord src)
    {
        for (int row = 0; row < GameManager.ROWS; ++row)
        {
            if (row != GameManager.ROWS / 2)
            {
                Troop troop = GameManager.getCardAtPos(new Coord(row, src.lane));
                if (troop != null)
                    troop.onHit(new Coord(row, src.lane), this.damage);
            }
        }
    }

    public Volcano()
    {
        this.damage = new FireDamage(5);
    }
}
