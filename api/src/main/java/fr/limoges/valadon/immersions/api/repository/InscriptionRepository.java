package fr.limoges.valadon.immersions.api.repository;


import fr.limoges.valadon.immersions.api.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
}