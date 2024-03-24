package com.surya.quizze.modules.questions.models;

public record QuestionRequest(
        String question,
        String option1,
        String option2,
        String option3,
        String option4,
        String answer
) {
}
