package com.coderhouse.Clase8.controller;

import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.DetailsDTO;
import com.coderhouse.Clase8.model.Invoice;
import com.coderhouse.Clase8.model.InvoiceDTO;
import com.coderhouse.Clase8.model.InvoiceRequest;
import com.coderhouse.Clase8.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Object> postInvoice(@RequestBody InvoiceRequest invRequest) {
        try {
            System.out.println(invRequest);
            InvoiceDTO invoiceFound = invoiceService.postInvoice(invRequest);
            return ResponseHandler.generateResponse(
                    "Factura creada con exito",
                    HttpStatus.OK,
                    invoiceFound);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }

    @GetMapping(path = "{invoice_id}")
    public ResponseEntity<Object> getInvoiceById(@PathVariable int invoice_id) {
        try {
            System.out.println(invoice_id);
            DetailsDTO data = invoiceService.getInvoiceById(invoice_id);
            return ResponseHandler.generateResponse(
                    "Has obtenido factura con id exitosamente ",
                    HttpStatus.OK,
                    data);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }

    @GetMapping(path = "/getInvoicesByClientId/{clientId}")
    public ResponseEntity<Object> getInvoiceByClientId(@PathVariable int clientId) {
        try {
            List<InvoiceDTO> data = invoiceService.getInvoiceByClientId(clientId);
            return ResponseHandler.generateResponse(
                    "Has obtenido la factura  con id_cliente exitosamente",
                    HttpStatus.OK,
                    data);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }
}