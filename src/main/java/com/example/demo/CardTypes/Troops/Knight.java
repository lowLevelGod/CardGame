package com.example.demo.CardTypes.Troops;

import com.example.demo.Coord;
import com.example.demo.AttackTypes.AttackBehavior;
import com.example.demo.AttackTypes.BasicAttack;

public class Knight extends Troop{
    private AttackBehavior attack;
    public void performAbility(Coord src)
    {
        attack.performAttack(src);
    }

    public void setAttackBehavior(AttackBehavior a)
    {
        attack = a;
    }

    public Knight(int bp)
    {
        super(bp);
        attack = new BasicAttack();
        name = "Knight";
    }
}
