package cardgame;

import cardgame.CardTypes.Troops.Troop;

public class Map {
    private final int GRID_WIDTH = 3;
    private final int GRID_HEIGHT = 7;
    private final int MID = GRID_HEIGHT / 2;

    private Troop[][] grid;

    public Troop getCardAtPos(int row, int lane)
    {
        return grid[row][lane];
    }

    public void setCardAtPos(int row, int lane, Troop troop)
    {
        grid[row][lane] = troop;
    }

    public int getNthOppositeTroop(int srcRow, int srcLane, int n)
    {
        int result = GameException.OUT_OF_BOUNDS;
        int sign;
        if (srcRow < MID)
            sign = 1;
        else
            sign = -1;

        for (int row = 0; row < MID; ++row)
        {
            Troop attackedTroop = getCardAtPos(MID + (row + 1) * sign, srcLane);
            if (attackedTroop != null)
            {
                --n;
                if (n == 0)
                {
                    result = MID + (row + 1) * sign;
                    break;
                }
            }
        }

        return result;
    }
    
    public int getGridHeight() { return GRID_HEIGHT;}
    public int getGridWidth() { return GRID_WIDTH;}
    public int getGridMid() { return MID;}

    public Map()
    {
        grid = new Troop[GRID_HEIGHT][GRID_WIDTH];
    }

}
