package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.TypeEtablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEtablissementRepository extends JpaRepository<TypeEtablissement, Integer> {


}