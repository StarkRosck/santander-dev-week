package starkrosck.com.santander_dev_week.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import starkrosck.com.santander_dev_week.domain.model.Fatura;
import starkrosck.com.santander_dev_week.domain.service.FaturaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fatura")
public class FaturaController {

    private final FaturaService faturaService;

    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public ResponseEntity<List<Fatura>> findAll() {
        return ResponseEntity.ok(faturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fatura> findById(@PathVariable Long id) {
        return ResponseEntity.ok(faturaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Fatura> create(@RequestBody Fatura fatura) {
        Fatura created = faturaService.create(fatura);
        URI location = URI.create("/fatura/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fatura> update(@PathVariable Long id, @RequestBody Fatura fatura) {
        fatura.setId(id);
        return ResponseEntity.ok(faturaService.update(fatura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        faturaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
