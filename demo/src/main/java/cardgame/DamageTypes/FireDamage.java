package cardgame.DamageTypes;

import cardgame.Coord;
import cardgame.GameManager;

public class FireDamage extends Damage{
    public int getDamageAgainst(Coord dest)
    {
        switch(GameManager.getCardAtPos(dest).getProtection().getName())
        {
            case "Water":
                return baseDamage * 2;
            default:
                return baseDamage;
        }
    }

    public FireDamage()
    {
        super();
        name = "Fire";
    }

    public FireDamage(int bd)
    {
        this();
        baseDamage = bd;
    }
}
