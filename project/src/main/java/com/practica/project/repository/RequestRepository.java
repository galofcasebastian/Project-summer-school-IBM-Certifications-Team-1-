package com.practica.project.repository;

import com.practica.project.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findAllByQuarter(int quarter);

    List<Request> findAllByApprovalStatus(String approvalStatus);

}