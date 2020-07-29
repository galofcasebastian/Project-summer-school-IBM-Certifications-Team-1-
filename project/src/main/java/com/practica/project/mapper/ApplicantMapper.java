package com.practica.project.mapper;

import com.practica.project.dto.ApplicantDto;
import com.practica.project.entity.Applicant;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper {
    
    public ApplicantDto toDto(Applicant entity){
        ApplicantDto dto = new ApplicantDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());

        return dto;
    }

    public Applicant toEntity(ApplicantDto dto){
        Applicant entity = new Applicant();

        entity.setId(dto.getId());
        entity.setName(dto.getName());

        return entity;
    }
}