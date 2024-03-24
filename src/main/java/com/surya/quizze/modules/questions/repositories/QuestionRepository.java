package com.surya.quizze.modules.questions.repositories;

import com.surya.quizze.modules.questions.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
