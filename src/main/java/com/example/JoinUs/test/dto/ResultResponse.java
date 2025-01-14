package com.example.JoinUs.test.dto;

import com.example.JoinUs.test.entity.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ResultResponse {
    private String positionName;
    private String description;
    private List<String> abilities;
    private List<String> keywords;
    private List<String> tools;
    private List<String> knowledge;
    private List<String> skills;

    public static ResultResponse fromEntity(
            Position position,
            List<Ability> abilities,
            List<Keyword> keywords,
            List<Tool> tools,
            List<Knowledge> knowledge,
            List<Skill> skills
    ) {
        return ResultResponse.builder()
                .positionName(position.getName())
                .description(position.getDescription())
                .abilities(abilities.stream()
                        .map(Ability::getDescription)
                        .collect(Collectors.toList()))
                .keywords(keywords.stream()
                        .map(Keyword::getKeyword)
                        .collect(Collectors.toList()))
                .tools(tools.stream()
                        .map(Tool::getName)
                        .collect(Collectors.toList()))
                .knowledge(knowledge.stream()
                        .map(Knowledge::getName)
                        .collect(Collectors.toList()))
                .skills(skills.stream()
                        .map(Skill::getSkill)
                        .collect(Collectors.toList()))
                .build();
    }
}
