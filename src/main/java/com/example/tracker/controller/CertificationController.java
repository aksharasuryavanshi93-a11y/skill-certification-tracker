package com.example.tracker.controller;

import com.example.tracker.model.Certification;
import com.example.tracker.repository.CertificationRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/certifications")
public class CertificationController {
    private final CertificationRepository repository;
    public CertificationController(CertificationRepository repository) { this.repository = repository; }
    @GetMapping public List<Certification> all() { return repository.findAll(); }
    @PostMapping public Certification create(@Valid @RequestBody Certification item) { item.setId(null); return repository.save(item); }
    @PutMapping("/{id}") public ResponseEntity<Certification> update(@PathVariable Long id, @Valid @RequestBody Certification input) {
        return repository.findById(id).map(item -> { item.setName(input.getName()); item.setProvider(input.getProvider()); item.setCompletionDate(input.getCompletionDate()); item.setExpiryDate(input.getExpiryDate()); item.setStatus(input.getStatus()); return ResponseEntity.ok(repository.save(item)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
