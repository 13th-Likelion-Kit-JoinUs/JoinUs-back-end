package com.example.JoinUs.test.dto;
import com.example.JoinUs.test.entity.Choice;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ChoiceResponse {
    private Long id;
    private String choiceText;
    private int scorePlanning;
    private int scoreCreativity;
    private int scoreExecution;
    private int scoreAnalyze;

    public static ChoiceResponse fromEntity(Choice choice){
        ChoiceResponse dto = new ChoiceResponse();
        dto.setId(choice.getId());
        dto.setChoiceText(choice.getChoiceText());
        dto.setScorePlanning(choice.getScorePlanning());
        dto.setScoreCreativity(choice.getScoreCreativity());
        dto.setScoreExecution(choice.getScoreExecution());
        dto.setScoreAnalyze(choice.getScoreAnalyze());
        return dto;
    }
}
