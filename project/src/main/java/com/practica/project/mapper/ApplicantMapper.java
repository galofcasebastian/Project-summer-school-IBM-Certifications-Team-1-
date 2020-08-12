package com.practica.project.mapper;

import java.util.HashSet;
import java.util.Set;
import com.practica.project.dto.ApplicantDto;
import com.practica.project.entity.Applicant;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper {
    
    private RequestMapper requestMapper;
    private CertificationMapper certificationMapper;

    public ApplicantDto toDto(Applicant entity){
        ApplicantDto dto = new ApplicantDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        /*dto.setCertificationList(certificationMapper.toDtoSet(entity.getCertificationList()));
        dto.setRequestList(requestMapper.toDtoSet(entity.getRequestList()));*/

        return dto;
    }

    public Applicant toEntity(ApplicantDto dto){
        Applicant entity = new Applicant();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        /*entity.setCertificationList(certificationMapper.toEntitySet(dto.getCertificationList()));
        entity.setRequestList(requestMapper.toEntitySet(dto.getRequestList()));*/

        return entity;
    }
    
    public Set<ApplicantDto> toDtoSet(Set<Applicant> applicantSet){
        Set<ApplicantDto> dtoSet = new HashSet<>();

        applicantSet.forEach(courseEntity -> {
            dtoSet.add(toDto(courseEntity));
        });

        return dtoSet;
    }

    public Set<Applicant> toEntitySet(Set<ApplicantDto> applicantDtoSet){
        Set<Applicant> entitySet = new HashSet<>();

        applicantDtoSet.forEach(courseDto -> {
            entitySet.add(toEntity(courseDto));
        });

        return entitySet;
    }
}