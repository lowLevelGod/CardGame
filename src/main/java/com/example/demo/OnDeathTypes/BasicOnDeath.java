package com.example.demo.OnDeathTypes;

import com.example.demo.Coord;
import com.example.demo.GameManager;

public class BasicOnDeath implements OnDeathBehavior
{
    public void onDeath(Coord src)
    {
        GameManager.removeTroopAtPos(src);
    }
}
