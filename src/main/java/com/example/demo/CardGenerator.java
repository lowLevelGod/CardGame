package com.example.demo;

import java.util.ArrayList;

import com.example.demo.CardTypes.Spells.HealingRain;
import com.example.demo.CardTypes.Spells.Spell;
import com.example.demo.CardTypes.Spells.Tsunami;
import com.example.demo.CardTypes.Spells.Volcano;
import com.example.demo.CardTypes.Troops.Giant;
import com.example.demo.CardTypes.Troops.Knight;
import com.example.demo.CardTypes.Troops.Thief;
import com.example.demo.CardTypes.Troops.Troop;
import com.example.demo.Effects.Passives.Fire;
import com.example.demo.Effects.Passives.NoPassive;
import com.example.demo.Effects.Passives.Passive;
import com.example.demo.Effects.Passives.Water;

public class CardGenerator {
    final int TROOPS = 3;
    final int SPELLS = 3;
    final int BP_MIN = 50;
    final int BP_MAX = 500;
    final int PASSIVES = 3;
    
    private Troop bareTroop()
    {
        int val = (int)(Math.random() * TROOPS);
        int bp = (int)(Math.random() * (BP_MAX - BP_MIN)) + BP_MIN;

        switch(val)
        {
            case 0:
                return new Knight(bp);
            case 1:
                return new Giant(bp);
            case 2:
                return new Thief(bp);
            default:
                return new Knight(bp);
        }
    }

    private ArrayList<Passive> barePassives()
    {
        ArrayList<Passive> result = new ArrayList<Passive>();
        int val = (int)(Math.random() * PASSIVES);

        switch(val)
        {
            case 0:
                result.add(new Fire());
                break;
            case 1:
                result.add(new Water());
                break;
            default:
                result.add(new NoPassive());
                break;
        }

        return result;
    }

    public Troop generateRandomTroop()
    {
        Troop troop = bareTroop();
        ArrayList<Passive> passives = barePassives();

        for (Passive p : passives)
            troop.addPassiveEffect(p);

        return troop;
    }

    public Spell bareSpell()
    {
        int val = (int)(Math.random() * SPELLS);

        switch(val)
        {
            case 0:
                return new Tsunami();
            case 1:
                return new Volcano();
            case 2:
                return new HealingRain();
            default:
                return new HealingRain();
        }
    }

    public Spell generateRandomSpell()
    {
        Spell spell = bareSpell();

        return spell;
    }
}
