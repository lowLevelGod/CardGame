package cardgame.DamageTypes;

import cardgame.Coord;
import cardgame.GameManager;

public class WaterDamage extends Damage{
    public int getDamageAgainst(Coord dest)
    {
        switch(GameManager.getCardAtPos(dest).getProtection().getName())
        {
            case "Fire":
                return baseDamage * 2;
            default:
                return baseDamage;
        }
    }

    public WaterDamage()
    {
        super();
        name = "Water";
    }

    public WaterDamage(int bd)
    {
        this();
        baseDamage = bd;
    }
}
