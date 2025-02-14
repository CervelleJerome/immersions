package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Eleve;
import fr.limoges.valadon.immersions.api.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveService {

    @Autowired
    private EleveRepository eleveRepository;

    // Récupérer tous les élèves
    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    // Récupérer un élève par son ID
    public Optional<Eleve> getEleveById(int id) {
        return eleveRepository.findById(id);
    }

    // Créer un nouvel élève
    public Eleve createEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    // Mettre à jour un élève existant
    public Eleve updateEleve(int id, Eleve updatedEleve) {
        Optional<Eleve> existingEleve = eleveRepository.findById(id);
        if (existingEleve.isPresent()) {
            Eleve eleve = existingEleve.get();
            eleve.setNomEleve(updatedEleve.getNomEleve());
            eleve.setPrenomEleve(updatedEleve.getPrenomEleve());
            eleve.setDateNaissance(updatedEleve.getDateNaissance());
            eleve.setRegimeScolaire(updatedEleve.getRegimeScolaire());
            eleve.setClasse(updatedEleve.getClasse());
            eleve.setEtablissement(updatedEleve.getEtablissement());
            return eleveRepository.save(eleve);
        } else {
            return null;
        }
    }

    // Supprimer un élève
    public void deleteEleve(int id) {
        eleveRepository.deleteById(id);
    }
}
