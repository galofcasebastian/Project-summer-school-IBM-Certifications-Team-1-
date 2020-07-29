package com.practica.project.service;

import com.practica.project.dto.RequestDto;
import com.practica.project.entity.Request;
import com.practica.project.mapper.RequestMapper;
import com.practica.project.repository.RequestRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    private final RequestRepository repository;
    private final RequestMapper mapper;

    public RequestService(RequestRepository repository, RequestMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public RequestDto addRequest(RequestDto requestDto){
        Request newRequestEntity = this.mapper.toEntity(requestDto);
        Request addedRequestEntity = this.repository.save(newRequestEntity);
        RequestDto addedRequestDto = this.mapper.toDto(addedRequestEntity);

        return addedRequestDto;
    }

    public RequestDto modifyRequest(RequestDto requestDto){
        Optional<Request> existingRequestOptional = this.repository.findById(requestDto.getId());
        existingRequestOptional.orElseThrow(() -> new IllegalArgumentException("There is no request with the given id!"));
        Request newRequestEntity = this.mapper.toEntity(requestDto);
        Request modifiedRequestEntity = this.repository.save(newRequestEntity);
        RequestDto modifiedRequestDto = this.mapper.toDto(modifiedRequestEntity);
        
        return modifiedRequestDto;
    }

    public void deleteRequest(int id){
        this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("There is no request with the given id!"));
        this.repository.deleteById(id);
    }

    public List<RequestDto> getAllRequestsByQuarter(int quarter){
        List<Request> requestList = this.repository.findAllByQuarter(quarter);
        List<RequestDto> requestDtoList = this.mapper.toDtoList(requestList);

        return requestDtoList;
    }

    public List<RequestDto> getAllRequestsByApprovalStatus(String approvalStatus){
        List<Request> requestList = this.repository.findAllByApprovalStatus(approvalStatus);
        List<RequestDto> requestDtoList = this.mapper.toDtoList(requestList);

        return requestDtoList;
    }
}