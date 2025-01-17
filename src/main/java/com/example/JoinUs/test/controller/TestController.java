package com.example.JoinUs.test.controller;
import com.example.JoinUs.common.response.ResponseBody;
import com.example.JoinUs.common.response.ResponseUtil;
import com.example.JoinUs.test.dto.QuestionResponse;
import com.example.JoinUs.test.dto.ResultResponse;
import com.example.JoinUs.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public ResponseEntity<ResponseBody<List<QuestionResponse>>> getQuestions() {
        List<QuestionResponse> questions = testService.getQuestions();
        return ResponseEntity.ok(ResponseUtil.createSuccessResponse(questions));
    }

    @PostMapping
    public ResponseEntity<ResponseBody<ResultResponse>> submitAndCreateResult(
            @RequestParam Long position) {
        ResultResponse result = testService.submitAndCreateResult(position);
        return ResponseEntity.ok(ResponseUtil.createSuccessResponse(result));
    }

}
