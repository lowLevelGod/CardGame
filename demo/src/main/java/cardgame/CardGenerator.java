package cardgame;

import java.util.ArrayList;

import cardgame.CardTypes.Spells.HealingRain;
import cardgame.CardTypes.Spells.Spell;
import cardgame.CardTypes.Spells.Tsunami;
import cardgame.CardTypes.Spells.Volcano;
import cardgame.CardTypes.Troops.Giant;
import cardgame.CardTypes.Troops.Knight;
import cardgame.CardTypes.Troops.Thief;
import cardgame.CardTypes.Troops.Troop;
import cardgame.Effects.Passives.Fire;
import cardgame.Effects.Passives.NoPassive;
import cardgame.Effects.Passives.Passive;
import cardgame.Effects.Passives.Water;

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
