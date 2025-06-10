package com.abp.ubea.entities;

import com.abp.ubea.entities.enums.InterestStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_adoptions_requests")
public class AdoptionRequestEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime requestDate;

    @Enumerated(EnumType.STRING)
    private InterestStatus status;
    private LocalDateTime approvalDate;

    public AdoptionRequestEntity() {}

    public AdoptionRequestEntity(Integer id, LocalDateTime requestDate, InterestStatus status, LocalDateTime approvalDate) {
        this.id = id;
        this.requestDate = requestDate;
        this.status = status;
        this.approvalDate = approvalDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public InterestStatus getStatus() {
        return status;
    }

    public void setStatus(InterestStatus status) {
        this.status = status;
    }

    public LocalDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(LocalDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AdoptionRequestEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRequestDate(), that.getRequestDate()) && getStatus() == that.getStatus() && Objects.equals(getApprovalDate(), that.getApprovalDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRequestDate(), getStatus(), getApprovalDate());
    }
}
