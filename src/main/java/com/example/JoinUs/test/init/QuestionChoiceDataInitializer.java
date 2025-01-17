package com.example.JoinUs.test.init;

import com.example.JoinUs.test.entity.Choice;
import com.example.JoinUs.test.entity.Question;
import com.example.JoinUs.test.repository.ChoiceRepository;
import com.example.JoinUs.test.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Slf4j
public class QuestionChoiceDataInitializer {

    private final QuestionRepository questionRepository;
    private final ChoiceRepository choiceRepository;

    @EventListener
    @Transactional
    public void onApplicationReady(ApplicationReadyEvent event) {
        initializeData();
    }

    private void initializeData() {
        // Q1
        addQuestionWithChoices(
                "사자 무리가 새로운 사냥터를 찾아 나섭니다. 당신은 어떤 역할을 맡고 싶나요?",
                1,
                new String[]{"사냥터의 위험 요소를 분석하며 안전한 길을 찾는다.", "새로운 장소를 직접 탐색하며 사냥에 적합한 환경을 찾는다."},
                new int[][]{{1, 0, 1, 3}, {0, 1, 3, 1}}
        );

        // Q2
        addQuestionWithChoices(
                "무리가 영역 표시를 준비합니다. 당신은 어떻게 영역을 꾸미겠습니까?",
                2,
                new String[]{"영역을 가장 보기 좋고 강렬하게 꾸며 다른 무리에게 깊은 인상을 준다.", "영역의 구조와 안전성을 중점적으로 설계한다."},
                new int[][]{{1, 3, 1, 0}, {0, 1, 1, 3}}
        );

        // Q3
        addQuestionWithChoices(
                "사냥 중 예상치 못한 문제가 발생했습니다. 당신은 어떤 방식으로 대처하겠습니까?",
                3,
                new String[]{"침착하게 원인을 분석하고 무리에게 해결책을 제안한다.", "빠르게 행동하여 문제를 해결하고 사냥을 이어간다."},
                new int[][]{{1, 0, 1, 3}, {1, 1, 3, 0}}
        );

        // Q4
        addQuestionWithChoices(
                "무리 내에서 의견 충돌이 발생했습니다. 당신은 어떻게 조율하겠습니까?",
                4,
                new String[]{"모두의 의견을 정리하고 설득력 있는 대안을 제시한다.", "시각적으로 이해하기 쉬운 자료를 만들어 설득한다."},
                new int[][]{{3, 1, 0, 1}, {0, 3, 1, 1}}
        );

        // Q5
        addQuestionWithChoices(
                "새로운 기술을 배울 기회가 생겼습니다. 당신은 어떻게 접근하겠습니까?",
                5,
                new String[]{"기술의 안정성과 효율성을 철저히 검토한다.", "새로운 기술을 바로 테스트하고 효과를 확인한다."},
                new int[][]{{1, 1, 0, 3}, {0, 1, 3, 1}}
        );

        // Q6
        addQuestionWithChoices(
                "무리가 새로운 먹이를 발견했습니다. 당신은 어떤 역할을 맡고 싶나요?",
                6,
                new String[]{"먹이를 나누는 기준을 정리하고 무리가 효율적으로 배분하도록 돕는다.", "먹이를 보기 좋게 정리하고 무리의 사기를 높인다."},
                new int[][]{{3, 0, 1, 1}, {1, 3, 1, 0}}
        );

        // Q7
        addQuestionWithChoices(
                "폭풍 속에서 무리가 흩어졌습니다. 당신은 어떻게 대응하겠습니까?",
                7,
                new String[]{"침착하게 무리의 위치를 파악하고 안전한 장소로 유도한다.", "빠르게 움직이며 흩어진 무리원들을 하나로 모은다."},
                new int[][]{{3, 0, 1, 1}, {1, 1, 3, 0}}
        );

        // Q8
        addQuestionWithChoices(
                "사자들이 축제를 준비하고 있습니다. 당신은 어떤 부분에 기여하고 싶나요?",
                8,
                new String[]{"축제의 분위기를 꾸미고 무리원들이 즐길 수 있도록 한다.", "축제의 흐름과 역할 분담을 체계적으로 정리한다."},
                new int[][]{{0, 3, 1, 1}, {3, 1, 0, 1}}
        );

        // Q9
        addQuestionWithChoices(
                "새로운 사냥터에서 적과 마주쳤습니다. 당신은 어떻게 행동할 것 같나요?",
                9,
                new String[]{"적의 행동을 관찰하고 우리 무리의 방어 계획을 세운다.", "무리와 협력하여 적에게 강력한 메시지를 전달한다."},
                new int[][]{{1, 0, 1, 3}, {3, 1, 1, 0}}
        );

        // Q10
        addQuestionWithChoices(
                "당신은 사냥터에서 사냥의 동선을 정리해야 합니다. 어떻게 준비하겠습니까?",
                10,
                new String[]{"사냥터의 환경과 동선을 시각적으로 정리해 모두가 쉽게 이해할 수 있도록 만든다.", "사냥 전략과 효율성을 분석하여 무리에게 전달한다."},
                new int[][]{{1, 3, 1, 0}, {1, 0, 0, 3}}
        );
    }

    private void addQuestionWithChoices(String questionContent, int step, String[] choiceTexts, int[][] scores) {
        if (questionRepository.existsByStep(step)) {
            log.info("Step " + step + " already exists. Skipping...");
            return;
        }

        Question question = new Question();
        question.setContent(questionContent);
        question.setStep(step);
        questionRepository.save(question);

        for (int i = 0; i < choiceTexts.length; i++) {
            Choice choice = new Choice();
            choice.setChoiceText(choiceTexts[i]);
            choice.setScorePlanning(scores[i][0]);
            choice.setScoreDesign(scores[i][1]);
            choice.setScoreFront(scores[i][2]);
            choice.setScoreBack(scores[i][3]);
            choice.setQuestion(question);
            choiceRepository.save(choice);
        }
    }
}
