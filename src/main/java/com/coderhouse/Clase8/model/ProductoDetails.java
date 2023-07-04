package com.coderhouse.Clase8.model;

public class ProductoDetails {
    private int productId;

    private int cantidad;

    private RequestProducto requestProducto;

    public ProductoDetails(int productId, int cantidad) {
        this.productId = productId;
        this.cantidad = cantidad;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public RequestProducto getRequestProducto() {
        return requestProducto;
    }

    public void setRequestProducto(RequestProducto requestProducto) {
        this.requestProducto = requestProducto;
    }
}
