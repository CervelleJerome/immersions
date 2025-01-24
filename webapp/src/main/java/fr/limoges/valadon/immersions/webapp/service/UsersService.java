package fr.limoges.valadon.immersions.webapp.service;

import fr.limoges.valadon.immersions.webapp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersService {

    @Autowired
    private RestTemplate restTemplate;

    // URL de base de ton API
    private final String API_BASE_URL = "http://localhost:8080/api/users";

    // Méthode pour enregistrer un utilisateur
    public Users registerUser(Users user) {
        return restTemplate.postForObject(API_BASE_URL + "/register", user, Users.class);
    }

    // Méthode pour récupérer un utilisateur par email
    public Users getUserByEmail(String email) {
        return restTemplate.getForObject(API_BASE_URL + "/email/" + email, Users.class);
    }
}
