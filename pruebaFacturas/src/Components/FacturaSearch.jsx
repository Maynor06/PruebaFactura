import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router";

export const FacturaSearch = () => {

    const [id, setId] = useState("");
    const [factura, setFactura] = useState(null);

    const buscarFact = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/facturas/${id}`)
            console.log(response.data);
            setFactura(response.data);

        } catch (error) {
            console.log(error);

        }
    }

    const navigate = useNavigate();
    const handleExit = () => {
        navigate("/")
    }

    return (
        <div>
            <button onClick={handleExit} >Regresar</button>
            <input type="number" placeholder="Id Factura" onChange={(e) => setId(e.target.value)} />
            <button onClick={buscarFact}>Buscar</button>
            {factura && (
                <div>
                    <h3>Factura {factura.idFactura}</h3>
                    <p>Cliente: {factura.idCliente}</p>
                    <p>Fecha: {factura.fechaEmision}</p>
                    <p>Total: {factura.total}</p>
                    <p>Estado: {factura.estado}</p>
                </div>
            )}
        </div>
    )
}