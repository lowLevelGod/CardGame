package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.example.demo.CardTypes.Spells.Spell;
import com.example.demo.CardTypes.Troops.Troop;

public class GameManager {
    private static CardGenerator cardGenerator;
    private static Map map;
    public static final int LANES = 3;
    public static final int ROWS = 7;
    public static final int MID = ROWS / 2;
    public static final int PLAYER_HAND = 5;
    public static final int INVENTORY_MAX = 20;
    private static Player playerUp;
    private static Player playerDown;

    public static ArrayList<Card> getRandomInventory()
    {
        ArrayList<Card> inventory = new ArrayList<Card>();
        for (int i = 0; i < INVENTORY_MAX; ++i)
        {
            Card c = null;
            int val = (int)(Math.random() * 5);
            switch(val)
            {
                case 0:
                case 1:
                case 2:
                case 3:
                    c = getRandomTroop();
                    break;
                default:
                    c = getRandomSpell();
                    break;
            }

            inventory.add(c);
        }

        return inventory;
    }

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

    public static void useCardAbilities()
    {
        for (int row = 0; row < ROWS; ++row)
            for (int lane = 0; lane < LANES; ++lane)
            {
                Coord troopCoords = new Coord(row, lane);
                Troop t = getCardAtPos(troopCoords);
                if (t != null)
                    t.performAbility(troopCoords);
            }
    }

    public static void updateGameState(ArrayList<UsedCards> usedCards)
    {
        ArrayList<Integer> playerUpIdx = new ArrayList<Integer>();
        ArrayList<Integer> playerDownIdx = new ArrayList<Integer>();

        for (UsedCards u : usedCards)
        {
            Coord mapCoords = u.getDestCoords();
            int handIdx = u.getHandPos();
            Player player = null;
            if (u.getPlayer().trim().equals("Up"))
            {
                playerUpIdx.add(handIdx);
                player = playerUp;
            }
            else
            {
                playerDownIdx.add(handIdx);
                player = playerDown;
            }
            Troop troop = (Troop)player.getHand().get(handIdx);
            GameManager.setCardAtPos(mapCoords, troop);
        }

        Collections.sort(playerUpIdx, Collections.reverseOrder());
        Collections.sort(playerDownIdx, Collections.reverseOrder());

        for (int i : playerUpIdx)
        {
            playerUp.removeFromHand(i);
        }
        for (int i : playerDownIdx)
        {
            playerDown.removeFromHand(i);
        }

        playerUp.fillHandFromInventory();
        playerDown.fillHandFromInventory();
    }

    public static Player getPlayerUp()
    {
        return playerUp;
    }

    
    public static Player getPlayerDown()
    {
        return playerDown;
    }

    public static Troop getRandomTroop()
    {
        Troop generatedTroop = cardGenerator.generateRandomTroop();
        return generatedTroop;
    }

    public static Spell getRandomSpell()
    {
        Spell generatedSpell = cardGenerator.generateRandomSpell();
        return generatedSpell;
    }

    public static void generatedRandomPlayers()
    {
        playerUp = new Player();
        playerUp.setInventory(GameManager.getRandomInventory());
        playerUp.fillHandFromInventory();

        playerDown = new Player();
        playerDown.setInventory(GameManager.getRandomInventory());
        playerDown.fillHandFromInventory();
    }

    public static ArrayList<Troop> getFieldArray()
    {
        ArrayList<Troop> result = new ArrayList<Troop>();
        for (int row = 0; row < ROWS; ++row)
            for (int lane = 0; lane < LANES; ++lane)
                result.add(getCardAtPos(new Coord(row, lane)));
        return result;
    }

    public static void cleanMap()
    {
        for (int row = 0; row < ROWS; ++row)
            for (int lane = 0; lane < LANES; ++lane)
                setCardAtPos(new Coord(row, lane), null);
    }

    static
    {
        map = new Map();
        cardGenerator = new CardGenerator();
    }
}
