package com.example.demo.Effects.Debuffs;

import com.example.demo.Coord;
import com.example.demo.GameManager;
import com.example.demo.CardTypes.Troops.Troop;
import com.example.demo.DamageTypes.Damage;

public class Bleed extends Debuff {
    public void performEffect(Coord src)
    {
        Troop debuffedTroop = GameManager.getCardAtPos(src);
        if (debuffedTroop != null)
            debuffedTroop.onHit(src, damage);

        super.performEffect(src);
    }

    public Bleed(int t, Damage d)
    {
        super(t, d);
        name = "Bleed";
    }
}
