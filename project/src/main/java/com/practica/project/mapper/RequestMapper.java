package com.practica.project.mapper;

import com.practica.project.dto.RequestDto;
import com.practica.project.entity.Request;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class RequestMapper {
    
    private ApplicantMapper applicantMapper;
    private CertificationMapper certificationMapper;

    public RequestDto toDto(Request entity){
        RequestDto dto = new RequestDto();

        dto.setId(entity.getId());
        dto.setApprovalStatus(entity.getApprovalStatus());
        //dto.setApplicants(ApplicantMapper.toDto(entity.getApplicants());

        return dto;
    }

    public Request toEntity(RequestDto dto){
        Request entity = new Request();

        entity.setId(dto.getId());
        entity.setApprovalStatus(entity.getApprovalStatus());
        //entity.setApplicants(ApplicantMapper.toEntity(dto.getApplicants());

        return entity;
    }

    public List<RequestDto> toDtoList(List<Request> entityList){
        List<RequestDto> dtoList = new ArrayList<>();
        
        entityList.forEach(entity -> {
            dtoList.add(toDto(entity));
        });

        return dtoList;
    }
}