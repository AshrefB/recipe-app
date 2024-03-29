package com.ashref.recipeapp.controllers;

import com.ashref.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        log.debug(this.getClass().getName()+": Requesting the index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
