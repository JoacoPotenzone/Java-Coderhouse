package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Producto;
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
        return productRepository.save(product);
    }
    public List<Producto> getProductById(List<RequestProducto> productListId) throws Exception {
        List<Producto> productList = new ArrayList<>();
        for (RequestProducto requestProduct : productListId) {
            Optional<Producto> productFound = productRepository.findById(requestProduct.getIdProducto());
            if (productFound.isEmpty()) {
                throw new Exception("Product with id: " + requestProduct.getIdProducto() + " not found.");
            }
            productList.add(productFound.get());
        }
        return productList;
    }

    public Producto putProducto(int id, Producto product) {
        return product;
    }

    public Producto deleteProducto(int id) {
        return null;
    }
}
