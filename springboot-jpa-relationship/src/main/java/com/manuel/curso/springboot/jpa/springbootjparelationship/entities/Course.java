package com.manuel.curso.springboot.jpa.springbootjparelationship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;
    private String intructor ;

    public Course() {
    }

    public Course(String name, String intructor) {
        this.name = name;
        this.intructor = intructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntructor() {
        return intructor;
    }

    public void setIntructor(String intructor) {
        this.intructor = intructor;
    }

    


}
