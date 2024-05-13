package com.manuel.curso.springboot.error.springbooterror.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.manuel.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.manuel.curso.springboot.error.springbooterror.models.MyError;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> numberFormatException(Exception ex){

        Map<String, String> error = new HashMap<>() ;

        error.put("date", new Date().toString()) ;
        error.put("error", "Formato incorrecto al introducirlo al dígito") ;
        error.put("message", ex.getMessage()) ;
        error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.toString()) ;

        return error ;

    }

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<MyError> divisionByZero(Exception ex){

        MyError error = new MyError() ;

        error.setDate(new Date()) ;
        error.setError("Error division partido cero") ;
        error.setMessage(ex.getMessage()) ;
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()) ;

        return ResponseEntity.internalServerError().body(error) ;
    }

    @ExceptionHandler({NullPointerException.class,
                        HttpMessageNotWritableException.class,
                        UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> userNotFoundException(Exception ex){

        Map<String, Object> error = new HashMap<>() ;

        error.put("date", new Date()) ;
        error.put("error", "El usuario no existe") ;
        error.put("message", ex.getMessage()) ;
        error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value()) ;

        return error ;

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyError> notFoundEx(NoHandlerFoundException e){

        MyError error = new MyError() ;

        error.setError("Api no encontrada") ;
        error.setDate(new Date()) ;
        error.setMessage(e.getMessage()) ;
        error.setStatus(HttpStatus.NOT_FOUND.value()) ;

        return ResponseEntity.status(404).body(error) ;

    }

}
