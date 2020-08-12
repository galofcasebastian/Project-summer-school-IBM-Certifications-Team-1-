package com.practica.project.dto;

import javax.validation.constraints.NotEmpty;

import java.util.List;
//import java.util.Set; 
import lombok.Data;

@Data
public class RequestDto{
    
    private Integer id;
    @NotEmpty
    private String myQuarter;
    @NotEmpty
    private String myApprovalStatus;
    private String businessJustification;
    private List<ApplicantDto> applicants;
    private List<RequestDto> requestList;
}