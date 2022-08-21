package com.example.demo.Effects.Passives;

import com.example.demo.CardTypes.ProtectionTypes.WaterProtection;
import com.example.demo.CardTypes.Troops.Troop;
import com.example.demo.DamageTypes.WaterDamage;

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
