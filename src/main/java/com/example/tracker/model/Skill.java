package com.example.tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String name;
    private String level;
    private String notes;

    public Skill() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
