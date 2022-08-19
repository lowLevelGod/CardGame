package cardgame.CardTypes.Troops;

import cardgame.Coord;
import cardgame.GameManager;
import cardgame.AttackTypes.AttackAllLanes;
import cardgame.AttackTypes.AttackBehavior;

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