import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product } from '../../models/product';

@Component({
  selector: 'product-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})


export class FormComponent {

  @Input() product: Product = {
    id: 0,
    name:'',
    description: '',
    price: 0
  };

  @Output() newProductEvent = new EventEmitter() ;

  onSubmit(): void{
    this.newProductEvent.emit(this.product) ;
    console.log(this.product)
  }

  clean(): void{
    this.product = new Product() ;
  }

}
