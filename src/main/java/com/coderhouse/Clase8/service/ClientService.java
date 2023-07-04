package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public Cliente postClient(Cliente cliente) throws Exception {
        try {
            cliente.clienteValidado(cliente.getName(), cliente.getLastname(), cliente.getDocnumber());
        } catch (IllegalArgumentException e) {
            throw new Exception("ERROR guardando el cliente " + e.getMessage());
        }
        return clientRepository.save(cliente);
    }

    public Cliente getClient(int id) throws Exception {
        Optional<Cliente> cliente = clientRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new Exception("Cliente con id: " + id + ", No encontrado");
        } else {
            return cliente.get();
        }
    }

    public boolean clientExist(int id) throws Exception {
        Optional<Cliente> cliente = clientRepository.findById(id);
        return cliente.isPresent();
    }

    public Cliente putCliente(int id, Cliente cliente) throws Exception {
        if (!clientExist(id)) {
            throw new Exception("Cliente con id: " + id + ", no encontrado");
        }
        try {
            Cliente existingClient = clientRepository.findById(id).get();
            if (cliente.getName() != null) {
                existingClient.setName(cliente.getName());
            }
            if (cliente.getLastname() != null) {
                existingClient.setLastname(cliente.getLastname());
            }
            if (cliente.getDocnumber() != null) {
                existingClient.setDocnumber(cliente.getDocnumber());
            }
            return clientRepository.save(existingClient);
        } catch (IllegalArgumentException e) {
            throw new Exception("Error en el guardado del cliente " + e.getMessage());
        }
    }


    public void deleteCliente(int id) throws Exception {
        if (!clientExist(id)) {
            throw new Exception("Cliente con id: " + id + ", no encontrado");
        }
        clientRepository.deleteById(id);
    }
}
