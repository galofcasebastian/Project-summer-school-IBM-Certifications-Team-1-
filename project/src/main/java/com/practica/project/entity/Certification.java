package com.practica.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "CERTIFICATIONS")
public class Certification{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "QUARTER", nullable = false)
    private int quarter; //The value of this field can be 1, 2, 3 or 4

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "COST", nullable = false)
    private int cost;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public int getQuarter(){
        return quarter;
    }

    public void setQuarter(int quarter){
        this.quarter=quarter;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost=cost;
    }
}