package com.example.JoinUs.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Knowledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 지식(스킬) 이름

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position; // 소속된 직무
}
