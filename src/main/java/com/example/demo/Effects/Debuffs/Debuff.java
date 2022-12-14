package com.example.demo.Effects.Debuffs;

import com.example.demo.Coord;
import com.example.demo.DamageTypes.Damage;
import com.example.demo.Effects.Effect;


public abstract class Debuff extends Effect{
    
    public void performEffect(Coord src)
    {
        --turns;
    }

    public Debuff(int t, Damage d)
    {
        turns = t;
        damage = d;
    }
}
