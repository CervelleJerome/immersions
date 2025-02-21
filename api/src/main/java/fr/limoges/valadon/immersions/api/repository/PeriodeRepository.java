package fr.limoges.valadon.immersions.api.repository;

import fr.limoges.valadon.immersions.api.model.Periode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodeRepository extends JpaRepository<Periode, Integer> {
}