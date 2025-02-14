package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.Eleve;
import fr.limoges.valadon.immersions.api.service.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eleves")
public class EleveController {

    @Autowired
    private EleveService eleveService;

    // Récupérer tous les élèves
    @GetMapping()
    public List<Eleve> getAllEleves() {
        return eleveService.getAllEleves();
    }

    // Récupérer un élève par ID
    @GetMapping("/{id}")
    public ResponseEntity<Eleve> getEleveById(@PathVariable int id) {
        Optional<Eleve> eleve = eleveService.getEleveById(id);
        return eleve.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer un nouvel élève
    @PostMapping
    public Eleve createEleve(@RequestBody Eleve eleve) {
        return eleveService.createEleve(eleve);
    }

    // Mettre à jour un élève existant
    @PutMapping("/{id}")
    public ResponseEntity<Eleve> updateEleve(@PathVariable int id, @RequestBody Eleve updatedEleve) {
        Eleve eleve = eleveService.updateEleve(id, updatedEleve);
        if (eleve != null) {
            return ResponseEntity.ok(eleve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un élève
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEleve(@PathVariable int id) {
        Optional<Eleve> eleve = eleveService.getEleveById(id);
        if (eleve.isPresent()) {
            eleveService.deleteEleve(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
