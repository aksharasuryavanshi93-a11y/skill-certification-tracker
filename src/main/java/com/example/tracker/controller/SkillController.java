package com.example.tracker.controller;

import com.example.tracker.model.Skill;
import com.example.tracker.repository.SkillRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillRepository repository;
    public SkillController(SkillRepository repository) { this.repository = repository; }
    @GetMapping public List<Skill> all() { return repository.findAll(); }
    @PostMapping public Skill create(@Valid @RequestBody Skill skill) { skill.setId(null); return repository.save(skill); }
    @PutMapping("/{id}") public ResponseEntity<Skill> update(@PathVariable Long id, @Valid @RequestBody Skill input) {
        return repository.findById(id).map(skill -> { skill.setName(input.getName()); skill.setLevel(input.getLevel()); skill.setNotes(input.getNotes()); return ResponseEntity.ok(repository.save(skill)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id); return ResponseEntity.noContent().build();
    }
}
