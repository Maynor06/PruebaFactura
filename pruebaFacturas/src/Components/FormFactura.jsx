import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router";
import "./FormFactura.css"

export const FormFactura = () => {

    const [dataFactura, setDataFactura] = useState({
        idCliente: "",
        total: "",
        estado: "PENDIENTE"
    })

    const handleChange = (e) => {
        const { name, value } = e.target;
        console.log(value);
        setDataFactura({ ...dataFactura, [name]: value })
    }


    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post("http://localhost:8080/facturas/createFactura", dataFactura);
            console.log(response.data);
            alert("Se ingreso la factura con exito!!")

        } catch (error) {
            alert("Error")

        }
    }

    const navigate = useNavigate();
    const handleExit = () => {
        navigate("/")
    }

    return (

        <>

            <button onClick={handleExit} >Regresar</button>
            <form onSubmit={handleSubmit} className="form" >
                <input type="number" name="idCliente" placeholder="ID Cliente" onChange={handleChange} required />
                <input type="number" step="0.01" name="total" placeholder="Total" onChange={handleChange} required />
                <select name="estado" onChange={handleChange}>
                    <option value="PENDIENTE">Pendiente</option>
                    <option value="PAGADA">Pagada</option>
                </select>
                <button type="submit">Crear Factura</button>
            </form>
        </>

    )
}