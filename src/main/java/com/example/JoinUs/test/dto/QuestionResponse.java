package com.example.JoinUs.test.dto;

import com.example.JoinUs.test.entity.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class QuestionResponse {

    private Long id;
    private String question;
    private int step;
    private List<ChoiceResponse> choices;

    public static QuestionResponse fromEntity(Question question) {
        QuestionResponse dto = new QuestionResponse();
        dto.setId(question.getId());
        dto.setQuestion(question.getContent());
        dto.setStep(question.getStep());
        dto.setChoices(
                question.getChoices().stream()
                        .map(ChoiceResponse::fromEntity)
                        .collect(Collectors.toList())
        );
        return dto;
    }
}
