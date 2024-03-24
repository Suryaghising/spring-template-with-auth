package com.surya.quizze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class QuizzeApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizzeApplication.class, args);
    }

}
