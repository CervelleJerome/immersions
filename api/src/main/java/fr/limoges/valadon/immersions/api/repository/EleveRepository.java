package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Integer> {
    List<Eleve> findByNomEleve(String nomEleve);
    List<Eleve> findByPrenomEleve(String prenomEleve);
    List<Eleve> findByEtablissement_IdEtablissement(int idEtablissement);  // Mise à jour ici
}
