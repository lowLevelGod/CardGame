package com.example.demo.RangeTypes;

import java.util.ArrayList;

import com.example.demo.Coord;
import com.example.demo.GameException;
import com.example.demo.GameManager;

public class Range1FullLane implements Range{
    public ArrayList<Coord> computeTroopsInRange(Coord src)
    {
        ArrayList<Coord> troopsInRange = new ArrayList<Coord>();
        for (int row = 0; row < GameManager.ROWS; ++row)
        {
            int rangeRow = GameManager.getNthOppositeTroop(new Coord(src.row, src.lane), row + 1);

            if (rangeRow != GameException.OUT_OF_BOUNDS)
            {
                Coord rangeCoords = new Coord(rangeRow, src.lane);
                troopsInRange.add(rangeCoords);
            }
        }

        return troopsInRange;
    }
}
