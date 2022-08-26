package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.GameManager;

@Controller
public class Controllercls {

	@GetMapping("/")
	public String greeting(Model model) {
        
        // Troop t1 = new Giant(2);
        // Troop t2 = new Knight(100);
        // Troop t3 = new Thief(50);

        // t1.addPassiveEffect(new Water());
        // t2.addPassiveEffect(new Fire());
        // t3.addPassiveEffect(new Fire());

        // t1.performPassiveEffects();
        // t2.performPassiveEffects();
        // t3.performPassiveEffects();

        // // System.out.println(t1.getPrintString());
        // // System.out.println(t2.getPrintString());
        // // System.out.println(t3.getPrintString());

        // GameManager.setCardAtPos(new Coord(0, 0), t1);
        // GameManager.setCardAtPos(new Coord(2, 1), t2);
        // GameManager.setCardAtPos(new Coord(1, 2), t3);

        // // Knight ourKnight = new Knight(400);
        // // GameManager.setCardAtPos(4, 0, ourKnight);
        // Giant ourGiant = new Giant(300);
        // ourGiant.addPassiveEffect(new Water());
        // ourGiant.performPassiveEffects();

        // // System.out.println(ourGiant.getPrintString());

        // GameManager.setCardAtPos(new Coord(4, 1), ourGiant);

        // GameManager.setCardAtPos(new Coord(6, 2), GameManager.getRandomTroop());
        
        // // ourKnight.setAttackBehavior(new BasicAttack());
        
        // // GameManager.renderMap();

        // // ourGiant.performAbility(new Coord(4, 1));
        // // ourGiant.addActiveEffect(new Bleed(1));

        // new HealingRain().performAbility(new Coord(0, -1));

        // String result = "";
        // for (Card c : GameManager.getRandomInventory())
        //     result += (c.getPrintString());

        // new Volcano().performAbility(new Coord(-1,2));
        // new Tsunami().performAbility(new Coord(6, 2));
        
        // System.out.println(ourGiant.getPrintString());

        // ourGiant.performActiveEffects(new Coord(4, 1));

        // System.out.println(ourGiant.getPrintString());
        // System.out.println(t1.getPrintString());
        // System.out.println(t2.getPrintString());
        // System.out.println(t3.getPrintString());

        // GameManager.renderMap();
        // Spell volcano = new Volcano();
        // volcano.performAbility(new Coord(-1, 1));
        // ourGiant.performAbility(4, 1);
        // ourKnight.performAbility(6, 0);
        
        // Debuff bleed = new Bleed(3);

        // GameManager.getCardAtPos(new Coord(0, 1)).addActiveEffect(bleed);
        // GameManager.getCardAtPos(new Coord(1, 1)).addActiveEffect(bleed);
        // GameManager.getCardAtPos(new Coord(2, 1)).addActiveEffect(bleed);
        // GameManager.getCardAtPos(new Coord(4, 1)).addActiveEffect(bleed);

        // int cnt = 5;
        // while (cnt > 0)
        // {
        //     Troop t1, t2, t3, t4;
        //     t1 = GameManager.getCardAtPos(new Coord(0, 1));
        //     t2 = GameManager.getCardAtPos(new Coord(1, 1));
        //     t3 = GameManager.getCardAtPos(new Coord(2, 1));
        //     t4 = GameManager.getCardAtPos(new Coord(4, 1));

        //     if (t1 != null)
        //     {
        //         t1.performActiveEffects(new Coord(0, 1));
        //     }

        //     if (t2 != null)
        //     {
        //         t2.performActiveEffects(new Coord(1, 1));
        //     }

        //     if (t3 != null)
        //     {
        //         t3.performActiveEffects(new Coord(2, 1));
        //     }

        //     if (t4 != null)
        //     {
        //         t4.performActiveEffects(new Coord(4, 1));
        //     }

        //     GameManager.renderMap();

        //     --cnt;
        // }
		// model.addAttribute("name", result);
        GameManager.resetGame();
        model.addAttribute("playerUp", GameManager.getPlayerUp());
        model.addAttribute("playerDown", GameManager.getPlayerDown());
        
		return "cardgame";
	}

    @GetMapping("/cardgame")
	public String cardGame(Model model) {

        GameManager.useCardAbilities();
        model.addAttribute("playerUp", GameManager.getPlayerUp());
        model.addAttribute("playerDown", GameManager.getPlayerDown());
        model.addAttribute("field", GameManager.getFieldArray());
        model.addAttribute("logText", GameManager.getLogText());

		return "cardgame";
	}

}