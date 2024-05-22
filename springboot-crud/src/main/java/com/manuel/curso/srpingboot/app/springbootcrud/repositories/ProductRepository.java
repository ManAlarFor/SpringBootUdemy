package com.manuel.curso.srpingboot.app.springbootcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.manuel.curso.srpingboot.app.springbootcrud.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
