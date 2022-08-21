package com.example.demo;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> inventory;

    public ArrayList<Card> getHand()
    {
        return hand;
    }

    public ArrayList<Card> getInventory()
    {
        return inventory;
    }
    
    public void setInventory(ArrayList<Card> i)
    {
        inventory = i;
    }

    public void addToInventory(Card c)
    {
        inventory.add(c);
    }

    public void addToHand(Card c)
    {
        hand.add(c);
    }

    public Card getRandomInventoryCard()
    {
        int sz = inventory.size();
        if (sz > 0)
        {
            int idx = (int)(Math.random() * sz);
            return inventory.get(idx);
        }

        return null;
    }

    public void fillHandFromInventory()
    {
        while (hand.size() < GameManager.PLAYER_HAND)
        {
            Card c = getRandomInventoryCard();
            if (c == null)
                break;
            hand.add(c);
            inventory.remove(c);
        }
    }

    public void removeFromHand(int idx)
    {
        hand.remove(idx);
    }

    public Player()
    {
        hand = new ArrayList<Card>();
        inventory = new ArrayList<Card>();
    }
}
