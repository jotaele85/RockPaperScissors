package com.codetest.rps.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @Value("${application.controller.title}")
    private String title;

    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("title", this.title);
        return "index";
    }
}
