import axios from "axios";
import { useState } from "react"
import { useNavigate } from "react-router";

export const ObtenerFacturas = () => {
    const [fechaInicio, setFechaInicio] = useState(""); 
    const [fechaFin, setFechaFin] = useState("");
    const [facturas, setFacturas] = useState([]); 

    const buscarFacturas = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/facturas/reporte?fechaInicio=${fechaInicio}T00:00:00&fechaFin=${fechaFin}T23:59:59`)
            setFacturas(response.data);
            console.log(response.data);
            

        }catch(error){
            console.log(error);
            
        }
    }; 

    const navigate = useNavigate();
    const handleExit = () => {
        navigate("/")
    }

    return(
        <div>
            <button onClick={handleExit} >Regresar</button>
      <h2>Reporte de Facturas</h2>
      <p>Fecha Inicio</p>
      <input type="date" onChange={(e) => setFechaInicio(e.target.value)} />
      <p>Fecha final</p>
      <input type="date" onChange={(e) => setFechaFin(e.target.value)} />
      <button onClick={buscarFacturas}>Buscar</button>

      {facturas.length > 0 ? (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>ID Cliente</th>
              <th>Fecha Emisión</th>
              <th>Total</th>
              <th>Estado</th>
            </tr>
          </thead>
          <tbody>
            {facturas.map((factura) => (
              <tr key={factura.idFactura}>
                <td>{factura.idFactura}</td>
                <td>{factura.idCliente}</td>
                <td>{factura.fechaEmision}</td>
                <td>{factura.total}</td>
                <td>{factura.estado}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p>No hay facturas en este rango de fechas.</p>
      )}
    </div>
    )
}