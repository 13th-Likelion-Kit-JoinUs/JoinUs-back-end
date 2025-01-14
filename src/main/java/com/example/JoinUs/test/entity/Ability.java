package com.example.JoinUs.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description; // 역량 설명

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position; // 연관된 직무
}
