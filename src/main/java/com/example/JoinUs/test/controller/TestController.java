package com.example.JoinUs.test.controller;
import com.example.JoinUs.common.response.ResponseBody;
import com.example.JoinUs.common.response.ResponseUtil;
import com.example.JoinUs.test.dto.QuestionResponse;
import com.example.JoinUs.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    @GetMapping("/test")
    public ResponseEntity<ResponseBody<List<QuestionResponse>>> getQuestions() {
        List<QuestionResponse> questions = testService.getQuestions();
        return ResponseEntity.ok(ResponseUtil.createSuccessResponse(questions));
    }
}
