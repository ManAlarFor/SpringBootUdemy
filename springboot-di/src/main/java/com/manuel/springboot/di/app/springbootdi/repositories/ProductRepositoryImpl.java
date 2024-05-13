package com.manuel.springboot.di.app.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.manuel.springboot.di.app.springbootdi.models.product;


//@RequestScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<product> data ;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new product(1L, "Memoria corsair 32", 300L),
            new product(2L, "CPU Intel Core i9", 320L),
            new product(3L, "Teclado Razer 1000", 920L),
            new product(4L, "Raton chulo", 10L)
        ) ;
    }

    public List<product> findAll() {
        return data ;
    }

    public product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null) ;
    }

}
