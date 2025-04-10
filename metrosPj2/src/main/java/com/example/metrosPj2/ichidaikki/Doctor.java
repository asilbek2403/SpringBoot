package com.example.metrosPj2.ichidaikki;

public class Doctor {

    private String name;
    private String surname;
    private Long id;
    private Integer age;
    private NamunaPatch patchW;

    public Doctor() {
    }

    public Doctor(String name, String surname, Long id, Integer age,NamunaPatch patchW) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.age = age;
        this.patchW = patchW;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public NamunaPatch getPatchW() {
        return patchW;
    }

    public void setPatchW(NamunaPatch patchW) {
        this.patchW = patchW;
    }
}
