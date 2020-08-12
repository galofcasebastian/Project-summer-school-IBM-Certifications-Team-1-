package com.practica.project.repository;

import com.practica.project.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
//import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    @Query("SELECT request " +
            "FROM Request request " +
            "JOIN request.certification certification " +
            "WHERE certification = :quarter")
    List<Request> findAllByQuarter(int quarter);

    @Query("SELECT reqquest " +
            "FROM Request request " +
            "JOIN request.certification certification " +
            "WHERE certification = :approvalStatus")
    List<Request> findAllByApprovalStatus(String approvalStatus);
}