package com.manuel.curso.springboot.error.springbooterror.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.manuel.curso.springboot.error.springbooterror.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users ;

    public UserServiceImpl() {

        this.users = new ArrayList<>() ;

        users.add(new User(1L, "Anakin", "Skywalker")) ;
        users.add(new User(2L, "San", "Jacobo")) ;
        users.add(new User(3L, "Harry", "Potter")) ;

    }

    @Override
    public List<User> findAll() {
        return null ;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = null ;

        for (User u : users) {

            if(u.getId().equals(id)){

                user = u ;

                break ;

            }

        }

        return Optional.ofNullable(user) ;

    }

}
