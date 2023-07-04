package com.coderhouse.Clase8.model;
import java.util.List;

public class InvoiceRequest {
    private int idCliente;
    private List<ProductoDetails> listaProducto;

    public InvoiceRequest(int idCliente, List<ProductoDetails> listaProducto) {
        this.idCliente = idCliente;
        this.listaProducto = listaProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<ProductoDetails> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<ProductoDetails> listaProducto) {
        this.listaProducto = listaProducto;
    }
}
