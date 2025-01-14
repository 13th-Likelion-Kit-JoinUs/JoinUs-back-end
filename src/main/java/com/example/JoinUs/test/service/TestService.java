package com.example.JoinUs.test.service;

import com.example.JoinUs.common.exception.BusinessException;
import com.example.JoinUs.common.exception.ExceptionType;
import com.example.JoinUs.test.dto.QuestionResponse;
import com.example.JoinUs.test.dto.ResultResponse;
import com.example.JoinUs.test.entity.*;
import com.example.JoinUs.test.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {

    private final QuestionRepository questionRepository;
    private final PositionRepository positionRepository;
    private final AbilityRepository abilityRepository;
    private final KeywordRepository keywordRepository;
    private final ToolRepository toolRepository;
    private final KnowledgeRepository knowledgeRepository;
    private final SkillRepository skillRepository;


    public List<QuestionResponse> getQuestions() {
        List<Question> questions=questionRepository.findAll();

        return questions.stream()
                .map(QuestionResponse::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     * 해당 position에 대한 데이터를 종합해 반환
     * @param positionId
     * @return
     */
    public ResultResponse submitAndCreateResult(Long positionId) {
        // Position 조회
        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new BusinessException(ExceptionType.INVALID_POSITION_ID));

        // 연관 데이터 조회
        List<Ability> abilities = abilityRepository.findByPosition(position);
        List<Keyword> keywords = keywordRepository.findByPosition(position);
        List<Tool> tools = toolRepository.findByPosition(position);
        List<Knowledge> knowledge = knowledgeRepository.findByPosition(position);
        List<Skill> skills = skillRepository.findByPosition(position);

        // ResultResponse 생성 및 반환
        return ResultResponse.fromEntity(position, abilities, keywords, tools, knowledge, skills);
    }

}
