package fr.limoges.valadon.immersions.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Bienvenue sur notre site");
        return "home"; // Affiche la page home.html
    }
}
