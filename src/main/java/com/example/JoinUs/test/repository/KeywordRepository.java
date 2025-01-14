package com.example.JoinUs.test.repository;

import com.example.JoinUs.test.entity.Keyword;
import com.example.JoinUs.test.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    Optional<Keyword> findByKeywordAndPosition(String keyword, Position position);
    List<Keyword> findByPosition(Position position);
}
