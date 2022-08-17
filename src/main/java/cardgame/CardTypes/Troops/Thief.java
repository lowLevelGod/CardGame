package cardgame.CardTypes.Troops;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.AttackTypes.AttackBehavior;


public class Thief extends Troop{
    AttackBehavior attack;
    public void performAbility(Coord src)
    {
        attack.performAttack(src);
    }

    public Thief(int bp)
    {
        super(bp);
        name = "Thief";
    }
}