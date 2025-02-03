package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineClasseRepository extends JpaRepository<Domaine, Integer> {

}
