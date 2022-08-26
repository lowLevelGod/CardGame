package com.example.demo.Effects.Passives;

import com.example.demo.CardTypes.Troops.Troop;

public abstract class Passive{
    protected String name;

    public abstract void performEffect(Troop troop);

    @Override
    public boolean equals(Object e)
    {
        final Passive passive = (Passive)e;
        return this.name.equals(passive.name);
    }

    public String getName()
    {
        return name;
    }
}
