package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.Salle;
import fr.limoges.valadon.immersions.api.service.SalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salles")
public class SalleController {
    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<Salle> getAllSalles() {
        return salleService.getAllSalles();
    }

    @GetMapping("/{id}")
    public Optional<Salle> getSalleById(@PathVariable int id) {
        return salleService.getSalleById(id);
    }

    @PostMapping
    public Salle createSalle(@RequestBody Salle salle) {
        return salleService.saveSalle(salle);
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable int id) {
        salleService.deleteSalle(id);
    }
}