package com.practica.project.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class CertificationDto{
    
    private Integer id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String category;
    @Positive
    private int cost;
}