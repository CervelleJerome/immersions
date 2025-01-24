package fr.limoges.valadon.immersions.webapp.controller;

import fr.limoges.valadon.immersions.webapp.model.Users;
import fr.limoges.valadon.immersions.webapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    // Afficher le formulaire d'inscription
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new Users());
        return "register"; // Renvoie vers le fichier register.html
    }

    // Gérer l'inscription
    @PostMapping("/register")
    public String registerUser(@ModelAttribute Users user, Model model) {
        Users registeredUser = usersService.registerUser(user);
        model.addAttribute("message", "Utilisateur enregistré avec succès : " + registeredUser.getNomUser());
        return "success"; // Redirige vers une page de succès
    }

    // Afficher le formulaire de connexion
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Renvoie vers le fichier login.html
    }

    // Gérer la connexion
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        Users user = usersService.getUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) { // Vérifie le mot de passe
            model.addAttribute("message", "Connexion réussie : " + user.getNomUser());
            return "dashboard"; // Redirige vers une page d'accueil utilisateur
        } else {
            model.addAttribute("error", "Email ou mot de passe incorrect.");
            return "login"; // Reste sur la page de connexion
        }
    }
}
