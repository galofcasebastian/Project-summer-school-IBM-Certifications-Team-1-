package com.practica.project.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class LessonException extends RuntimeException {

    @Getter
    private final HttpStatus httpStatus;

    public LessonException(HttpStatus status) {
        this(status, null, null);
    }

    public LessonException(HttpStatus status, String reason) {
        this(status, reason, null);
    }

    public LessonException(HttpStatus status, String reason, Throwable cause) {
        super(reason, cause);
        this.httpStatus = status;
    }
}