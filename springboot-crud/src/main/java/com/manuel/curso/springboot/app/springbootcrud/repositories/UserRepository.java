package com.manuel.curso.springboot.app.springbootcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.manuel.curso.springboot.app.springbootcrud.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
}
