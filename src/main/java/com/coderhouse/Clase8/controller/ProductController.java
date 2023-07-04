package com.coderhouse.Clase8.controller;


import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Object> postProduct(@RequestBody Producto product){
        try{
            System.out.println(product);
            Producto productSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Producto guardado exitosamente",
                    HttpStatus.OK,
                    productSaved
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProduct (@PathVariable int id){
        try{
            System.out.println("Product ID: " + id);
            Producto productFound = productService.getProduct(id);
            System.out.println("PRODUCT FOUND");
            System.out.println(productFound);
            return ResponseHandler.generateResponse(
                    "El producto fue obtenido exitosamente",
                    HttpStatus.OK,
                    productFound
            );
        } catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping
    public ResponseEntity<Object> getTodoProductos() {
        try {
            return ResponseHandler.generateResponse(
                    "Todos los productos obtenidos exitosamente",
                    HttpStatus.OK,
                    productService.getTodoProductos());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<Object> putProduct(@PathVariable() int id, @RequestBody Producto product) {
        try {
            System.out.println(id);
            Producto productUpdated = productService.putProducto(id, product);
            return ResponseHandler.generateResponse(
                    "Producto actualizado exitosamente",
                    HttpStatus.OK,
                    productUpdated);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable() int id) {
        try {
            System.out.println(id);
            Producto productDeleted = productService.deleteProduct(id);
            return ResponseHandler.generateResponse(
                    "Producto borrado exitosamente.",
                    HttpStatus.OK,
                    productDeleted);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }
    }
}
