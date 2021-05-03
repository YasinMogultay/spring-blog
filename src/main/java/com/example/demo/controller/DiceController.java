package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String dicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String diceGuess(@PathVariable int n, Model model) {
        int randomNumber = (int) (Math.random() * (7 - 1) + 1);
        model.addAttribute("randomNum", "The dice roll is " + randomNumber); // string is what we will be pass in the html with expression language
        model.addAttribute("userGuess", "Your guess was " + n);   // and the object is what data we passing to that variable

        boolean correctGuess = randomNumber == n;
        boolean wrongGuess = randomNumber != n;
        model.addAttribute("correctGuess", correctGuess);
        model.addAttribute("wrongGuess", wrongGuess);
        return "/roll-dice";
    }

}
