package com.practica.project.mapper;

import com.practica.project.dto.CertificationDto;
import com.practica.project.entity.Certification;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
public class CertificationMapper {
    
    public CertificationDto toDto(Certification entity){
        CertificationDto dto = new CertificationDto();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setCategory(entity.getCategory());
        dto.setCost(entity.getCost());
        
        return dto;
    }

    public Certification toEntity(CertificationDto dto){
        Certification entity = new Certification();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setCategory(dto.getCategory());
        entity.setCost(dto.getCost());

        return entity;
    }

    public Set<CertificationDto> toDtoSet(Set<Certification> certificationSet){
        Set<CertificationDto> dtoSet = new HashSet<>();

        certificationSet.forEach(courseEntity -> {
            dtoSet.add(toDto(courseEntity));
        });

        return dtoSet;
    }

    public Set<Certification> toEntitySet(Set<CertificationDto> certificationDtoSet){
        Set<Certification> entitySet = new HashSet<>();

        certificationDtoSet.forEach(courseDto -> {
            entitySet.add(toEntity(courseDto));
        });

        return entitySet;
    }
}