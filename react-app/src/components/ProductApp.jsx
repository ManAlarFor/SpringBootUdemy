import { PropTypes } from 'prop-types';
import { useEffect, useState } from "react";
import { create, findAll, remove, update } from '../services/ProductService';
import { ProductForm } from './ProductForm';
import { ProductGrid } from "./ProductGrid";

export const ProductApp = ({title}) => {

    const  [products,setProducts] = useState([]) ;

    const [productSelected, setProductSelected] = useState({
        name: '',
        description: '',
        price: '',
    }) ;

    const getProducts = async () => {
        const result = await findAll() ;
        setProducts(result.data._embedded.products) ;
    }

    useEffect(() => {
        getProducts() ;
    }, [])


    const handlerAddProduct = async (product) => {
        console.log(product) ;

        if(product.id > 0) {
            

            const response = await update(product) ;

            setProducts(products.map(prod => {
                if(prod.id == response.data.id){
                    return {...response.data}
                }
    
                return prod ;
    
            }))
        } else {

            const response = await create(product) ;

            setProducts([...products, {...response.data}]) ;

        }

    }

    const handlerRemoveProduct = (id) => {
        console.log(id) ;

        remove(id) ;

        setProducts(products.filter(product => product.id != id)) ;
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