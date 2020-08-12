package com.practica.project.mapper;

import com.practica.project.dto.RequestDto;
import com.practica.project.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Component
public class RequestMapper {
    
    private ApplicantMapper applicantMapper;
    private CertificationMapper certificationMapper;

    public RequestDto toDto(Request entity){
        RequestDto dto = new RequestDto();

        /*dto.setId(entity.getId());
        dto.setQuarter(entity.getQuarter());
        dto.setApprovalStatus(entity.getApprovalStatus());
        dto.setBusinessJustification(entity.getBusinessJustification());
        dto.setApplicants(applicantMapper.toDtoSet(entity.getApplicants()));*/

        return dto;
    }

    public Request toEntity(RequestDto dto){
        Request entity = new Request(null, null, null);

        /*entity.setId(dto.getId());
        entity.setQuarter(dto.getQuarter());
        entity.setApprovalStatus(dto.getApprovalStatus());
        entity.setApprovalStatus(entity.getApprovalStatus());
        entity.setApplicants(applicantMapper.toEntitySet(dto.getApplicants()));*/

        return entity;
    }

    public Set<RequestDto> toDtoSet(Set<Request> requestSet){
        Set<RequestDto> dtoSet = new HashSet<>();

        requestSet.forEach(courseEntity -> {
            dtoSet.add(toDto(courseEntity));
        });

        return dtoSet;
    }

    /*public Set<Request> toEntitySet(Set<RequestDto> requestDtoSet){
        Set<Request> entitySet = new HashSet<>();

        requestDtoSet.forEach(courseDto -> {
            entitySet.add(toEntity(courseDto));
        });

        return entitySet;
    }*/

    public List<RequestDto> toDtoList(List<Request> entityList){
        List<RequestDto> dtoList = new ArrayList<>();
        
        entityList.forEach(entity -> {
            dtoList.add(toDto(entity));
        });

        return dtoList;
    }

    @Autowired
    public void setApplicantMapper(ApplicantMapper applicantMapper){
        this.applicantMapper = applicantMapper;
    }

    @Autowired
    public void setCertificationMapper(CertificationMapper certificationMapper){
        this.certificationMapper = certificationMapper;
    }
}