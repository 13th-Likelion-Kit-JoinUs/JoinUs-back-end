package com.example.JoinUs.test.init;

import com.example.JoinUs.test.entity.*;
import com.example.JoinUs.test.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class ResultDataInitializer {

    private final PositionRepository positionRepository;
    private final KeywordRepository keywordRepository;
    private final AbilityRepository abilityRepository;
    private final ToolRepository toolRepository;
    private final KnowledgeRepository knowledgeRepository;
    private final SkillRepository skillRepository;

    @EventListener
    @Transactional
    public void onApplicationReady(ApplicationReadyEvent event) {
        initializeResponseData();
    }

    private void initializeResponseData() {
        createPosition(
                "기획",
                "'아기사자들 나만 따라와' 당신은 기획형 아기사자",
                List.of("계획왕", "모든 상황에 대안 준비", "현실적인 낙관주의자", "팀 분위기 메이커"),
                List.of("당신은 아이디어가 많은 아기사자", "당신은 문제 해결에 관심이 많은 아기사자", "당신은 커뮤니케이션 능력이 뛰어난 아기사자"),
                List.of("Figma", "Excel"),
                List.of("데이터 분석", "개발 및 디자인 관련 지식"),
                List.of("문서 작성", "프로젝트 관리")
        );

        createPosition(
                "디자인",
                "'내가 예쁘게 만들어줄게' 당신은 디자인형 아기사자",
                List.of("트렌드에 매우 민감", "사람에게 관심많음", "만드는 거 잘함"),
                List.of("당신은 미적 감각이 있는 아기사자", "당신은 사용자의 문제를 발굴하는 능력이 뛰어난 아기사자", "당신은 매우 꼼꼼한 아기사자"),
                List.of("Figma", "Photoshop"),
                List.of("UX디자인", "디자인 원칙", "프로토타이핑"),
                List.of("포토샵", "일러스트레이터")
        );

        createPosition(
                "프론트엔드",
                "'순발력과 대응은 나한테 맡겨' 당신은 프론트엔드형 아기사자",
                List.of("감성적인 F", "외향적", "즉각적인 반응"),
                List.of("당신은 빠른 변화에 잘 적응하는 아기사자", "당신은 항상 어떤 방법이 더 나은지 고민하는 아기사자", "당신은 다른 사람들 사이에서 중재자를 맡는 아기사자"),
                List.of("HTML", "CSS", "Javascript"),
                List.of("브라우저 동작 원리", "응답형 웹 디자인", "웹 접근성"),
                List.of("React", "Vue.js", "TypeScript")
        );

        createPosition(
                "백엔드",
                "'우리 논리적으로 생각해볼까?' 당신은 백엔드형 아기사자",
                List.of("책임감 쩜", "내향적", "호기심 많음"),
                List.of("당신은 커뮤니케이션 능력이 뛰어난 아기사자", "당신은 주도성이 뛰어난 아기사자", "당신은 당연한 것에도 의문을 가질 줄 아는 아기사자"),
                List.of("C/C++", "Python", "Java"),
                List.of("통신개념(HTTP)", "데이터베이스(DB)", "운영체제(OS)"),
                List.of("Spring", "Node.js", "Flask")
        );
    }

    private void createPosition(String name, String description, List<String> keywords, List<String> abilities, List<String> tools, List<String> knowledges, List<String> skills) {
        // Position 저장
        Position position = positionRepository.findByName(name)
                .orElseGet(() -> {
                    Position newPosition = new Position();
                    newPosition.setName(name);
                    newPosition.setDescription(description);
                    return positionRepository.save(newPosition);
                });

        // Keyword 저장 (Keyword + Position)
        for (String keywordText : keywords) {
            keywordRepository.findByKeywordAndPosition(keywordText, position).ifPresentOrElse(
                    keyword -> log.info("Keyword '{}' for position '{}' already exists. Skipping...", keywordText, position.getName()),
                    () -> {
                        Keyword keyword = new Keyword();
                        keyword.setKeyword(keywordText);
                        keyword.setPosition(position);
                        keywordRepository.save(keyword);
                    }
            );
        }

        // Ability 저장 (Ability + Position)
        for (String abilityDescription : abilities) {
            abilityRepository.findByDescriptionAndPosition(abilityDescription, position).ifPresentOrElse(
                    ability -> log.info("Ability '{}' for position '{}' already exists. Skipping...", abilityDescription, position.getName()),
                    () -> {
                        Ability ability = new Ability();
                        ability.setDescription(abilityDescription);
                        ability.setPosition(position);
                        abilityRepository.save(ability);
                    }
            );
        }

        // Tool 저장 (Tool + Position)
        for (String toolName : tools) {
            toolRepository.findByNameAndPosition(toolName, position).ifPresentOrElse(
                    tool -> log.info("Tool '{}' for position '{}' already exists. Skipping...", toolName, position.getName()),
                    () -> {
                        Tool tool = new Tool();
                        tool.setName(toolName);
                        tool.setPosition(position);
                        toolRepository.save(tool);
                    }
            );
        }

        // Knowledge 저장 (Knowledge + Position)
        for (String knowledgeName : knowledges) {
            knowledgeRepository.findByNameAndPosition(knowledgeName, position).ifPresentOrElse(
                    knowledge -> log.info("Knowledge '{}' for position '{}' already exists. Skipping...", knowledgeName, position.getName()),
                    () -> {
                        Knowledge knowledgeEntity = new Knowledge();
                        knowledgeEntity.setName(knowledgeName);
                        knowledgeEntity.setPosition(position);
                        knowledgeRepository.save(knowledgeEntity);
                    }
            );
        }

        // Skill 저장 (Skill + Position)
        for (String skillName : skills) {
            skillRepository.findBySkillAndPosition(skillName, position).ifPresentOrElse(
                    skill -> log.info("Skill '{}' for position '{}' already exists. Skipping...", skillName, position.getName()),
                    () -> {
                        Skill skill = new Skill();
                        skill.setSkill(skillName);
                        skill.setPosition(position);
                        skillRepository.save(skill);
                    }
            );
        }
    }
}
