package com.manuel.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.manuel.springboot.di.app.springbootdi.models.product;
import com.manuel.springboot.di.app.springbootdi.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductRepository {

    //private Environment environment ;
    @Autowired
    private ProductRepository repository;

    @Value("${config.price.tax}")
    private Double tax;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<product> findAll() {

        return repository.findAll().stream().map(p -> {

            Double priceTax = p.getPrice()*tax ;

            //ESTOS SON PARA QUE SE MUTE EL ARRAY
            //p.setPrice(priceTax.longValue());
            //return p ;

            product newProd = (product) p.clone() ;

            newProd.setPrice(priceTax.longValue());

            return newProd ;

        }).collect(Collectors.toList()) ;

    }

    public product findById(Long id) {
        
        return repository.findById(id) ;

    }


    
}
