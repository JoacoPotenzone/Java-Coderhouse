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


    public Cliente postClient(Cliente client) throws Exception {
        return clientRepository.save(client);
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

    public Cliente putCliente(int id, Cliente client) {
        return client;
    }

    public void deleteCliente(int id) {
    }
}
