package com.example.demo.RangeTypes;

import java.util.ArrayList;

import com.example.demo.Coord;
import com.example.demo.GameException;
import com.example.demo.GameManager;

public class RangeAllLanes implements Range{
    public ArrayList<Coord> computeTroopsInRange(Coord src)
    {
        ArrayList<Coord> troopsInRange = new ArrayList<Coord>();
        for (int lane = 0; lane < GameManager.LANES; ++lane)
        {
            int rangeRow = GameManager.getNthOppositeTroop(new Coord(src.row, lane), 1);

            if (rangeRow != GameException.OUT_OF_BOUNDS)
            {
                Coord rangeCoords = new Coord(rangeRow, lane);    
                troopsInRange.add(rangeCoords);
            }
        }

        return troopsInRange;
    }
}
