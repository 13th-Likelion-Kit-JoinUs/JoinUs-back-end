package com.example.JoinUs.test.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Choice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="choice_id", nullable=false)
    private Long id;

    @Column(nullable = false)
    private String choiceText;

    @Column(nullable = false)
    private int scorePlanning;

    @Column(nullable = false)
    private int scoreDesign;

    @Column(nullable = false)
    private int scoreFront;

    @Column(nullable = false)
    private int scoreBack;

    @ManyToOne
    @JoinColumn(name="question_id",nullable=false)
    private Question question;

}
