package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
}