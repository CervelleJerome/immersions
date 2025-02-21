package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.Enseignant;
import fr.limoges.valadon.immersions.api.service.EnseignantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {
    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignants();
    }

    @GetMapping("/{id}")
    public Optional<Enseignant> getEnseignantById(@PathVariable int id) {
        return enseignantService.getEnseignantById(id);
    }

    @PostMapping
    public Enseignant createEnseignant(@RequestBody Enseignant enseignant) {
        return enseignantService.saveEnseignant(enseignant);
    }

    @DeleteMapping("/{id}")
    public void deleteEnseignant(@PathVariable int id) {
        enseignantService.deleteEnseignant(id);
    }
}