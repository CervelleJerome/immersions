package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Integer> {
}
