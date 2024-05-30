import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductComponent } from './products/components/product.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ProductComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})



export class AppComponent {

    public title: string = 'Hola Mundo Angular 17';
    enabled: boolean = false ;

    courses: string[] = ['Angular', 'React', 'Spring Boot', 'Java']

    setEnabled() : void{
        this.enabled ? this.enabled = false : this.enabled = true ;
    }

}
