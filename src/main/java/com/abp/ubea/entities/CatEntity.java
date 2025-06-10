package com.abp.ubea.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_cats")
public class CatEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Character sex;
    private Byte age;
    private String description;
    private Boolean adopted;

    public CatEntity() {}

    public CatEntity(Integer id, String name, Character sex, Byte age, String description, Boolean adopted) {
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
        if (!(o instanceof CatEntity catEntity)) return false;
        return Objects.equals(getId(), catEntity.getId()) && Objects.equals(getName(), catEntity.getName()) && Objects.equals(getSex(), catEntity.getSex()) && Objects.equals(getAge(), catEntity.getAge()) && Objects.equals(getDescription(), catEntity.getDescription()) && Objects.equals(getAdopted(), catEntity.getAdopted());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSex(), getAge(), getDescription(), getAdopted());
    }
}
