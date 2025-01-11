package com.example.JoinUs.test.service;

import com.example.JoinUs.test.dto.QuestionResponse;
import com.example.JoinUs.test.entity.Question;
import com.example.JoinUs.test.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {

    private final QuestionRepository questionRepository;

    public List<QuestionResponse> getQuestions() {
        List<Question> questions=questionRepository.findAll();

        return questions.stream()
                .map(QuestionResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
