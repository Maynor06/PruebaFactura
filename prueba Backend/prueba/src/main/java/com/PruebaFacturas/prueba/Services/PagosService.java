package com.PruebaFacturas.prueba.Services;

import com.PruebaFacturas.prueba.DTOs.PagosDTO;
import com.PruebaFacturas.prueba.Entitys.Pagos;
import com.PruebaFacturas.prueba.Repositories.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagosService {

    private PagoRepository pagoRepository;

    public PagosService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    private PagosDTO convertADto(Pagos pagos){
        PagosDTO pagosDTO = new PagosDTO();
        pagosDTO.setIdPago(pagos.getId());
        pagosDTO.setIdFactura(pagos.getFactura().getId());
        pagosDTO.setMontoPagado(pagos.getMontoPagado());
        pagosDTO.setMetodoPago(pagos.getMetodoPago());
        pagosDTO.setFechaPago(pagos.getFechaPago());

        return pagosDTO;
    }

    public List<PagosDTO> getAllPagos(Long idFactura){
        return pagoRepository.findByFacturaId(idFactura).stream()
                .map(pagos -> convertADto(pagos))
                .collect(Collectors.toList());
    }

    public PagosDTO guardarPago(PagosDTO pagoDto){
        Pagos pago = new Pagos();
        pago.setMontoPagado(pagoDto.getMontoPagado());
        pago.setMetodoPago(pagoDto.getMetodoPago());
        pago.setFechaPago(pagoDto.getFechaPago());
        pago = pagoRepository.save(pago);
        return convertADto(pago);
    }
}
