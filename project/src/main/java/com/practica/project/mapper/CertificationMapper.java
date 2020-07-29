package com.practica.project.mapper;

import com.practica.project.dto.CertificationDto;
import com.practica.project.entity.Certification;
import org.springframework.stereotype.Component;

@Component
public class CertificationMapper {
    
    public CertificationDto toDto(Certification entity){
        CertificationDto dto = new CertificationDto();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());

        return dto;
    }

    public Certification toEntity(CertificationDto dto){
        Certification entity = new Certification();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());

        return entity;
    }
}