package com.example.JoinUs.test.repository;

import com.example.JoinUs.test.entity.Ability;
import com.example.JoinUs.test.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AbilityRepository extends JpaRepository<Ability,Long> {
    Optional<Ability> findByDescriptionAndPosition(String description, Position position);
    List<Ability> findByPosition(Position position);

}