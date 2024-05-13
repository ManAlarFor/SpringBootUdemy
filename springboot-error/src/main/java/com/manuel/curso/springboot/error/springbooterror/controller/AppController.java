package com.manuel.curso.springboot.error.springbooterror.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.manuel.curso.springboot.error.springbooterror.models.domain.User;
import com.manuel.curso.springboot.error.springbooterror.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service ;

    @GetMapping
    public String index() {

        //int value = 100 / 0 ;

        int value = Integer.parseInt( "10xda") ;

        System.out.println(value);

        return "ok 200" ;

    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id){

        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error, el usuario no existe") ) ;

        return user ;

    }

}
