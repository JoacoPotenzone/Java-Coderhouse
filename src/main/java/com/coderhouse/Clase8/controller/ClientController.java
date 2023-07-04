package com.coderhouse.Clase8.controller;

import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Object> postClient (@RequestBody Cliente client){
        try{
            System.out.println(client);
            Cliente clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Cliente guardado con exito",
                    HttpStatus.OK,
                    clientSaved
            );
        }catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getClient (@PathVariable() int id){
        try{
            System.out.println(id);
            Cliente clientFound = clientService.getClient(id);
            return ResponseHandler.generateResponse(
                    "Cliente fue obtenido con exito",
                    HttpStatus.OK,
                    clientFound
            );
        }catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Object> putCliente(@PathVariable() int id, @RequestBody Cliente client) {
        try {
            System.out.println(id);
            Cliente clientUpdated = clientService.putCliente(id, client);
            return ResponseHandler.generateResponse(
                    "Cliente actualizado correctamente",
                    HttpStatus.OK,
                    clientUpdated);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable() int id) {
        try {
            System.out.println(id);
            clientService.deleteCliente(id);
            return ResponseHandler.generateResponse(
                    "Cliente borrado exitosamente",
                    HttpStatus.OK,
                    null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }

}
