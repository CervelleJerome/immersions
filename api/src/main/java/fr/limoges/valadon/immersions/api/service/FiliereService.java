package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Filiere;
import fr.limoges.valadon.immersions.api.repository.FiliereRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FiliereService {

    private final FiliereRepository filiereRepository;

    public FiliereService(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    public List<Filiere> findAll() {
        return filiereRepository.findAll();
    }

    public Optional<Filiere> findById(Integer id) {
        return filiereRepository.findById(id);
    }

    public Filiere save(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public void deleteById(Integer id) {
        filiereRepository.deleteById(id);
    }
}