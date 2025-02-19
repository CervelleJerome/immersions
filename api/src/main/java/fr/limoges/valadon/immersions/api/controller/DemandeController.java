package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.Demande;
import fr.limoges.valadon.immersions.api.service.DemandeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @GetMapping
    public List<Demande> getAllDemandes() {
        return demandeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Demande> getDemandeById(@PathVariable Integer id) {
        return demandeService.findById(id);
    }

    @PostMapping
    public Demande createDemande(@RequestBody Demande demande) {
        return demandeService.save(demande);
    }

    @PutMapping("/{id}")
    public Demande updateDemande(@PathVariable Integer id, @RequestBody Demande demande) {
        demande.setIdDemande(id);
        return demandeService.save(demande);
    }

    @DeleteMapping("/{id}")
    public void deleteDemande(@PathVariable Integer id) {
        demandeService.deleteById(id);
    }
}
