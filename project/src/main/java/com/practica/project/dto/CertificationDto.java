package com.practica.project.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class CertificationDto{
    
    private Integer id;
    @Positive
    private int quarter;
    @NotEmpty
    private String title;
    @NotEmpty
    private String category;
    @Positive
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