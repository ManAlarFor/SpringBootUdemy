package com.manuel.curso.springboot.webapp.springbootweb.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.manuel.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola hola") String message) {

        ParamDto param = new ParamDto() ;

        param.setMessage(message) ;
        return param ;

    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam() String text, @RequestParam() int code) {

        ParamMixDto params = new ParamMixDto() ;

        params.setMessage(text);
        params.setCode(code);

        return params ;

    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        
        int code = 0 ;
        
        try{
            code = Integer.parseInt(request.getParameter("code")) ;
        } catch (NumberFormatException e) {}

        ParamMixDto params = new ParamMixDto() ;

        params.setCode(code) ;

        params.setMessage(request.getParameter("message"));

        return params ;

    }

}
