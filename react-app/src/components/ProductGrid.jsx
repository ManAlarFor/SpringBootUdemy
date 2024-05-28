import { ProductDetail } from "./ProductDetail";

import { PropTypes } from 'prop-types';

export const ProductGrid = ({handlerProductSelected, handlerRemove, products = []}) => {

    return (
        <>
            <div>
                <div className="container text-center">
                    <div className="row">
                        <div className="col">name</div>
                        <div className="col">price</div>
                        <div className="col">descripcion</div>
                        <div className="col">update</div>
                        <div className="col">remove</div>
                    </div>
                </div>
                <div className="row">
                    { products.map(product => {

                        return <ProductDetail handlerProductSelected={handlerProductSelected} handlerRemove={handlerRemove} product={product}  key={product.id}/>;

                    })}
                </div>
            </div>

        </>
    )

}

ProductGrid.propTypes = {

    products: PropTypes.array.isRequired,
    handlerRemove: PropTypes.func.isRequired,
    handlerProductSelected: PropTypes.func.isRequired

}