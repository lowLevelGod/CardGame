package cardgame;

import cardgame.CardTypes.Troops.Troop;

public class GameManager {
    private static CardGenerator cardGenerator;
    private static Map map;
    public static final int LANES = 3;
    public static final int ROWS = 7;
    public static final int MID = ROWS / 2;

    public static void removeTroopAtPos(Coord src)
    {
        map.setCardAtPos(src.row, src.lane, null);
    }

    public static Troop getCardAtPos(Coord src)
    {
        return map.getCardAtPos(src.row, src.lane);
    }

    public static void setCardAtPos(Coord src, Troop troop)
    {
        map.setCardAtPos(src.row, src.lane, troop);
    }

    public static int getNthOppositeTroop(Coord src, int n)
    {
        return map.getNthOppositeTroop(src.row, src.lane, n);
    }

    public static int getFieldSide(Coord src)
    {
        return map.getFieldSide(src.row, src.lane);
    }

    public static void renderMap()
    {
        for (int row = 0; row < map.getGridHeight(); ++row)
        {
            if (row == map.getGridMid())
                System.out.println("----------------------------------------------------"); 
            else
            {
                for (int lane = 0; lane < map.getGridWidth(); ++lane)
                {
                    Troop tmp = GameManager.getCardAtPos(new Coord(row, lane));
                    if (tmp == null)
                        System.out.print("No troop here!" + " ");
                    else
                        System.out.print(tmp.getName() + " BP: " + tmp.getProtection().getBaseProtection() + " ");
                }
                System.out.println("");
            }
        }
        System.out.println("");
    }

    public static Troop getRandomTroop()
    {
        Troop generatedTroop = cardGenerator.generateRandomTroop();
        return generatedTroop;
    }

    static
    {
        map = new Map();
        cardGenerator = new CardGenerator();
    }
}
