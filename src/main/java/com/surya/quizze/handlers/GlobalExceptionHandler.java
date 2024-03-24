package com.surya.quizze.handlers;

import com.surya.quizze.exceptions.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exp) {
        Map<String, String> map = new HashMap<>();
        map.put("error_message", exp.getMessage());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<?> handleException(ObjectNotFoundException exp) {
        Map<String, String> map = new HashMap<>();
        map.put("error_message", "No "+ exp.getEntityType()+" found with id "+exp.getId());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException exp) {

        Map<String, String> map = new HashMap<>();
        exp.getBindingResult().getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(map);
    }
}