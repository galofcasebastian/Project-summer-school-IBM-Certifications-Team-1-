package com.practica.project.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "REQUESTS")
public class Request {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "APPROVAL STATUS", nullable = false)
    private String approvalStatus;

    @ManyToMany(mappedBy = "applicant")
    private Set<Applicant> applicants;

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

    public Set<Applicant> getApplicants(){
        return applicants;
    }

    public void setApplicants(Set<Applicant> applicants){
        this.applicants=applicants;
    }
}