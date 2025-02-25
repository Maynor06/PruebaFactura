import { useEffect, useState } from 'react'
import './App.css'
import axios from 'axios'
import { useNavigate } from 'react-router'

function App() {

  const navigate = useNavigate();

  const handleCrear = () => {
    navigate("/Crear")
  }

  const hanldeBuscar = () => {
    navigate("/buscar")
  }

  const handleReporte = () => {
    navigate("/reporte")
  }

  return (
    <>
      <h1 className='title' >Gestor de Facturas</h1>
      <div className='contenedorButtons' >
        <button onClick={handleCrear}>Crear nueva factura</button>
        <button onClick={hanldeBuscar} >Buscar factura por numero factura</button>
        <button onClick={handleReporte} >Facturas de una temporada</button>
      </div>
    </>
  )
}

export default App
