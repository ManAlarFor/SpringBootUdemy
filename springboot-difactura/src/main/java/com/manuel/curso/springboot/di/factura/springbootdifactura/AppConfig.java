package com.manuel.curso.springboot.di.factura.springbootdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.manuel.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.manuel.curso.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    
    @Bean
    //@Primary
    List<Item> itemsInvoice() {

        Product p1 = new Product("Play Station 5", 400 ) ;
        Product p2 = new Product("Mortadela de aceitunas", 12 ) ;

        return Arrays.asList(new Item(p1,2), new Item(p2,4)) ;

    } ;

    @Bean("default")
    List<Item> itemsInvoiceOffice() {

        Product p1 = new Product("Torpedo", 1000 ) ;
        Product p2 = new Product("Botella de agua", 2 ) ;
        Product p3 = new Product("Poster", 1 ) ;
        Product p4 = new Product("Ratón Gaming", 600 ) ;

        return Arrays.asList(new Item(p1,3), new Item(p2,6), new Item(p3,10), new Item(p4,3)) ;

    } ;

}
