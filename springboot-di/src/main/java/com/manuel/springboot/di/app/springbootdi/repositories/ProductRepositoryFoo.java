package com.manuel.springboot.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.manuel.springboot.di.app.springbootdi.models.product;

@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<product> findAll() {
        return Collections.singletonList(new product(1l, "Monitor Asus 27", 600L)) ;
    }

    @Override
    public product findById(Long id) {
        return new product(1l, "Monitor Asus 27", 600L) ;
    }

    

}
