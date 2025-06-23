package com.abp.ubea.dtos;

import com.abp.ubea.entities.enums.UserRole;

import java.io.Serializable;
import java.util.Objects;

public class UserDTOMin implements Serializable {

    private Integer id;
    private String username;
    private String email;
    private UserRole role;
    private String phone;

    public UserDTOMin() {}

    public UserDTOMin(Integer id, String username, String email, UserRole role, String phone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserDTOMin that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getEmail(), that.getEmail()) && getRole() == that.getRole() && Objects.equals(getPhone(), that.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmail(), getRole(), getPhone());
    }
}
