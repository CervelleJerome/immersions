package fr.limoges.valadon.immersions.webapp.repository;

import fr.limoges.valadon.immersions.webapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
