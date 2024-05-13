package com.manuel.curso.springboot.webapp.springbootweb.models.dto;

public class ParamMixDto {

    private String message ;
    private int code ;

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
