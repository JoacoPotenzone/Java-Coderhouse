package com.coderhouse.Clase8.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="product")
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String descripcion;

    private String codigo;

    private double precio;

    private int stock;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    public void productoValidado(String title, String description, int stock, double price, String code)
            throws IllegalArgumentException {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Titulo no puedo estar vacío");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Descripcion no puede estar vacío");
        }
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Codigo no puede estar vacío");
        }
        try {
            Integer.parseInt(String.valueOf(stock));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Stock tiene que ser un número");
        }
        try {
            Double.parseDouble(String.valueOf(price));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Precio tiene que ser un número");
        }
        this.titulo = title;
        this.descripcion = description;
        this.stock = stock;
        this.precio = price;
        this.codigo = code;
    }
}