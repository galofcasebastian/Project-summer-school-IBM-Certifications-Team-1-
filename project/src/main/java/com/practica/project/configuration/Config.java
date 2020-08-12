package com.practica.project.configuration;

import com.practica.project.entity.Applicant;
import com.practica.project.repository.ApplicantRepository;
import com.practica.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    @Bean
    public CommandLineRunner insertDemoData(ApplicantRepository personRepository) {
        return args -> {
            Applicant p1 = new Applicant();
            p1.setName("Person 1");

            personRepository.save(p1);

        };
    }

    @Bean
    public ModelMapper modelMapper() { // nici aici nu gasesc biblioteca
        return new ModelMapper();
    }

    @Bean
    public CommandLineRunner instantiateUsername(UserService userService) {
        return args -> userService.setUsername("NotAnAdmin");
    }
}