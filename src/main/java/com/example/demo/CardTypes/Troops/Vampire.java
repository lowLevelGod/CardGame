package com.example.demo.CardTypes.Troops;

import java.util.ArrayList;

import com.example.demo.Coord;
import com.example.demo.GameManager;
import com.example.demo.Effects.Debuffs.Bleed;
import com.example.demo.RangeTypes.Range1FullLane;

public class Vampire extends Troop{

    private final int bleedTurns = 5;
    private int coolDown = 0;

    public void performAbility(Coord src)
    {
        ArrayList<Coord> troopsInRange = range.computeTroopsInRange(src);
        for (Coord c : troopsInRange)
        {
            Troop attackedTroop = GameManager.getCardAtPos(c);
            if (attackedTroop != null)
            {
                attackedTroop.onHit(c, this.damage);
                if (coolDown % bleedTurns == 0)
                {
                    applyBleed(attackedTroop);
                }else
                    ++coolDown;
            }
        }
    }

    private void applyBleed(Troop t)
    {
        final int bleedChance = 5;
        int val = (int)(Math.random() * bleedChance);

        if (val == 0)
        {
            coolDown = 1;
            Bleed bleed = new Bleed(bleedTurns, this.damage);
            t.removeDuplicateActiveEffects(bleed);
            t.addActiveEffect(bleed);
        }
    }

    public Vampire()
    {
        super();
        range = new Range1FullLane();
        name = "Vampire";
    }

    public Vampire(int bp)
    {
        super(bp);
        range = new Range1FullLane();
        name = "Vampire";
    }
}
