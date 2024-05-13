package com.manuel.springboot.di.app.springbootdi.repositories;

import java.util.List;

import com.manuel.springboot.di.app.springbootdi.models.product;

public interface ProductRepository {

    List<product> findAll() ;

    product findById(Long id) ;

}
