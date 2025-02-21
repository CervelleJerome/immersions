package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Periode;
import fr.limoges.valadon.immersions.api.repository.PeriodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeriodeService {
    private final PeriodeRepository periodeRepository;

    public PeriodeService(PeriodeRepository periodeRepository) {
        this.periodeRepository = periodeRepository;
    }

    public List<Periode> getAllPeriodes() {
        return periodeRepository.findAll();
    }

    public Optional<Periode> getPeriodeById(int id) {
        return periodeRepository.findById(id);
    }

    public Periode savePeriode(Periode periode) {
        return periodeRepository.save(periode);
    }

    public void deletePeriode(int id) {
        periodeRepository.deleteById(id);
    }
}