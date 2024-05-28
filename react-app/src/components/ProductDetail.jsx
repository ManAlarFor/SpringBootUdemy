
import { PropTypes } from 'prop-types';


export const ProductDetail = ({handlerProductSelected, handlerRemove, product={}}) => {

    return(

        <tr>

            <td>{product.name}</td>
            <td>{product.price}</td>
            <td>{product.description}</td>
            <td>
                <button className='btn btn-secondary  btn-sm rounded' onClick={() => handlerProductSelected(product.id)}>
                    Update
                </button>
            </td>
            <td>
                <button className='btn btn-danger  btn-sm rounded' onClick={() => handlerRemove(product.id)}>
                    Remove
                </button>
            </td>

        </tr>

        );

        ProductDetail.propTypes = {

            products: PropTypes.array.isRequired,
            handlerRemove: PropTypes.func.isRequired,
            handlerProductSelected: PropTypes.func.isRequired
        
        }

}