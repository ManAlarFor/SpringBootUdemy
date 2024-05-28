
import { PropTypes } from 'prop-types';


export const ProductDetail = ({handlerProductSelected, handlerRemove, product={}}) => {

    return(

        <div className='row'>

            <div className='col'>{product.name}</div>
            <div className='col'>{product.price}</div>
            <div className='col'>{product.description}</div>
            <div className='col'>
                <button className='rounded' onClick={() => handlerProductSelected(product.name)}>
                    Update
                </button>
            </div>
            <div className='col'>
                <button className='rounded' onClick={() => handlerRemove(product.name)}>
                    Remove
                </button>
            </div>

        </div>

        );

        ProductDetail.propTypes = {

            products: PropTypes.array.isRequired,
            handlerRemove: PropTypes.func.isRequired,
            handlerProductSelected: PropTypes.func.isRequired
        
        }

}