package com.manuel.curso.springboot.jpa.springbootjparelationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.manuel.curso.springboot.jpa.springbootjparelationship.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

    

}
