package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
