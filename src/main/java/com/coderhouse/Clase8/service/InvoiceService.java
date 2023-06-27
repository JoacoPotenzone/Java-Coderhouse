package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.*;
import com.coderhouse.Clase8.repository.ClientRepository;
import com.coderhouse.Clase8.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;
    @Autowired
    private ClientService clientService;

    public InvoiceDTO postInvoice(InvoiceRequest requestInvoice) throws Exception {

        Cliente clientExist = clientService.getClient(requestInvoice.getIdCliente());

        List<Producto> productList = productService.getProductById(requestInvoice.getListaProducto());

        double total = 0;
        int i = 0;
        for (Producto product : productList) {
            total += product.getPrice() * requestInvoice.getListaProducto().get(i).getCantidad();
            i++;
        }

        Invoice invoiceCreated = new Invoice();

        invoiceCreated.setFecha(java.sql.Date.valueOf(new Date().toString()));

        invoiceCreated.setCliente(clientExist);

        invoiceCreated.setTotal((int) total);

        invoiceCreated = invoiceRepository.save(invoiceCreated);


        i = 0;
        for (Producto productForDetail : productList) {
            InvoiceDetail newInvoice = new InvoiceDetail();
            newInvoice.setPrecio(productForDetail.getPrice());
            newInvoice.setInvoice(invoiceCreated);
            newInvoice.setProduct(productForDetail);
            newInvoice.setCantidad(requestInvoice.getListaProducto().get(i).getCantidad());
            invoiceDetailService.saveInvoiceDetail(newInvoice);
            i++;
        }

        return new InvoiceDTO(
                invoiceCreated.getId(),
                invoiceCreated.getFecha(),
                invoiceCreated.getTotal());
    }

    public List<InvoiceDTO> getInvoiceByClientId(int clientId) throws Exception {
        System.out.println(clientId);
        return invoiceRepository.getInvoiceByClienteId(clientId);
    }

    public DetailsDTO getInvoiceById(int invoice_id) throws Exception {
        Optional<Invoice> invoiceFound = invoiceRepository.findById(invoice_id);
        if (invoiceFound.isEmpty()) {
            throw new Exception("Invoice no encontrado");
        }

        List<InvoiceDetailDTO> invoiceDetail = invoiceDetailService.getInvoiceDetailByInvoiceId(invoice_id);

        return new DetailsDTO(
                invoiceFound.get().getId(),
                invoiceFound.get().getFecha(),
                invoiceFound.get().getTotal(),
                invoiceFound.get().getCliente().getId(),
                invoiceDetail);
    }
}
