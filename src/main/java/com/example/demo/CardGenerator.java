package com.example.demo;

import java.util.ArrayList;

import com.example.demo.CardTypes.ProtectionTypes.Protection;
import com.example.demo.CardTypes.Spells.HealingRain;
import com.example.demo.CardTypes.Spells.Spell;
import com.example.demo.CardTypes.Spells.Tsunami;
import com.example.demo.CardTypes.Spells.Volcano;
import com.example.demo.CardTypes.Troops.Giant;
import com.example.demo.CardTypes.Troops.Knight;
import com.example.demo.CardTypes.Troops.Thief;
import com.example.demo.CardTypes.Troops.Troop;
import com.example.demo.CardTypes.Troops.Vampire;
import com.example.demo.Effects.Passives.Fire;
import com.example.demo.Effects.Passives.NoPassive;
import com.example.demo.Effects.Passives.Passive;
import com.example.demo.Effects.Passives.Water;

public class CardGenerator {
    final int BP_MIN = 50;
    final int BP_MAX = 500;
    
    private Troop bareTroop()
    {
        Troop[] troopList = {new Knight(), new Giant(), 
            new Thief(), new Vampire()};

        int val = (int)(Math.random() * troopList.length);
        int bp = (int)(Math.random() * (BP_MAX - BP_MIN)) + BP_MIN;
        
        Troop chosenTroop = troopList[val];
        chosenTroop.setProtection(new Protection(bp));

        return chosenTroop;
    }

    private ArrayList<Passive> barePassives()
    {
        Passive[] passiveList = {new Fire(), new Water(),
             new NoPassive()};

        ArrayList<Passive> result = new ArrayList<Passive>();
        int val = (int)(Math.random() * passiveList.length);

        Passive chosenPassive = passiveList[val];
        result.add(chosenPassive);

        return result;
    }

    public Troop generateRandomTroop()
    {
        Troop troop = bareTroop();
        ArrayList<Passive> passives = barePassives();

        for (Passive p : passives)
            troop.addPassiveEffect(p);

        troop.performPassiveEffects(); // might move this later   
        return troop;
    }

    public Spell bareSpell()
    {
        Spell[] spellList = {new Tsunami(), new Volcano(),
             new HealingRain()};
        int val = (int)(Math.random() * spellList.length);
        Spell chosenSpell = spellList[val];
        
        return chosenSpell;
    }

    public Spell generateRandomSpell()
    {
        Spell spell = bareSpell();

        return spell;
    }
}
