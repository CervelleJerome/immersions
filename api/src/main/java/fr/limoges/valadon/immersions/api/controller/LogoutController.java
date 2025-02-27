package fr.limoges.valadon.immersions.api.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalider la session
        request.getSession().invalidate();

        // Supprimer l'authentification de Spring Security
        SecurityContextHolder.clearContext();

        // Supprimer le cookie de session
        response.setHeader("Set-Cookie", "JSESSIONID=; Path=/; HttpOnly; Max-Age=0");

        return "Déconnecté avec succès"; // Réponse sans redirection
    }
}