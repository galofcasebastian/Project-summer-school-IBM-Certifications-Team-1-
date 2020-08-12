package com.practica.project.service;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import com.practica.project.dto.ApplicantDto;
import com.practica.project.entity.Applicant;
import com.practica.project.mapper.ApplicantMapper;
import com.practica.project.repository.ApplicantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class ApplicantService {
    
    private final ApplicantRepository repository;
    private final ApplicantMapper mapper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;    

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

    public ApplicantDto toDto(Applicant applicant) {
        ApplicantDto dto = modelMapper.map(applicant, ApplicantDto.class);
        dto.setName(userService.getUsername());

        return dto;
    }

    public List<ApplicantDto> toDtoList(List<Applicant> applicantList) {
        return applicantList.stream()
            .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void toEntity(ApplicantDto personDto) {
        Applicant applicant = modelMapper.map(personDto, Applicant.class);

        /*if (person.getId() != null) {
            Applicant dbApplicant = ApplicantRepository.getOne(person.getId());
        }*/
    }
}