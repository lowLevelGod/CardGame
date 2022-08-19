package cardgame.OnDeathTypes;

import cardgame.Coord;
import cardgame.GameManager;

public class BasicOnDeath implements OnDeathBehavior
{
    public void onDeath(Coord src)
    {
        GameManager.removeTroopAtPos(src);
    }
}
