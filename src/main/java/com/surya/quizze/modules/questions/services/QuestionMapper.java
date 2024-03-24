package com.surya.quizze.modules.questions.services;

import com.surya.quizze.modules.questions.models.Question;
import com.surya.quizze.modules.questions.models.QuestionRequest;
import com.surya.quizze.modules.questions.models.QuestionResponse;
import org.springframework.stereotype.Service;

@Service
public class QuestionMapper {

    public QuestionResponse toQuestionResponse(Question question) {
        return new QuestionResponse(
                question.getId(),
                question.getQuestion(),
                question.getOption1(),
                question.getOption2(),
                question.getOption3(),
                question.getOption4()
        );
    }

    public Question toQuestion(QuestionRequest questionRequest) {
        return Question.builder()
                .question(questionRequest.question())
                .option1(questionRequest.option1())
                .option2(questionRequest.option2())
                .option3(questionRequest.option3())
                .option4(questionRequest.option4())
                .answer(questionRequest.answer())
                .build();
    }

    public Question toQuestionWithId(Integer id, QuestionRequest questionRequest) {
        var question = toQuestion(questionRequest);
        question.setId(id);
        return question;
    }
}
