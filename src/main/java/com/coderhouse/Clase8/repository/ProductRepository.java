package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Producto, Integer> {
}
