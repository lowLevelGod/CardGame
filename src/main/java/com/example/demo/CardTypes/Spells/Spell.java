package com.example.demo.CardTypes.Spells;

import com.example.demo.Card;
import com.example.demo.DamageTypes.Damage;

public abstract class Spell extends Card{
    protected Damage damage;
    public String getPrintString()
    {
        String result = super.getPrintString();

        result += ("Type: " + damage.getName() + "\n");
        if (damage.getBaseDamage() < 0)
            result += ("Heal: " + -damage.getBaseDamage() + "\n");
        else
            result += ("Damage: " + damage.getBaseDamage() + "\n");

        return result;
    }
}
