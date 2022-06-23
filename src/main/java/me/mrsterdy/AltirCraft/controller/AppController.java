package me.mrsterdy.AltirCraft.controller;

import me.mrsterdy.AltirCraft.model.Server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class AppController {

    @GetMapping
    public String welcome(Model model) {
        model.addAttribute("server", Server.getServer());

        return "welcome";
    }

}
