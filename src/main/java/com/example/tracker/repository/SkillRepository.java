package com.example.tracker.repository;
import com.example.tracker.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SkillRepository extends JpaRepository<Skill, Long> {}
