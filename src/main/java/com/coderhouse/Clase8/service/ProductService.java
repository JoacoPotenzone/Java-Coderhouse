package com.coderhouse.Clase8.service;

import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Producto postProduct(Producto product) throws Exception{
        return productRepository.save(product);
    }
}
