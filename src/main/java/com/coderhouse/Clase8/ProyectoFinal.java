package com.coderhouse.Clase8;

import com.coderhouse.Clase8.repository.ClientRepository;
import com.coderhouse.Clase8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFinal implements CommandLineRunner {

	@Autowired
	private ProductRepository productoRepository;

	@Autowired
	private ClientRepository clienteRepository;


	public static void main(String[] args) { SpringApplication.run(ProyectoFinal.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");

	}

}