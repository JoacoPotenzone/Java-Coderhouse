package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.*;
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
    private ProductService productService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;
    @Autowired
    private ClientService clientService;

    public InvoiceDTO postInvoice(InvoiceRequest requestInvoice) throws Exception {

        Cliente clientExist = clientService.getClient(requestInvoice.getIdCliente());
        if (clientExist == null){
            throw new Exception("Cliente no existe");
        }
        List<Producto> listaProducto = productService.getIdProducto(requestInvoice.getListaProducto());
        if (listaProducto == null){
            throw new Exception("No existe la lista Producto");
        }
        if (listaProducto.size() != requestInvoice.getListaProducto().size()){
            throw new Exception("No existen los productos");
        }
        for (int i = 0; i < listaProducto.size(); i++) {
            Producto product = listaProducto.get(i);
            int requestedQuantity = requestInvoice.getListaProducto().get(i).getCantidad();
            if (requestedQuantity > product.getStock()) {
                throw new Exception("Stock insuficiente de producto: " + product.getTitulo());
            }
        }

        double total = 0;
        int i = 0;
        for (Producto product : listaProducto) {
            total += product.getPrecio() * requestInvoice.getListaProducto().get(i).getCantidad();
            i++;
        }

        Invoice invoiceCreated = new Invoice();

        invoiceCreated.setFecha(new Date().toString());

        invoiceCreated.setCliente(clientExist);

        invoiceCreated.setTotal((int) total);

        invoiceCreated = invoiceRepository.save(invoiceCreated);


        i = 0;
        for (Producto productForDetail : listaProducto) {
            InvoiceDetail newInvoice = new InvoiceDetail();
            newInvoice.setPrecio(productForDetail.getPrecio());
            newInvoice.setInvoice(invoiceCreated);
            newInvoice.setProduct(productForDetail);
            newInvoice.setCantidad(requestInvoice.getListaProducto().get(i).getCantidad());
            invoiceDetailService.saveInvoiceDetail(newInvoice);
            productForDetail.setStock(productForDetail.getStock() - requestInvoice.getListaProducto().get(i).getCantidad());
            productService.saveProducto(productForDetail);

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
            throw new Exception("Factura no encontrada");
        }

        List<InvoiceDetailDTO> invoiceDetail = invoiceDetailService.getInvoiceDetailsByInvoiceId(invoice_id);

        return new DetailsDTO(
                invoiceFound.get().getId(),
                invoiceFound.get().getFecha(),
                invoiceFound.get().getTotal(),
                invoiceFound.get().getCliente().getId(),
                invoiceDetail);
    }
}
