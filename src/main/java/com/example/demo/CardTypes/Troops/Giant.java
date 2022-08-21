package com.example.demo.CardTypes.Troops;

import com.example.demo.Coord;
import com.example.demo.AttackTypes.AttackAllLanes;
import com.example.demo.AttackTypes.AttackBehavior;

public class Giant extends Troop{
    AttackBehavior attack;
    public void performAbility(Coord src)
    {
        attack.performAttack(src);
    }

    public Giant(int bp)
    {
        super(bp);
        attack = new AttackAllLanes();
        name = "Giant";
    }
}