import { PropTypes } from 'prop-types';
import { useEffect, useState } from "react";
import { listProduct } from "../services/ProductService";
import { ProductForm } from './ProductForm';
import { ProductGrid } from "./ProductGrid";

export const ProductApp = ({title}) => {

    const  [products,setProducts] = useState([]) ;

    const [productSelected, setProductSelected] = useState({
        name: '',
        description: '',
        price: '',
    }) ;

    useEffect(() => {

        const result = listProduct() ;

        setProducts(result) ;
    }, [])


    const handlerAddProduct = (product) => {
        console.log(product) ;

        if(products.includes(product)) {
            
            setProducts(products.map(prod => {
                if(prod.name == product.name){
                    return {...product}
                }
    
                return prod ;
    
            }))
        } else {

            setProducts([...products, {...product}]) ;

        }

    }

    const handlerRemoveProduct = (name) => {
        console.log(name) ;
        setProducts(products.filter(product => product.name != name)) ;
    }

    const handlerProductSelected = (product) => {
        setProductSelected({...product})
    }

    return (

        <div>
            <h1>{title.text}</h1>

            <div className='container my-4 mb-5'>

                <div>
                    <ProductForm handlerAdd={handlerAddProduct} productSelected={productSelected}/>
                </div>

                <div>
                    <ProductGrid  products={products} handlerRemove={handlerRemoveProduct} handlerProductSelected={handlerProductSelected}/>
                </div>
            </div>


        </div>

    );

}

ProductApp.propTypes = {

    products: PropTypes.arrayOf(
        PropTypes.shape({
            name: PropTypes.string.isRequired,
            description: PropTypes.string.isRequired,
            price: PropTypes.number.isRequired,
        })
    )

}