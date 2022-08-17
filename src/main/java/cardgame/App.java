package cardgame;

import cardgame.AttackTypes.BasicAttack;
import cardgame.CardTypes.Spells.Spell;
import cardgame.CardTypes.Spells.Volcano;
import cardgame.CardTypes.Troops.Giant;
import cardgame.CardTypes.Troops.Knight;
import cardgame.CardTypes.Troops.Thief;
import cardgame.Debuffs.Bleed;
import cardgame.Debuffs.Debuff;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // System.out.println("Hello World!")

        GameManager.setCardAtPos(new Coord(0, 1), new Giant(2));
        GameManager.setCardAtPos(new Coord(1, 1), new Knight(100));
        GameManager.setCardAtPos(new Coord(2, 1), new Thief(50));

        // Knight ourKnight = new Knight(400);
        // GameManager.setCardAtPos(4, 0, ourKnight);
        Giant ourGiant = new Giant(300);
        GameManager.setCardAtPos(new Coord(4, 1), ourGiant);
        
        // ourKnight.setAttackBehavior(new BasicAttack());
        
        GameManager.renderMap();
        // Spell volcano = new Volcano();
        // volcano.performAbility(new Coord(-1, 1));
        // ourGiant.performAbility(4, 1);
        // ourKnight.performAbility(6, 0);
        
        Debuff bleed = new Bleed(3);

        bleed.addAffectedTroop(new Coord(0, 1));
        bleed.addAffectedTroop(new Coord(1, 1));
        bleed.addAffectedTroop(new Coord(2, 1));
        bleed.addAffectedTroop(new Coord(4, 1));

        while (bleed.performDebuff() > 0)
            GameManager.renderMap();
        
        // JFrame frame = new JFrame("Testing");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.add(new GamePane());
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.pack();
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);
    }
}
