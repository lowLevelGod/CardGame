package com.example.demo.AttackTypes;

import com.example.demo.Coord;
import com.example.demo.GameException;
import com.example.demo.GameManager;
import com.example.demo.CardTypes.Troops.Troop;


public class BasicAttack implements AttackBehavior
{
    public void performAttack(Coord src)
    {
        Troop attacker = GameManager.getCardAtPos(src);

        int attackedRow = GameManager.getNthOppositeTroop(src, 1);

        if (attackedRow != GameException.OUT_OF_BOUNDS)
        {
            Coord attackedCoords = new Coord(attackedRow, src.lane);
            Troop attackedTroop = GameManager.getCardAtPos(new Coord(attackedRow, src.lane));

            attackedTroop.onHit(attackedCoords, attacker.getDamage());
        }
    }
}