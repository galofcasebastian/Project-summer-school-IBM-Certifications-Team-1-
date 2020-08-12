package com.practica.project.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name = "REQUESTS")
public class Request {
    
    public enum quarter {
        
        Q1, Q2, Q3, Q4;

        private String myQuarter;

        public String getQuarter(){
            return myQuarter;
        }
    
        public void setQuarter(String myQuarter){
            this.myQuarter = myQuarter;
        }

        public static quarter checkResponse(String myQuarter) {
            switch (myQuarter) {
            case "Q1":
                return quarter.Q1;
            case "Q2":
                 return quarter.Q2;
            case "Q3":
                 return quarter.Q3;
            case "Q4":
                 return quarter.Q4;
            default:
                throw new IllegalArgumentException("Quarter [" + myQuarter
                        + "] is invalid!");
            }
        }
    }

    public enum approvalStatus {
        
        Pending, Approved, Rejected;

        private String myApprovalStatus;

        public String getApprovalStatus() {
            return myApprovalStatus;
        }

        public void setApprovalStatus(String myApprovalStatus) {
            this.myApprovalStatus = myApprovalStatus;
        }

        public static approvalStatus checkResponse(String myApprovalStatus) {
            switch (myApprovalStatus) {
            case "Pending":
                return approvalStatus.Pending;
            case "Approved":
                return approvalStatus.Approved;
            case "Rejected":
                return approvalStatus.Rejected;
            default:
                throw new IllegalArgumentException("Approval status" + myApprovalStatus
                        + "] is invalid!");
            }
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "QUARTER", nullable = false)
    private String myQuarter;

    @Column(name = "APPROVAL_STATUS", nullable = false)
    private String myApprovalStatus;

    @Column(name = "BUSINESS_JUSTIFICATION", nullable = false)
    private String businessJustification;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    @JsonIgnore
    Applicant applicant;

    public Request(String myQuarter, String myApprovalStatus, String businessJustification){
        this.myQuarter = myQuarter;
        this.myApprovalStatus = myApprovalStatus;
        this.businessJustification = businessJustification;
    }
}