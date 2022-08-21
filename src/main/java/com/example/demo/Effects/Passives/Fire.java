package com.example.demo.Effects.Passives;

import com.example.demo.CardTypes.ProtectionTypes.FireProtection;
import com.example.demo.CardTypes.Troops.Troop;
import com.example.demo.DamageTypes.FireDamage;

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
