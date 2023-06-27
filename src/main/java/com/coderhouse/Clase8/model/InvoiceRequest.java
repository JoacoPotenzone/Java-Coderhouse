package com.coderhouse.Clase8.model;
import java.util.List;

public class InvoiceRequest {
    private int idCliente;
    private List<RequestProducto> listaProducto;

    public InvoiceRequest(int idCliente, List<RequestProducto> listaProducto) {
        this.idCliente = idCliente;
        this.listaProducto = listaProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<RequestProducto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<RequestProducto> listaProducto) {
        this.listaProducto = listaProducto;
    }
}
