package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
