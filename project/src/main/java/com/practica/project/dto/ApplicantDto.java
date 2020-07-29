package com.practica.project.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class ApplicantDto{
    private Integer id;
    @NotEmpty
    private String name;
    private String businessJustification;
    private Set<CertificationDto> certifications;
    private Set<RequestDto> requests;
    
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getBusinessJustification(){
        return businessJustification;
    }

    public void setBusinessJustification(String businessJustification){
        this.businessJustification=businessJustification;
    }

    public Set<CertificationDto> getCertification(){
        return certifications;
    } 

    public void setCertification(Set<CertificationDto> certifications){
        this.certifications=certifications;
    }

    public Set<RequestDto> getRequest(){
        return requests;
    } 

    public void setRequest(Set<RequestDto> requests){
        this.requests=requests;
    }
}

