package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Inscription;
import fr.limoges.valadon.immersions.api.repository.InscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    public InscriptionService(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    public Optional<Inscription> getInscriptionById(Integer id) {
        return inscriptionRepository.findById(id);
    }

    public Inscription saveInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    public void deleteInscription(Integer id) {
        inscriptionRepository.deleteById(id);
    }
}