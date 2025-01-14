package com.example.JoinUs.test.repository;

import com.example.JoinUs.test.entity.Position;
import com.example.JoinUs.test.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToolRepository extends JpaRepository<Tool, Long> {
    Optional<Tool> findByNameAndPosition(String name, Position position);
    List<Tool> findByPosition(Position position);

}