package fr.limoges.valadon.immersions.api.controller;

import fr.limoges.valadon.immersions.api.model.Periode;
import fr.limoges.valadon.immersions.api.service.PeriodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/periodes")
public class PeriodeController {
    private final PeriodeService periodeService;

    public PeriodeController(PeriodeService periodeService) {
        this.periodeService = periodeService;
    }

    @GetMapping
    public List<Periode> getAllPeriodes() {
        return periodeService.getAllPeriodes();
    }

    @GetMapping("/{id}")
    public Optional<Periode> getPeriodeById(@PathVariable int id) {
        return periodeService.getPeriodeById(id);
    }

    @PostMapping
    public Periode createPeriode(@RequestBody Periode periode) {
        return periodeService.savePeriode(periode);
    }

    @DeleteMapping("/{id}")
    public void deletePeriode(@PathVariable int id) {
        periodeService.deletePeriode(id);
    }
}