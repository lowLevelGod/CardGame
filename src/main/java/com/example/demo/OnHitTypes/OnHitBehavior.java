package com.example.demo.OnHitTypes;

import com.example.demo.Coord;
import com.example.demo.DamageTypes.Damage;

public interface OnHitBehavior {
    public void onHit(Coord src, Damage damage);
}