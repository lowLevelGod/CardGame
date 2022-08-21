package com.example.demo.CardTypes.Spells;

import com.example.demo.Coord;
import com.example.demo.GameManager;
import com.example.demo.CardTypes.Troops.Troop;
import com.example.demo.DamageTypes.FireDamage;

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
        name = "Volcano";
        this.damage = new FireDamage(5);
    }
}
