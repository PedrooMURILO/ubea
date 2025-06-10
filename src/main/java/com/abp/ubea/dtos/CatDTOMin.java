package com.abp.ubea.dtos;

import java.io.Serializable;
import java.util.Objects;

public class CatDTOMin implements Serializable {

    private Integer id;
    private String name;
    private Character sex;
    private Byte age;
    private String description;
    private Boolean adopted;

    public CatDTOMin() {}

    public CatDTOMin(Integer id, String name, Character sex, Byte age, String description, Boolean adopted) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.description = description;
        this.adopted = adopted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAdopted() {
        return adopted;
    }

    public void setAdopted(Boolean adopted) {
        this.adopted = adopted;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CatDTOMin catDTOMin)) return false;
        return Objects.equals(getId(), catDTOMin.getId()) && Objects.equals(getName(), catDTOMin.getName()) && Objects.equals(getSex(), catDTOMin.getSex()) && Objects.equals(getAge(), catDTOMin.getAge()) && Objects.equals(getDescription(), catDTOMin.getDescription()) && Objects.equals(getAdopted(), catDTOMin.getAdopted());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSex(), getAge(), getDescription(), getAdopted());
    }
}
