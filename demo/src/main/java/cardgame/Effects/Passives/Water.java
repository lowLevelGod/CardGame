package cardgame.Effects.Passives;

import cardgame.CardTypes.ProtectionTypes.WaterProtection;
import cardgame.CardTypes.Troops.Troop;
import cardgame.DamageTypes.WaterDamage;

public class Water extends Passive{
    public void performEffect(Troop troop)
    {
        int currentBaseProtection = troop.getProtection().getBaseProtection();
        int currentBaseDamage = troop.getDamage().getBaseDamage();

        troop.setProtection(new WaterProtection(currentBaseProtection));
        troop.setDamage(new WaterDamage(currentBaseDamage));
    }

    public Water()
    {
        name = "Water";
    }
}
