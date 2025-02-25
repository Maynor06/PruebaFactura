package com.PruebaFacturas.prueba.Controllers;

import com.PruebaFacturas.prueba.DTOs.FacturaDTO;
import com.PruebaFacturas.prueba.Services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/facturas")
public class FacturaController {


        @Autowired
        private FacturaService facturaService;


        @GetMapping("/{id}")
        public ResponseEntity<FacturaDTO> obtenerFacturaPorId(@PathVariable Long id) {
            return ResponseEntity.ok(facturaService.buscarFacturaPorId(id));
        }

        @PostMapping("/createFactura")
        public ResponseEntity<FacturaDTO> crearFactura(@RequestBody FacturaDTO facturaDTO) {
            return ResponseEntity.ok(facturaService.guardarFactura(facturaDTO));
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminarFactura(@PathVariable Long id) {
            facturaService.eliminarFactura(id);
            return ResponseEntity.ok("Factura eliminada");
        }

        @GetMapping("/reporte")
        public ResponseEntity<List<FacturaDTO>> obtenerFacturasPorRangoFechas(
                @RequestParam String fechaInicio,
                @RequestParam String fechaFin) {
            LocalDateTime inicio = LocalDateTime.parse(fechaInicio);
            LocalDateTime fin = LocalDateTime.parse(fechaFin);

            return ResponseEntity.ok(facturaService.obtenerFacturasPorRangoFechas(inicio, fin));
        }



}
