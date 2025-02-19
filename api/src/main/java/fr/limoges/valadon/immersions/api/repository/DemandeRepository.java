package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
