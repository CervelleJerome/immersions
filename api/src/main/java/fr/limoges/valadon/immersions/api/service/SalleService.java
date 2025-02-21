package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Salle;
import fr.limoges.valadon.immersions.api.repository.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    public Optional<Salle> getSalleById(int id) {
        return salleRepository.findById(id);
    }

    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    public void deleteSalle(int id) {
        salleRepository.deleteById(id);
    }
}