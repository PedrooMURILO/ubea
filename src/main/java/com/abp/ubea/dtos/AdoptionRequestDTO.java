package com.abp.ubea.dtos;

import com.abp.ubea.entities.enums.InterestStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdoptionRequestDTO implements Serializable {

    private Integer id;
    private LocalDateTime requestDate;
    private InterestStatus status;
    private LocalDateTime approvalDate;
    private UserDTOMin user;
    private List<CatDTOMin> cats = new ArrayList<>();

    public AdoptionRequestDTO() {}

    public AdoptionRequestDTO(Integer id, LocalDateTime requestDate, InterestStatus status, LocalDateTime approvalDate, UserDTOMin user) {
        this.id = id;
        this.requestDate = requestDate;
        this.status = status;
        this.approvalDate = approvalDate;
        this.user = user;
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

    public UserDTOMin getUser() {
        return user;
    }

    public void setUser(UserDTOMin user) {
        this.user = user;
    }

    public List<CatDTOMin> getCats() {
        return cats;
    }

    public void setCats(List<CatDTOMin> cats) {
        this.cats = cats;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AdoptionRequestDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRequestDate(), that.getRequestDate()) && getStatus() == that.getStatus() && Objects.equals(getApprovalDate(), that.getApprovalDate()) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getCats(), that.getCats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRequestDate(), getStatus(), getApprovalDate(), getUser(), getCats());
    }
}
