package cardgame.Effects.Debuffs;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.Damage;

public class Bleed extends Debuff {
    public void performEffect(Coord src)
    {
        final Damage damage = new Damage(1);

        Troop debuffedTroop = GameManager.getCardAtPos(src);
        if (debuffedTroop != null)
            debuffedTroop.onHit(src, damage);

        super.performEffect(src);
    }

    public Bleed(int t)
    {
        super(t);
        name = "Bleed";
    }
}
