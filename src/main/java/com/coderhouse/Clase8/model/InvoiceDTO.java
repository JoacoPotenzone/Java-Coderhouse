package com.coderhouse.Clase8.model;
import java.util.Date;

public class InvoiceDTO {
    private int id_invoice;

    private int id_client;

    private int total;

    private Date fecha;

    public InvoiceDTO(int id_invoice, int id_client, int total, Date fecha) {
        this.id_invoice = id_invoice;
        this.id_client = id_client;
        this.total = total;
        this.fecha = fecha;
    }

    public InvoiceDTO(int id, java.sql.Date fecha, int total) {
    }

    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
