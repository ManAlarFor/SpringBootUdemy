package com.manuel.springboot.di.app.springbootdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.manuel.springboot.di.app.springbootdi.repositories.ProductRepository;
import com.manuel.springboot.di.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:values.properties")
public class AppConfig {

    @Bean
    @Primary
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson() ;
    }

}
