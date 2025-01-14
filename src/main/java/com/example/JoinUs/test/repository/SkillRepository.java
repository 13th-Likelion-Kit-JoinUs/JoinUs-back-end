package com.example.JoinUs.test.repository;

import com.example.JoinUs.test.entity.Position;
import com.example.JoinUs.test.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    Optional<Skill> findBySkillAndPosition(String skill, Position position);
}

