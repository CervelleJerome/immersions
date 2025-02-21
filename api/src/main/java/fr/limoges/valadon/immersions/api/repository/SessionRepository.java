package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
}