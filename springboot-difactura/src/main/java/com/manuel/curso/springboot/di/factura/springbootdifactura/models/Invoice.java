package com.manuel.curso.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@ApplicationScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client ;

    @Value("${invoice.description}")
    private String description ;

    @Autowired
    @Qualifier("default")
    private List<Item> items ;

    @PostConstruct
    public void init(){
        
        System.out.println("Creando el componente de la factura");

        client.setName(client.getName().concat(" Paco"));
        description = description.concat(" del cliente: ").concat(" ").concat(client.getLastName()) ;

        System.out.println(client);
        System.out.println();

    }

    @PreDestroy
    public void destroy() {

        System.out.println("Destruyendo el componente o bean invoice!");

    }

    public Invoice() {
        System.out.println("Creando el componente de la factura");
    }
    
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {

        //int total = 0 ;

        //for (Item item : items) {
        //    total += item.getImporte() ;
        //}

        int total = items.stream()
        .map(item -> item.getImporte())
        .reduce(0, (sum,importe) -> sum + importe) ;

        return total ;
    }

}
