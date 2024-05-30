import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product';
import { ProductService } from '../service/product.service';
import { FormComponent } from "./form/form.component";

@Component({
    selector: 'app-product',
    standalone: true,
    templateUrl: './product.component.html',
    styleUrl: './product.component.css',
    imports: [FormComponent]
})


export class ProductComponent implements OnInit {

    constructor(private service: ProductService) {}

    products: Product[] = [] ;

    productSelected: Product = new Product() ;


    ngOnInit(): void {
        this.service.findAll().subscribe(products => this.products = products) ;
    }

    onRemoveProduct(id: number) {

        this.service.delete(id).subscribe(() => {
            this.products = this.products.filter(product => product.id != id )
        })

    }

    addProduct(product: Product){

        if (product.id > 0 ) {

            if(!product.name || ! product.description || ! product.price) {

                alert("Debes llenar los campos") ;

            } else {

                this.service.update(product).subscribe( prodUptd => {

                    this.products = this.products.map(prod => {

                    if(prod.id == product.id) {
                        return {...prodUptd} ;
                    }
                        return prod ;
                    })

                }) ;
        }
        } else {

                if(!product.name || ! product.description || ! product.price) {

                alert("Debes llenar los campos") ;

            } else {
                this.service.create(product).subscribe( prod => {

                this.products = [... this.products, {...prod}] ;

                }) ;
            }
        }

        this.productSelected = new Product() ;

    }

    onUpdateProduct(productRow: Product) {

        this.service.update(productRow)
        this.productSelected = {...productRow} ;
    }


}
