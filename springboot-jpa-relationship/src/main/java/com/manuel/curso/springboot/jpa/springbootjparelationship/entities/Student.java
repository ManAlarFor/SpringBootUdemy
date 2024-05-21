package com.manuel.curso.springboot.jpa.springbootjparelationship.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;
    private String lastname ;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="tbl_alumnos_cursos", joinColumns = @JoinColumn(name="alumno_id"),
    inverseJoinColumns= @JoinColumn(name="curso_id"),
    uniqueConstraints = @UniqueConstraint(columnNames ={"alumno_id","curso_id"}))
    private Set<Course> courses ;

    public Student(Set<Course> courses) {
        this.courses = courses;
    }

    public Student(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "{id=" + id +
        ", name=" + name +
        ", lastname=" + lastname +
        ", courses=" + courses +
        "}";
    }
    
}
