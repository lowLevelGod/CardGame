package com.example.demo.CardTypes.Spells;

import com.example.demo.Coord;
import com.example.demo.GameManager;
import com.example.demo.CardTypes.Troops.Troop;
import com.example.demo.DamageTypes.WaterDamage;

public class HealingRain extends Spell {
    public void performAbility(Coord src)
    {
        int sign = GameManager.getFieldSide(src);

        for (int row = 0; row < GameManager.MID; ++row)
        {
            for (int lane = 0; lane < GameManager.LANES; ++lane)
            {
                Coord healedCoords = new Coord(GameManager.MID + (row + 1) * sign, lane);
                Troop healedTroop = GameManager.getCardAtPos(healedCoords);

                if (healedTroop != null)
                {
                    healedTroop.onHit(healedCoords, this.damage);
                }
            }
        }
    }

    public HealingRain()
    {
        name = "Healing Rain";
        this.damage = new WaterDamage(-5);
    }
}
