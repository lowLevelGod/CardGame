package com.example.demo.OnHitTypes;

import com.example.demo.Coord;
import com.example.demo.GameManager;
import com.example.demo.CardTypes.Troops.Troop;
import com.example.demo.DamageTypes.Damage;

public class BasicOnHit implements OnHitBehavior
{
    public void onHit(Coord src, Damage damage)
    {
        Troop troop = GameManager.getCardAtPos(src);
        troop.getProtection().addToProtection(-damage.getDamageAgainst(src));
    }
}
