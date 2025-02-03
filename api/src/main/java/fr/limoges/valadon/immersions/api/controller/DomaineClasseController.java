package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.Domaine;
import fr.limoges.valadon.immersions.api.service.DomaineClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domaines")
public class DomaineClasseController {

    @Autowired
    private DomaineClasseService domaineClasseService;

    // GET : Récupérer tous les domaines
    @GetMapping
    public List<Domaine> getAllDomaines() {
        return domaineClasseService.getAllDomaines();
    }

    // GET : Récupérer un domaine par ID
    @GetMapping("/{id}")
    public ResponseEntity<Domaine> getDomaineById(@PathVariable Integer id) {
        Optional<Domaine> domaine = domaineClasseService.getDomaineById(id);
        return domaine.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST : Créer un nouveau domaine
    @PostMapping
    public Domaine createDomaine(@RequestBody Domaine domaine) {
        return domaineClasseService.createDomaine(domaine);
    }

    // PUT : Mettre à jour un domaine existant
    @PutMapping("/{id}")
    public ResponseEntity<Domaine> updateDomaine(@PathVariable Integer id, @RequestBody Domaine updatedDomaine) {
        Domaine domaine = domaineClasseService.updateDomaine(id, updatedDomaine);
        if (domaine != null) {
            return ResponseEntity.ok(domaine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE : Supprimer un domaine par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDomaine(@PathVariable Integer id) {
        if (domaineClasseService.getDomaineById(id).isPresent()) {
            domaineClasseService.deleteDomaine(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
