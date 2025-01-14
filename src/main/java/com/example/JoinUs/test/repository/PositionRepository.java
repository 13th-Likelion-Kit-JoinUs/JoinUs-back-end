package com.example.JoinUs.test.repository;

import com.example.JoinUs.test.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position,Long> {
    Optional<Position> findByName(String name);
}
