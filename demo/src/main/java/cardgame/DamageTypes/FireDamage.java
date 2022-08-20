package cardgame.DamageTypes;

import cardgame.Coord;
import cardgame.GameManager;

public class FireDamage extends Damage{
    public int getDamageAgainst(Coord dest)
    {
        // actual damage
        if (this.baseDamage > 0)
        {
            switch(GameManager.getCardAtPos(dest).getProtection().getName())
            {
                case "Water":
                    return baseDamage * 2;
                default:
                    return baseDamage;
            }
        }else
        {
            // this one is for healing
            switch(GameManager.getCardAtPos(dest).getProtection().getName())
            {
                case "Fire":
                    return baseDamage * 2;
                default:
                    return baseDamage;
            }
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
