package com.practica.project.entity;

import java.util.Set;
import javax.persistence.*; 

@Entity
@Table(name = "APPLICANTS")
public class Applicant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BUSINESS", nullable = false)
    private String businessJustification;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "APPLICANT_CERTIFICATION",
            joinColumns = @JoinColumn(name = "APPLICANT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CERTIFICATION_ID"))
    private Set<Certification> certifications;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "APPLICANT_REQUEST",
            joinColumns = @JoinColumn(name = "APPLICANT_ID"),
            inverseJoinColumns = @JoinColumn(name = "REQUEST_ID"))
    private Set<Request> requests;

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

    public Set<Certification> getCertification(){
        return certifications;
    } 

    public void setCertification(Set<Certification> certifications){
        this.certifications=certifications;
    }

    public Set<Request> getRequest(){
        return requests;
    } 

    public void setRequest(Set<Request> requests){
        this.requests=requests;
    }
}