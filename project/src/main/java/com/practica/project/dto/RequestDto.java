package com.practica.project.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Set; 

public class RequestDto{

    private Integer id;
    @NotEmpty
    private String approvalStatus;
    private Set<ApplicantDto> applicants;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getApprovalStatus(){
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus){
        this.approvalStatus=approvalStatus;
    }

    public Set<ApplicantDto> getApplicants(){
        return applicants;
    }

    public void setApplicants(Set<ApplicantDto> applicants){
        this.applicants=applicants;
    }
}