package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.InvoiceDetail;
import com.coderhouse.Clase8.model.InvoiceDetailDTO;
import com.coderhouse.Clase8.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailService {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public void saveInvoiceDetail (InvoiceDetail invoiceDetail) throws Exception {
        invoiceDetailRepository.save(invoiceDetail);
    }

    public List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(int id_invoice) throws Exception {
        System.out.println(invoiceDetailRepository.getInvoiceDetailByInvoiceId(id_invoice));
        return invoiceDetailRepository.getInvoiceDetailByInvoiceId(id_invoice);
    }
}
