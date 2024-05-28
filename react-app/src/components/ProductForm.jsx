import { useEffect, useState } from "react";

const initialDataForm = {
    name: '',
    description: '',
    price: '',
}

// eslint-disable-next-line react/prop-types
export const ProductForm = ({productSelected,handlerAdd}) => {

    let [form, setForm] = useState(productSelected);;

    const {id, name, description, price} = form ;

    useEffect(() => {
        setForm(productSelected) ;
    }, [productSelected])

    return (


        <form onSubmit={(event) => {
            event.preventDefault() ;

            if(!name || !description || !price){
                alert('Debe completar los datos del formulario')
                return ;
            }

            //console.log(form);
            handlerAdd(form) ;

            setForm(initialDataForm) ;

        }}>
            <input
                placeholder="Name"
                className="form-control my-3 w-75"
                name="name"
                value={name}
                type="text"
                onChange={(event) => setForm({
                    ...form,
                    name:event.target.value
                })}
            />
            <input
                placeholder="Description"
                name="description"
                value={description}
                className="form-control my-3 w-75"
                type="text"
                onChange={(event) => setForm({
                    ...form,
                    description:event.target.value
                })}
            />
            <input
                placeholder="Price"
                className="form-control my-3 w-75"
                name="price"
                value={price}
                type="text"
                onChange={(event) => setForm({
                    ...form,
                    price:event.target.value
                })}
            />

                <button type="submit" className="btn btn-primary">

                    {id>0 ? "Update": "Create"}

                </button>

        </form>

    )

}