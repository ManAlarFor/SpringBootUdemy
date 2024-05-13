package com.manuel.curso.springboot.webapp.springbootweb.controlers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.curso.springboot.webapp.springbootweb.models.User;
import com.manuel.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path="/details")
    public UserDto details() {

        User user = new User("Manuel","Alarcón") ;
        UserDto userDto = new UserDto() ;

        userDto.setUser(user) ;
        userDto.setTitle("Hola") ;
        //Map<String,Object> body = new HashMap<>() ;

        //body.put("title", "Hola Mundo Spring Boot") ;
        //body.put("user", user) ;

        return userDto ;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user = new User("Paco", "Party") ;
        User user2 = new User("Rick", "Sanchez") ;
        User user3 = new User("Kylian", "Mbappe") ;

        List<User> users = Arrays.asList(user, user2, user3) ;

        //List<User> users = new ArrayList<>() ;

        //users.add(user) ;
        //users.add(user2) ;
        //users.add(user3) ;

        return users ;
    }

    @GetMapping(path="/details-map")
    public Map<String,Object> detailsMap() {

        User user = new User("Manuel","Alarcón") ;
        Map<String,Object> body = new HashMap<>() ;

        body.put("title", "Hola Mundo Spring Boot") ;
        body.put("user", user) ;

        return body ;
    }

}
