package com.coderhouse.Clase8.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="product")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;

    private String codigo;

    private double precio;

    private int stock;

    @OneToMany(mappedBy = "product")
    private List<InvoiceDetail> invoiceDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String description) {
        this.descripcion = description;
    }

    public String getCode() {
        return codigo;
    }

    public void setCode(String code) {
        this.codigo = code;
    }

    public double getPrice() {
        return precio;
    }

    public void setPrice(double price) {
        this.precio = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", description='" + descripcion + '\'' +
                ", code='" + codigo + '\'' +
                ", price=" + precio +
                ", stock=" + stock +
                '}';
    }
}