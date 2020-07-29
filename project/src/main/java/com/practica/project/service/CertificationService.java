package com.practica.project.service;

import com.practica.project.dto.CertificationDto;
import com.practica.project.entity.Certification;
import com.practica.project.mapper.CertificationMapper;
import com.practica.project.repository.CertificationRepository;
import org.springframework.stereotype.Service;

@Service
public class CertificationService {
    
    private final CertificationRepository repository;
    private final CertificationMapper mapper;

    public CertificationService(CertificationRepository repository, CertificationMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public CertificationDto saveCertification(CertificationDto applicantDto){
        Certification newApplicantEntity = this.mapper.toEntity(applicantDto);
        Certification savedApplicantEntity = this.repository.save(newApplicantEntity);
        CertificationDto savedApplicantDto = this.mapper.toDto(savedApplicantEntity);
        
        return savedApplicantDto;
    }
}