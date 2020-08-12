package com.practica.project.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name = "CERTIFICATIONS")
public class Certification{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "COST", nullable = false)
    private int cost;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    Certification certification;

    public Certification(String title, String category, int cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
}