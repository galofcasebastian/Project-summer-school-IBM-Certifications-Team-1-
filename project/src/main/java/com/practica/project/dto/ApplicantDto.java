package com.practica.project.dto;

import javax.validation.constraints.NotEmpty;

import java.util.List;
//import java.util.Set;
import lombok.Data;

@Data
public class ApplicantDto{
    
    private Integer id;
    @NotEmpty
    private String name;
    private List<CertificationDto> certificationList;
    private List<RequestDto> requestList;
}

