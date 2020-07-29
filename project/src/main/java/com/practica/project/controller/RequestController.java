package com.practica.project.controller;

import com.practica.project.dto.RequestDto;
import com.practica.project.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/requests")
@Validated
public class RequestController {
    
    @Autowired
    private RequestService requestService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequestDto> addRequest(@Valid @RequestBody RequestDto newRequestDto){
        RequestDto createdRequestDto = this.requestService.addRequest(newRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequestDto);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequestDto> modifyRequest(@Valid @RequestBody RequestDto requestToBeModifiedDto){
        RequestDto modifiedRequestDto = this.requestService.modifyRequest(requestToBeModifiedDto);
        return ResponseEntity.ok().body(modifiedRequestDto);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> deleteRequest(@PathVariable("id") Integer requestId){
        this.requestService.deleteRequest(requestId);
        return ResponseEntity.ok().body("Request with id" + requestId + "was deleted succesfully!");
    }

    @GetMapping(value = "/quarter/{quarter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RequestDto>> getRequestsByQuarter(@PathVariable("quarter") int quarter){
        List<RequestDto> requestDtoList = this.requestService.getAllRequestsByQuarter(quarter);
        return ResponseEntity.ok().body(requestDtoList);
    }

    @GetMapping(value = "/approvalStatus/{approvalStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RequestDto>> getRequestsByApprovalStatus(@PathVariable("approvalStatus") String approvalStatus){
        List<RequestDto> requestDtoList = this.requestService.getAllRequestsByApprovalStatus(approvalStatus);
        return ResponseEntity.ok().body(requestDtoList);
    }
}