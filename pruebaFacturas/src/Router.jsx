import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import App from './App';
import { FormFactura } from './Components/FormFactura';
import { FacturaSearch } from './Components/FacturaSearch';
import { ObtenerFacturas } from './Components/ObtenerFacturas';

export const RouterComponent = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<App />} />
                <Route path='/Crear' element={<FormFactura />} />
                <Route path='/buscar' element={<FacturaSearch />} />
                <Route path='/reporte' element={<ObtenerFacturas />} />
            </Routes>
        </BrowserRouter>
    )
}