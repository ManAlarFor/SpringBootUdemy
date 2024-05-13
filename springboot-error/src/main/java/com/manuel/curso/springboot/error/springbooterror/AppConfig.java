package com.manuel.curso.springboot.error.springbooterror;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.manuel.curso.springboot.error.springbooterror.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    public List<User> UserServiceImpl() {
        List<User> users = new ArrayList<>() ;

        users.add(new User(1L, "Anakin", "Skywalker")) ;
        users.add(new User(2L, "San", "Jacobo")) ;
        users.add(new User(3L, "Harry", "Potter")) ;

        return users ;

    }

}
