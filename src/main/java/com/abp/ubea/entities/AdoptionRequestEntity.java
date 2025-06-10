package com.abp.ubea.entities;

import com.abp.ubea.entities.enums.InterestStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(name = "adopter_id")
    private UserEntity adopter;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_ordered_cats",
            joinColumns = @JoinColumn(name = "adoption_request_id"),
            inverseJoinColumns = @JoinColumn(name = "cat_id")
    )
    private List<CatEntity> cats = new ArrayList<>();

    public AdoptionRequestEntity() {}

    public AdoptionRequestEntity(Integer id, LocalDateTime requestDate, InterestStatus status, LocalDateTime approvalDate, UserEntity adopter) {
        this.id = id;
        this.requestDate = requestDate;
        this.status = status;
        this.approvalDate = approvalDate;
        this.adopter = adopter;
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

    public UserEntity getUser() {
        return adopter;
    }

    public void setUser(UserEntity adopter) {
        this.adopter = adopter;
    }

    public List<CatEntity> getCats() {
        return cats;
    }

    public void setCats(List<CatEntity> cats) {
        this.cats = cats;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AdoptionRequestEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getRequestDate(), that.getRequestDate()) && getStatus() == that.getStatus() && Objects.equals(getApprovalDate(), that.getApprovalDate()) && Objects.equals(adopter, that.adopter) && Objects.equals(getCats(), that.getCats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRequestDate(), getStatus(), getApprovalDate(), adopter, getCats());
    }
}
