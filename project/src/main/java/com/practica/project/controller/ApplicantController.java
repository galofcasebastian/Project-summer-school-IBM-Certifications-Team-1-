package com.practica.project.controller;

import com.practica.project.dto.ApplicantDto;
import com.practica.project.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/applicants")
@Validated
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApplicantDto> createApplicant(@Valid @RequestBody ApplicantDto newApplicantDto) {
        ApplicantDto createdApplicantDto = this.applicantService.saveApplicant(newApplicantDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdApplicantDto);
    }
}