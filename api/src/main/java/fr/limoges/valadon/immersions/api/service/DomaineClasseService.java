package fr.limoges.valadon.immersions.api.service;

import fr.limoges.valadon.immersions.api.model.Domaine;
import fr.limoges.valadon.immersions.api.repository.DomaineClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomaineClasseService {

    @Autowired
    private DomaineClasseRepository domaineClasseRepository;

    // Récupérer tous les domaines
    public List<Domaine> getAllDomaines() {
        return domaineClasseRepository.findAll();
    }

    // Récupérer un domaine par son ID
    public Optional<Domaine> getDomaineById(Integer id) {
        return domaineClasseRepository.findById(id);
    }

    // Créer un nouveau domaine
    public Domaine createDomaine(Domaine domaineClasse) {
        return domaineClasseRepository.save(domaineClasse);
    }

    // Mettre à jour un domaine existant
    public Domaine updateDomaine(Integer id, Domaine updatedDomaine) {
        if (domaineClasseRepository.existsById(id)) {
            updatedDomaine.setIdDomaine(id);
            return domaineClasseRepository.save(updatedDomaine);
        } else {
            return null; // Gérer le cas où le domaine n'existe pas
        }
    }

    // Supprimer un domaine par son ID
    public void deleteDomaine(Integer id) {
        domaineClasseRepository.deleteById(id);
    }
}
