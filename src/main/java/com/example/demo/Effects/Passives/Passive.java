package com.example.demo.Effects.Passives;

import com.example.demo.CardTypes.Troops.Troop;

public abstract class Passive{
    protected String name;

    public abstract void performEffect(Troop troop);

    public String getName()
    {
        return name;
    }
}
