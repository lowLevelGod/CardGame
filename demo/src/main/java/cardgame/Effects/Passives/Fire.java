package cardgame.Effects.Passives;

import cardgame.Coord;
import cardgame.CardTypes.ProtectionTypes.FireProtection;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.FireDamage;

public class Fire extends Passive{

    public void performEffect(Troop troop)
    {
        int currentBaseProtection = troop.getProtection().getBaseProtection();
        int currentBaseDamage = troop.getDamage().getBaseDamage();

        troop.setProtection(new FireProtection(currentBaseProtection));
        troop.setDamage(new FireDamage(currentBaseDamage));
    }

    public Fire()
    {
        name = "Fire";
    }
}
