package com.example.demo.CardTypes.Troops;

import com.example.demo.Coord;
import com.example.demo.AttackTypes.AttackBehavior;
import com.example.demo.AttackTypes.BasicAttack;


public class Thief extends Troop{
    AttackBehavior attack;
    public void performAbility(Coord src)
    {
        attack.performAttack(src);
    }

    public Thief(int bp)
    {
        super(bp);
        attack = new BasicAttack();
        name = "Thief";
    }
}