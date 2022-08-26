package com.example.demo.Effects;

import com.example.demo.Coord;
import com.example.demo.DamageTypes.Damage;

public abstract class Effect {
    protected String name;
    protected int turns;
    protected Damage damage;

    public abstract void performEffect(Coord src);

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object e)
    {
        final Effect effect = (Effect)e;
        return this.name.equals(effect.name);
    }

    public int getTurns()
    {
        return turns;
    }

}
