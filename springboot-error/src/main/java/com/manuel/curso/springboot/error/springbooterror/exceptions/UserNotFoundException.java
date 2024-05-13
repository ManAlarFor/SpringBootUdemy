package com.manuel.curso.springboot.error.springbooterror.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message) ;
    }

}
