package com.abhinav.portfoliobackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandlerSkill {

    @ExceptionHandler(SkillNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleSkillNotFound(
            SkillNotFoundException exception
    ) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", 404);
        response.put("message", exception.getMessage());

        return response;
    }
}