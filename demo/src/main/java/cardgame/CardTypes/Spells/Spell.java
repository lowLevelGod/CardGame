package cardgame.CardTypes.Spells;

import cardgame.Card;
import cardgame.DamageTypes.Damage;

public abstract class Spell extends Card{
    protected Damage damage;
    public String getPrintString()
    {
        String result = super.getPrintString();

        result += ("Type: " + damage.getName() + "\n");
        if (damage.getBaseDamage() < 0)
            result += ("Heal: " + -damage.getBaseDamage() + "\n");
        else
            result += ("Damage: " + damage.getBaseDamage() + "\n");

        return result;
    }
}
