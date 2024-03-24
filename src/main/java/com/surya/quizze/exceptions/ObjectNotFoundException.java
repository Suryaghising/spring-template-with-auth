package com.surya.quizze.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectNotFoundException extends RuntimeException {
    private Integer id;
    private String entityType;
}
