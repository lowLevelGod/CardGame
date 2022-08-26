package com.example.demo.CardTypes.Troops;

import java.util.ArrayList;

import com.example.demo.Coord;
import com.example.demo.GameManager;
import com.example.demo.RangeTypes.RangeAllLanes;

public class Giant extends Troop{

    public void performAbility(Coord src)
    {
        ArrayList<Coord> troopsInRange = range.computeTroopsInRange(src);
        for (Coord c : troopsInRange)
        {
            Troop attackedTroop = GameManager.getCardAtPos(c);
            if (attackedTroop != null)
            {
                String eventString = this.name + " damages " + attackedTroop.getName()
                 + " for " + this.damage.getDamageAgainst(c) + "\n";

                GameManager.appendLog(eventString);
                attackedTroop.onHit(c, this.damage);
            }
        }
    }

    public Giant()
    {
        super();
        range = new RangeAllLanes();
        name = "Giant";
    }

    public Giant(int bp)
    {
        super(bp);
        range = new RangeAllLanes();
        name = "Giant";
    }
}