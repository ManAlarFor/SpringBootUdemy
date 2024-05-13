package com.manuel.springboot.di.app.springbootdi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.springboot.di.app.springbootdi.models.product;
import com.manuel.springboot.di.app.springbootdi.services.ProductServiceImpl;


@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductServiceImpl service ;

    @GetMapping
    public List<product> list() {

        return service.findAll() ;

    }

    @GetMapping("/{id}")
    public product show(@PathVariable Long id) {

        return service.findById(id);

    }
    

}
