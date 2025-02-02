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
        // Q1.
        addQuestionWithChoices(
                "어흥~ 오늘은 이사하는 날! 어디서 어떻게 새 서식지를 찾지?",
                1,
                new String[]{
                        "주변 환경을 분석해 안전하고 효율적인 정착지를 제안한다.",
                        "직접 움직이며 적합한 장소를 빠르게 탐색한다."
                },
                new int[][]{
                        {3, 0, 0, 2}, // A: 기획력 +3, 창의력 +0, 실행력 +0, 분석력 +2
                        {0, 2, 3, 0}  // B: 기획력 +0, 창의력 +2, 실행력 +3, 분석력 +0
                }
        );

        // Q2.
        addQuestionWithChoices(
                "괜찮은 초원 발견! 새 집 마련 시, 꼭 해야 하는 일은?",
                2,
                new String[]{
                        "다른 사자 무리들에게 무시 받지 않게, 작은 자원을 활용해 영역을 멋지게 꾸미기!",
                        "언제 하이에나한테 공격당할지 몰라! 동선이 최적화된 효율적인 구조로 설계한다."
                },
                new int[][]{
                        {1, 4, 0, 0}, // A: 기획력 +1, 창의력 +4, 실행력 +0, 분석력 +0
                        {1, 0, 0, 4}  // B: 기획력 +1, 창의력 +0, 실행력 +0, 분석력 +4
                }
        );

        // Q3.
        addQuestionWithChoices(
                "새로운 사냥법으로 얼룩말을 잡으러 가자는 대장... 믿어도 될까?",
                3,
                new String[]{
                        "실패하면 어떡해! 위험 요소를 분석하고 효율성을 검토한다.",
                        "이런 건 해봐야 알지~ 새 사냥법을 직접 시도하며 효과를 확인한다."
                },
                new int[][]{
                        {1, 0, 0, 4}, // A: 기획력 +1, 창의력 +0, 실행력 +0, 분석력 +4
                        {0, 2, 3, 0}  // B: 기획력 +0, 창의력 +2, 실행력 +3, 분석력 +0
                }
        );

        // Q4.
        addQuestionWithChoices(
                "오늘은 다 같이 사냥을 하는 날, 무리 속 내 모습은?",
                4,
                new String[]{
                        "지피지기면 백전백승! 미리 사냥터를 분석하여 작전을 세운다.",
                        "작은 먹잇감부터 빠르게 몰아내며 눈에 띄는 사냥 성과를 보여준다."
                },
                new int[][]{
                        {2, 0, 0, 3}, // A: 기획력 +2, 창의력 +0, 실행력 +0, 분석력 +3
                        {0, 1, 4, 0}  // B: 기획력 +0, 창의력 +1, 실행력 +4, 분석력 +0
                }
        );

        // Q5.
        addQuestionWithChoices(
                "사냥 후 즐거운 식사 시간~ \"내가 먼저!\"라는 아우성에 나는?",
                5,
                new String[]{
                        "모두가 납득할 만한 방법을 찾아야 해. 의견을 조율하여 가장 공정한 순서를 정한다.",
                        "나뭇가지로 사다리타기 게임을 만들어 한 사자에게 몰아주기!"
                },
                new int[][]{
                        {3, 0, 0, 2}, // A: 기획력 +3, 창의력 +0, 실행력 +0, 분석력 +2
                        {0, 3, 2, 0}  // B: 기획력 +0, 창의력 +3, 실행력 +2, 분석력 +0
                }
        );

        // Q6.
        addQuestionWithChoices(
                "갑자기 몰아치는 폭풍! 우왕좌왕하는 사자들 사이에서 나는?",
                6,
                new String[]{
                        "다들 침착하자. 주변 환경을 파악하여 대피 경로를 안내한다.",
                        "바로 움직여! 폭풍 속에서 안전한 곳으로 이동을 대비한다."
                },
                new int[][]{
                        {2, 0, 0, 3}, // A: 기획력 +2, 창의력 +0, 실행력 +0, 분석력 +3
                        {0, 1, 4, 0}  // B: 기획력 +0, 창의력 +1, 실행력 +4, 분석력 +0
                }
        );

        // Q7.
        addQuestionWithChoices(
                "어이, 너희들 먹을만한 고기 좀 있나? 하이에나들이 들러서 위협한다.",
                7,
                new String[]{
                        "고기를 지키면서 싸움을 이길 수 있는 필승법을 생각한다.",
                        "“등 뒤의 상처는 사자의 수치다!” 함께 외치며 결속된 패기로 주춤하게 만든다."
                },
                new int[][]{
                        {2, 0, 0, 3}, // A: 기획력 +2, 창의력 +0, 실행력 +0, 분석력 +3
                        {0, 2, 3, 0}  // B: 기획력 +0, 창의력 +2, 실행력 +3, 분석력 +0
                }
        );

        // Q8.
        addQuestionWithChoices(
                "다가오는 축제 일정. 나는 어떤 일을 만들까?",
                8,
                new String[]{
                        "전체적인 축제의 컨셉을 정하고 그에 맞는 소품들을 준비한다.",
                        "난 그냥 시키는 게 편해~ 사자들을 역할에 맞게 분배하고 배치한다."
                },
                new int[][]{
                        {3, 2, 0, 0}, // A: 기획력 +3, 창의력 +2, 실행력 +0, 분석력 +0
                        {2, 0, 3, 0}  // B: 기획력 +2, 창의력 +0, 실행력 +3, 분석력 +0
                }
        );

        // Q9.
        addQuestionWithChoices(
                "오늘은 기다리던 축제 당일! 내가 참여하고 싶은 이벤트는?",
                9,
                new String[]{
                        "섹.시.도.발 선발 대회? 이건 못 참지. 여러 볼거리를 즐긴다.",
                        "이거 갑자기 부러지는 거 아니야? 구조물과 시설의 안전성이 신경이 쓰인다."
                },
                new int[][]{
                        {0, 4, 1, 0}, // A: 기획력 +0, 창의력 +4, 실행력 +1, 분석력 +0
                        {1, 0, 0, 4}  // B: 기획력 +1, 창의력 +0, 실행력 +0, 분석력 +4
                }
        );

        // Q10.
        addQuestionWithChoices(
                "멀리 있는 사냥터에 가기 전, 나의 모습은?",
                10,
                new String[]{
                        "먼 길을 가려면 준비가 철저해야 해. 경로와 자원을 분석해 최적의 사냥 루트를 세운다.",
                        "사냥터 가는 경로와 대피 장소를 한눈에 볼 수 있는 지도를 만든다."
                },
                new int[][]{
                        {2, 0, 0, 3}, // A: 기획력 +2, 창의력 +0, 실행력 +0, 분석력 +3
                        {0, 3, 2, 0}  // B: 기획력 +0, 창의력 +3, 실행력 +2, 분석력 +0
                }
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
            choice.setScoreCreativity(scores[i][1]);
            choice.setScoreExecution(scores[i][2]);
            choice.setScoreAnalyze(scores[i][3]);
            choice.setQuestion(question);
            choiceRepository.save(choice);
        }
    }
}
