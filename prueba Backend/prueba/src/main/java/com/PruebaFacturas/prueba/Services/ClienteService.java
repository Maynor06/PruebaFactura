package com.PruebaFacturas.prueba.Services;

import com.PruebaFacturas.prueba.DTOs.ClineteDTO;
import com.PruebaFacturas.prueba.Entitys.Cliente;
import com.PruebaFacturas.prueba.Repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // funcion para convertir un model a un DTO
    private ClineteDTO convertClientADTO(Cliente cliente) {
        ClineteDTO clienteDTO = new ClineteDTO();
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setTelefono(cliente.getNumeroTelefono());
        clienteDTO.setFechaRegistro(cliente.getFechaRegistro());
        return clienteDTO;
    }


    public List<ClineteDTO> findAll() {
        return clienteRepository.findAll()
                .stream().map(cliente -> convertClientADTO(cliente))
                .collect(Collectors.toList());
    }

    public ClineteDTO findById(Long id) {

        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return convertClientADTO(cliente);

    }

    public ClineteDTO guardarCliente(ClineteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setNumeroTelefono(clienteDTO.getTelefono());

        cliente = clienteRepository.save(cliente);

        return convertClientADTO(cliente);
    }

}
