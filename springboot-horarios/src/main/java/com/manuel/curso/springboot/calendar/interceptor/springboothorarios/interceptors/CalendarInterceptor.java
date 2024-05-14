package com.manuel.curso.springboot.calendar.interceptor.springboothorarios.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@Component("calendarInterceptor")
public class CalendarInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private int open ;
    @Value("${config.calendar.close}")
    private int close ;

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {

                    Calendar calendar = Calendar.getInstance() ;

                    boolean access = false ;

                    int hour = calendar.get(Calendar.HOUR_OF_DAY) ;

                    System.out.println(hour);

                    if ((open <= hour)&&(hour < close)) {

                        StringBuilder message = new StringBuilder("Bienvenidos al horario de atencion a clientes, atendemos desde las " + open + " hasta las "+ close + ".Gracias por su visita") ;

                        request.setAttribute("message", message.toString()) ;

                        access = true ;

                    } else {

                        ObjectMapper mapper = new ObjectMapper() ;
                        Map<String, Object> data = new HashMap<>() ;

                        StringBuilder message = new StringBuilder("Cerrado, fuera del horario de atención, por favor, visitenos desde las "+ open + " hasta las "+close) ;

                        data.put("message", message.toString()) ;
                        data.put("Date", new Date()) ;

                        response.setContentType("application/json") ;
                        response.setStatus(401) ;
                        response.getWriter().write(mapper.writeValueAsString(data)) ;

                    }

                    return access ;
        }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        
    }

    

}
