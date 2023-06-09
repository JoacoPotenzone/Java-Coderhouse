package com.coderhouse.Clase8.model;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="factura")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="id_client")
    private Cliente cliente;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetail;

    private String fecha;
    private int total;






    public Invoice(int id, String fecha, int total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
    }

    public Invoice() {

    }


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<InvoiceDetail> getInvoiceDetail() {

        return invoiceDetail;
    }

    public void setInvoiceDetail(List<InvoiceDetail> invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}
