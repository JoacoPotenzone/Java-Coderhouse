package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.Invoice;
import com.coderhouse.Clase8.model.InvoiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("SELECT new com.coderhouse.Clase8.model.InvoiceDTO(" +
            "i.id id_invoice, " +
            "i.fecha, " +
            "i.total" +
            ") FROM Invoice i INNER JOIN i.cliente c WHERE c.id = :id")
    List<InvoiceDTO> getInvoiceByClienteId(@Param("id") int id);
}
