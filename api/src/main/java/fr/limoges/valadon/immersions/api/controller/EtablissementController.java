package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.Etablissement;
import fr.limoges.valadon.immersions.api.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etablissements")
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;

    @GetMapping
    public List<Etablissement> getAllEtablissements() {
        return etablissementService.getAllEtablissements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etablissement> getEtablissementById(@PathVariable Integer id) {
        Optional<Etablissement> etablissement = etablissementService.getEtablissementById(id);
        return etablissement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Etablissement createEtablissement(@RequestBody Etablissement etablissement) {
        return etablissementService.createEtablissement(etablissement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etablissement> updateEtablissement(@PathVariable Integer id, @RequestBody Etablissement etablissement) {
        Etablissement updatedEtablissement = etablissementService.updateEtablissement(id, etablissement);
        return updatedEtablissement != null ? ResponseEntity.ok(updatedEtablissement) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtablissement(@PathVariable Integer id) {
        etablissementService.deleteEtablissement(id);
        return ResponseEntity.noContent().build();
    }
}
