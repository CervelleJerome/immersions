package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Demande;
import fr.limoges.valadon.immersions.api.repository.DemandeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {

    private final DemandeRepository demandeRepository;

    public DemandeService(DemandeRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    public Optional<Demande> findById(Integer id) {
        return demandeRepository.findById(id);
    }

    public Demande save(Demande demande) {
        return demandeRepository.save(demande);
    }

    public void deleteById(Integer id) {
        demandeRepository.deleteById(id);
    }
}
