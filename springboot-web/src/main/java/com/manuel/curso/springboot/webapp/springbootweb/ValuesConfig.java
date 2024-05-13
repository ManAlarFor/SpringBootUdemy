package com.manuel.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
    @PropertySources({
        @PropertySource(value="classpath:values.properties")
    })
public class ValuesConfig {

}
