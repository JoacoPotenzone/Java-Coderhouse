package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public Cliente postClient(Cliente client) throws Exception {
        return clientRepository.save(client);
    }
}
