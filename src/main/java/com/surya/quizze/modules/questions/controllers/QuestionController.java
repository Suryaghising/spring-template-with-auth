package com.surya.quizze.modules.questions.controllers;

import com.surya.quizze.modules.questions.models.QuestionRequest;
import com.surya.quizze.modules.questions.models.QuestionResponse;
import com.surya.quizze.modules.questions.services.QuestionService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getAllQuestions() {
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @PostMapping
    public ResponseEntity<QuestionResponse> addQuestion(
            @RequestBody QuestionRequest questionRequest
            ) {
        return ResponseEntity.ok(questionService.addQuestion(questionRequest));
    }

    @PutMapping("/{question-id}")
    public ResponseEntity<QuestionResponse> updateQuestion(
            @NotNull
            @PathVariable("question-id") Integer id,
            @RequestBody QuestionRequest questionRequest
    ) {
        return ResponseEntity.ok(questionService.updateQuestion(id, questionRequest));
    }

    @DeleteMapping("/{question-id}")
    public ResponseEntity<String> deleteQuestionById(
            @PathVariable("question-id") Integer id) {
        return ResponseEntity.ok(questionService.deleteQuestionById(id));
    }
}
