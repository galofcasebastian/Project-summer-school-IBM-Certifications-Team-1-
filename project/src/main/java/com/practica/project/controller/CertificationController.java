package com.practica.project.controller;

import com.practica.project.dto.CertificationDto;
import com.practica.project.service.CertificationService;
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
@RequestMapping("/certifications")
@Validated
public class CertificationController {
    
    @Autowired
    private CertificationService certificationService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CertificationDto> createCertification(@Valid @RequestBody CertificationDto newCertificationDto) {
        CertificationDto createdCertificationDto = this.certificationService.saveCertification(newCertificationDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdCertificationDto);
    }

}