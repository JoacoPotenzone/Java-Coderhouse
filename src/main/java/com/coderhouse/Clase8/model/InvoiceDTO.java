package com.coderhouse.Clase8.model;
import java.util.Date;

public class InvoiceDTO {
    private int id_invoice;

    private String fecha;

    private int total;


    public InvoiceDTO(int id_invoice, String fecha, int total) {
        this.id_invoice = id_invoice;
        this.total = total;
        this.fecha = fecha;
    }


    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
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

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "id_invoice=" + id_invoice +
                ", fecha='" + fecha + '\'' +
                ", total=" + total +
                '}';
    }
}
