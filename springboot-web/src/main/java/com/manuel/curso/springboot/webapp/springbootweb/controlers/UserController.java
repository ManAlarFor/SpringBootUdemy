package com.manuel.curso.springboot.webapp.springbootweb.controlers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.manuel.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Map<String,Object> model) {

        User user = new User("Manuel","Alarcón") ;


        model.put("title", "Hola Mundo Spring Boot") ;
        model.put("user", user) ;
        user.setEmail("tuleperaa@gmail.com");

        return "details" ;
    }

    @GetMapping("/list")
    public String list(ModelMap model) {

        List<User> users = Arrays.asList(new User("Gojo", "Satoru"),
                                        new User("Andres", "FN"),
                                        new User("Ren", "Amamiya","mishima@gmail.com")) ;

        model.addAttribute("users", users) ;
        model.addAttribute("title", "Listado de Usuarios") ;

        return "List" ;

    }

}
