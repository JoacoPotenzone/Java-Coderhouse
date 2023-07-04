package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.model.ProductoDetails;
import com.coderhouse.Clase8.model.RequestProducto;
import com.coderhouse.Clase8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Producto postProduct(Producto product) throws Exception{
        try {
            product.productoValidado(product.getTitulo(), product.getDescripcion(), product.getStock(), product.getPrecio(),
                    product.getCodigo());
        } catch (IllegalArgumentException e) {
            throw new Exception("Error guardando el producto: " + e.getMessage());
        }
        return productRepository.save(product);
    }

    public Producto getProduct(int id) throws Exception {
        Optional<Producto> producto = productRepository.findById(id);
        if (producto.isEmpty()) {
            return null;
        } else {
            return producto.get();
        }
    }
    public List<Producto> getProductById(List<ProductoDetails> productListId) throws Exception {
        List<Producto> productList = new ArrayList<>();
        for (ProductoDetails requestProduct : productListId) {
            Optional<Producto> productFound = productRepository.findById(requestProduct.getProductId());
            if (productFound.isEmpty()) {
                throw new Exception("Producto con id: " + requestProduct.getProductId() + " No encontrado.");
            }
            productList.add(productFound.get());
        }
        return productList;
    }

    public Producto guardarProducto(Producto product) {
        return productRepository.save(product);
    }

    public List<Producto> getTodoProductos() throws Exception {
        List<Producto> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            throw new Exception("Ningún producto encontrado.");
        }
        return productList;
    }

    public Producto putProducto(int id, Producto product) throws Exception {
            Producto existingProduct = getProduct(id);
            if (existingProduct == null) {
                throw new Exception("Producto con id: " + id + ", no encontrado");
            }
            if (product.getTitulo() != null && !product.getTitulo().isEmpty()) {
                existingProduct.setTitulo(product.getTitulo());
            }
            if (product.getDescripcion() != null && !product.getDescripcion().isEmpty()) {
                existingProduct.setDescripcion(product.getDescripcion());
            }
            if (product.getStock() != null) {
                existingProduct.setStock(product.getStock());
            }
            if (product.getPrecio() != null) {
                existingProduct.setPrecio(product.getPrecio());
            }
            if (product.getCodigo() != null && !product.getCodigo().isEmpty()) {
                existingProduct.setCodigo(product.getCodigo());
            }
            try {
                existingProduct.productoValidado(existingProduct.getTitulo(), existingProduct.getDescripcion(),
                        existingProduct.getStock(), existingProduct.getPrecio(),
                        existingProduct.getCodigo());
            } catch (IllegalArgumentException e) {
                throw new Exception("Error actualizando el producto: " + e.getMessage());
            }
            return productRepository.save(existingProduct);
        }
    public Producto deleteProduct(int id) throws Exception {
        Producto product = getProduct(id);
        if (product == null) {
            throw new Exception("Producto con id: " + id + ", no encontrado");
        }
        productRepository.deleteById(id);
        return product;
}
}
