package com.manuel.springboot.di.app.springbootdi.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manuel.springboot.di.app.springbootdi.models.product;


public class ProductRepositoryJson implements ProductRepository {

    private List<product> list;

    public ProductRepositoryJson() {

        Resource resource = new ClassPathResource("json/product.json") ;
        ObjectMapper objectMapper = new ObjectMapper() ;
        
        try{
            list = Arrays.asList(objectMapper.readValue(resource.getFile(), product[].class)) ;
        } catch (StreamReadException e){
            e.printStackTrace() ;
        } catch (DatabindException e){
            e.printStackTrace() ;
        }catch (IOException e){
            e.printStackTrace() ;
        }

    }

    @Override
    public List<product> findAll() {
        return list ;
    }

    @Override
    public product findById(Long id){
        return list.stream().filter( p -> p.getId().equals(id)).findFirst().orElseThrow() ;
    }

}
