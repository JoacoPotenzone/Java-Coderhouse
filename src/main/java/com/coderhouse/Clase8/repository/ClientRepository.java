package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente, Integer> {
}
