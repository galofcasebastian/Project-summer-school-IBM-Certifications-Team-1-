package com.practica.project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data @AllArgsConstructor
public class ExceptionResponseDto {
    private final String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    private int statusCode;
    private String error;
    private String message;
    private String path;
}