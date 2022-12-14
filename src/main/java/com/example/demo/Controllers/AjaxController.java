package com.example.demo.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.GameManager;
import com.example.demo.UsedCards;

@Controller
public class AjaxController {
    @RequestMapping(value = "/sendData", method = RequestMethod.POST)
    public String getSearchResultViaAjax(@RequestBody ArrayList<UsedCards> uc, Model model) {
        // for (UsedCards u : uc)
        // System.out.println(u.getHandPos() + u.getPlayer());

        GameManager.updateGameState(uc);
        return "cardgame";
    }
}