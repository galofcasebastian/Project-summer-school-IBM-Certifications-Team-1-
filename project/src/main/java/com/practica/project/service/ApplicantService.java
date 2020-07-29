package com.practica.project.service;

import com.practica.project.dto.ApplicantDto;
import com.practica.project.entity.Applicant;
import com.practica.project.mapper.ApplicantMapper;
import com.practica.project.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {
    
    private final ApplicantRepository repository;
    private final ApplicantMapper mapper;

    public ApplicantService(ApplicantRepository repository, ApplicantMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public ApplicantDto saveApplicant(ApplicantDto applicantDto){
        Applicant newApplicantEntity = this.mapper.toEntity(applicantDto);
        Applicant savedApplicantEntity = this.repository.save(newApplicantEntity);
        ApplicantDto savedApplicantDto = this.mapper.toDto(savedApplicantEntity);
        
        return savedApplicantDto;
    }
}