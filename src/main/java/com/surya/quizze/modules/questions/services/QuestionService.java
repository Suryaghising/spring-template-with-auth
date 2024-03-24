package com.surya.quizze.modules.questions.services;

import com.surya.quizze.exceptions.ObjectNotFoundException;
import com.surya.quizze.modules.questions.models.Question;
import com.surya.quizze.modules.questions.models.QuestionRequest;
import com.surya.quizze.modules.questions.models.QuestionResponse;
import com.surya.quizze.modules.questions.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public QuestionResponse addQuestion(QuestionRequest questionRequest) {
        Question question = questionMapper.toQuestion(questionRequest);
        var savedQuestion = questionRepository.save(question);
        return questionMapper.toQuestionResponse(savedQuestion);
    }

    public String deleteQuestionById(Integer id) {
        boolean isQuestionExist = questionRepository.existsById(id);
        if(!isQuestionExist) {
            throw new ObjectNotFoundException(id, "question");
        }
        questionRepository.deleteById(id);
        return "Question deleted successfully";
    }

    public List<QuestionResponse> getAllQuestions() {
        return questionRepository.findAll()
                .stream()
                .map(questionMapper::toQuestionResponse)
                .collect(Collectors.toList());
    }

    public QuestionResponse updateQuestion(Integer id, QuestionRequest questionRequest) {
        boolean isQuestionExist = questionRepository.existsById(id);
        if(!isQuestionExist) {
            throw new ObjectNotFoundException(id, "question");
        }
        var question = questionMapper.toQuestionWithId(id, questionRequest);
        var savedQuestion = questionRepository.save(question);
        return questionMapper.toQuestionResponse(savedQuestion);
    }
}
