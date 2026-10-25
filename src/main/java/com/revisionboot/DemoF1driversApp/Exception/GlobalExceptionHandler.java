package com.revisionboot.DemoF1driversApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResouceNotFoundException.class)
    public ProblemDetail handleNotFound(
            ResouceNotFoundException ex) {

        ProblemDetail detail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.NOT_FOUND,
                        ex.getMessage());

        detail.setTitle("Resource not found");
        detail.setType(URI.create(
                "https://example.com/problems/not-found"));

        return detail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(
            MethodArgumentNotValidException ex) {

        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField()
                        + ": " + error.getDefaultMessage())
                .distinct()
                .collect(Collectors.joining("; "));

        ProblemDetail detail =
                ProblemDetail.forStatusAndDetail(
                        HttpStatus.BAD_REQUEST, errors);

        detail.setTitle("Validation failed");
        return detail;
    }
}
