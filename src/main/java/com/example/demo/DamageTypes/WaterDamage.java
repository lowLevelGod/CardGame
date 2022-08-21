package com.example.demo.DamageTypes;

import com.example.demo.Coord;
import com.example.demo.GameManager;

public class WaterDamage extends Damage{
    public int getDamageAgainst(Coord dest)
    {
        // actual damage
        if (this.baseDamage > 0)
        {
            switch(GameManager.getCardAtPos(dest).getProtection().getName())
            {
                case "Fire":
                    return baseDamage * 2;
                default:
                    return baseDamage;
            }
        }else
        {
            // this one is for healing
            switch(GameManager.getCardAtPos(dest).getProtection().getName())
            {
                case "Water":
                    return baseDamage * 2;
                default:
                    return baseDamage;
            }
        }
    }

    public WaterDamage()
    {
        super();
        name = "Water";
    }

    public WaterDamage(int bd)
    {
        this();
        baseDamage = bd;
    }
}
