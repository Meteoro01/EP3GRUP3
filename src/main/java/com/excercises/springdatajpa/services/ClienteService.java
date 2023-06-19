package com.excercises.springdatajpa.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.excercises.springdatajpa.entidades.Cliente;

import com.excercises.springdatajpa.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Cliente obtenerClienteId(Long id) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new Exception("el Cliente no existe");
        }
    }

    public Cliente registrarCliente(Cliente cliente) {
        if (cliente.getId() == null) {
            // Nuevo cliente, establecer la fecha de creación y la fecha de modificación
            // como el mismo valor
            LocalDateTime now = LocalDateTime.now();
            cliente.setFechaCreacion(now);
            cliente.setFechaModificacion(null);
        } else {
            // Cliente existente, actualizar solo la fecha de modificación
            cliente.setFechaModificacion(LocalDateTime.now());
        }

        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) throws Exception {

        Optional<Cliente> opcionalCliente = clienteRepository.findById(id);

        if (opcionalCliente.isPresent()) {
            clienteRepository.delete(opcionalCliente.get());
        } else {
            throw new Exception("el Cliente no fue eliminado");
        }
    }
}
