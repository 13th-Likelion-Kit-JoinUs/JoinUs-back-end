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
    private int scoreDesign;
    private int scoreFront;
    private int scoreBack;

    public static ChoiceResponse fromEntity(Choice choice){
        ChoiceResponse dto = new ChoiceResponse();
        dto.setId(choice.getId());
        dto.setChoiceText(choice.getChoiceText());
        dto.setScorePlanning(choice.getScorePlanning());
        dto.setScoreDesign(choice.getScoreDesign());
        dto.setScoreFront(choice.getScoreFront());
        dto.setScoreBack(choice.getScoreBack());
        return dto;
    }
}
