package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Users;
import fr.limoges.valadon.immersions.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    // Récupérer tous les utilisateurs
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    // Récupérer un utilisateur par son ID
    public Optional<Users> getUserById(Integer id) {
        return usersRepository.findById(id);
    }

    // Créer un utilisateur
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    // Mettre à jour un utilisateur
    public Users updateUser(Integer id, Users userDetails) {
        return usersRepository.findById(id).map(user -> {
            user.setNomUser(userDetails.getNomUser());
            user.setEmailUser(userDetails.getEmailUser());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            user.setEtablissement(userDetails.getEtablissement());
            return usersRepository.save(user);
        }).orElse(null);
    }

    // Supprimer un utilisateur
    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }
}
