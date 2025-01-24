package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.TypeEtablissement;
import fr.limoges.valadon.immersions.api.service.TypeEtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/type-etablissement")
public class TypeEtablissementController {

    @Autowired
    private TypeEtablissementService typeEtablissementService;

    @GetMapping
    public List<TypeEtablissement> getAllTypes() {
        return typeEtablissementService.getAllTypesEtablissements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeEtablissement> getTypeById(@PathVariable Integer id) {
        Optional<TypeEtablissement> type = typeEtablissementService.getTypeEtablissementById(id);
        return type.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TypeEtablissement createType(@RequestBody TypeEtablissement typeEtablissement) {
        return typeEtablissementService.createTypeEtablissement(typeEtablissement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeEtablissement> updateType(@PathVariable Integer id, @RequestBody TypeEtablissement typeEtablissement) {
        TypeEtablissement updated = typeEtablissementService.updateTypeEtablissement(id, typeEtablissement);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Integer id) {
        typeEtablissementService.deleteTypeEtablissement(id);
        return ResponseEntity.noContent().build();
    }
}

