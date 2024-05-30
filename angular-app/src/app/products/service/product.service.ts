import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private products: Product[] = [
    {
      id:1 ,
      name: 'Mesa Comedor',
      description: 'Excelente Mesa',
      price: 42
    },
    {
      id:2 ,
      name: 'Katana',
      description: 'Perfecta para cocinar',
      price: 84
    }
  ] ;

  private  url: string = 'http://localhost:8080/products' ;
  constructor(private http: HttpClient) { }

  findAll(): Observable<Product[]> {
    return this.http.get(this.url)
          .pipe(map((response:any) => response._embedded.products as Product[]),
          ) ;
  }

  create(product: Product): Observable<Product> {
    return this.http.post<Product>(this.url, product) ;
  }

  update(product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.url}/${product.id}`, product) ;
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`) ;
  }

}
