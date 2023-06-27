package com.coderhouse.Clase8.model;
import java.sql.Date;
import java.util.List;

public class DetailsDTO {
    private int id_invoice;
    private String crear;
    private double total;
    private List<InvoiceDetailDTO> detalles;

    public DetailsDTO(int id_invoice, Date crear, double total, int id, List<InvoiceDetailDTO> detalles) {
        this.id_invoice = id_invoice;
        this.crear = String.valueOf(crear);
        this.total = total;
        this.detalles = detalles;
    }

    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
    }

    public String getCrear() {
        return crear;
    }

    public void setCrear(String crear) {
        this.crear = crear;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<InvoiceDetailDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<InvoiceDetailDTO> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "DetailsDTO{" +
                "id_invoice=" + id_invoice +
                ", crear='" + crear + '\'' +
                ", total=" + total +
                ", detalles=" + detalles +
                '}';
    }
}
