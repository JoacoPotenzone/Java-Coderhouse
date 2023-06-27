package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.InvoiceDetail;
import com.coderhouse.Clase8.model.InvoiceDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

    @Query("SELECT new com.coderhouse.Clase8.model.InvoiceDetailDTO(" +
            "p.descripcion, " +
            "p.codigo, " +
            "d.precio, " +
            "d.cantidad" +
            ") FROM Invoice i JOIN i.invoiceDetail d JOIN d.product p WHERE i.id = :id")
    List<InvoiceDetailDTO> getInvoiceDetailByInvoiceId(@Param("id") int invoice_id);
}
