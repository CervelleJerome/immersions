package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.Filiere;
import fr.limoges.valadon.immersions.api.service.FiliereService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    private final FiliereService filiereService;

    public FiliereController(FiliereService filiereService) {
        this.filiereService = filiereService;
    }

    @GetMapping
    public List<Filiere> getAllFilieres() {
        return filiereService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Filiere> getFiliereById(@PathVariable Integer id) {
        return filiereService.findById(id);
    }

    @PostMapping
    public Filiere createFiliere(@RequestBody Filiere filiere) {
        return filiereService.save(filiere);
    }

    @PutMapping("/{id}")
    public Filiere updateFiliere(@PathVariable Integer id, @RequestBody Filiere filiere) {
        filiere.setIdFiliere(id);
        return filiereService.save(filiere);
    }

    @DeleteMapping("/{id}")
    public void deleteFiliere(@PathVariable Integer id) {
        filiereService.deleteById(id);
    }
}
