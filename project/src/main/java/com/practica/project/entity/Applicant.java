package com.practica.project.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
@Table(name = "APPLICANTS")
public class Applicant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Request> requestList = new HashSet<>();

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Certification> certificationList = new HashSet<>();

    public void addRequest(Request newRequest){
        this.requestList.add(newRequest);
        newRequest.setApplicant(this);
    }
}