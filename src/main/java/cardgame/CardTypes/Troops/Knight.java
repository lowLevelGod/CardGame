package cardgame.CardTypes.Troops;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.AttackTypes.AttackBehavior;

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
        name = "Knight";
    }
}
