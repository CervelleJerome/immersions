package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Enseignant;
import fr.limoges.valadon.immersions.api.repository.EnseignantRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EnseignantService {
    private final EnseignantRepository enseignantRepository;

    public EnseignantService(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    public Optional<Enseignant> getEnseignantById(int id) {
        return enseignantRepository.findById(id);
    }

    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    public void deleteEnseignant(int id) {
        enseignantRepository.deleteById(id);
    }
}