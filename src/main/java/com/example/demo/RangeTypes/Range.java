package com.example.demo.RangeTypes;

import java.util.ArrayList;

import com.example.demo.Coord;

public interface Range {
    public abstract ArrayList<Coord> computeTroopsInRange(Coord src);
}
