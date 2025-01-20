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
                List.of("프로젝트 기획, 개발, 마케팅 등 여러 업무를 총괄한다.", "프로젝트의 비전과 전략을 설계한다.", "디자이너, 개발자 등 다양한 직군과 원활히 소통한다."),
                List.of("Figma"),
                List.of("데이터 분석", "개발 및 디자인 관련 지식"),
                List.of("문서 작성", "프로젝트 관리")
        );

        createPosition(
                "디자인",
                "'내가 예쁘게 만들어줄게' 당신은 디자인형 아기사자",
                List.of("트렌드에 매우 민감", "사람에게 관심많음", "만드는 거 잘함"),
                List.of("사용자의 니즈를 파악하고 사용자 중심의 디자인을 구현한다.", "현재 트렌드와 기술을 분석하여 효과적인 디자인을 추구한다.", "색, 타이포그래피, 아이콘 등의 시각 기법을 이용해 레이아웃을 제작한다."),
                List.of("Figma", "Photoshop"),
                List.of("UX디자인", "디자인 원칙", "프로토타이핑"),
                List.of("포토샵", "일러스트레이터")
        );

        createPosition(
                "프론트엔드",
                "'순발력과 대응은 나한테 맡겨' 당신은 프론트엔드형 아기사자",
                List.of("감성적인 F", "외향적", "즉각적인 반응"),
                List.of("사용자가 직접 상호작용할 수 있는 웹사이트나 앱의 사용자 인터페이스를 개발한다.", "빠른 변화에 잘 적응하고 새로운 기술을 배우는데 거리낌이 없다.", "사용자가 쉽게 사용할 수 있는 UI를 설계한다."),
                List.of("HTML", "CSS", "Javascript"),
                List.of("브라우저 동작 원리", "응답형 웹 디자인", "웹 접근성"),
                List.of("React", "Vue.js", "TypeScript")
        );

        createPosition(
                "백엔드",
                "'우리 논리적으로 생각해볼까?' 당신은 백엔드형 아기사자",
                List.of("책임감 쩜", "내향적", "호기심 많음"),
                List.of("서버와 데이터베이스를 관리하고 사용자에게 필요한 정보를 제공한다.", "빠르고 정확한 분석과 효율을 추구하는 사고방식으로 개발의 본질에 집중한다.", "확장 가능한 구조를 설계하는 감각을 지녔다."),
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
