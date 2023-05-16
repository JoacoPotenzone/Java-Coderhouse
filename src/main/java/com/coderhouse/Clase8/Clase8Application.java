package com.coderhouse.Clase8;

import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.model.Producto;
import com.coderhouse.Clase8.repository.ClientRepository;
import com.coderhouse.Clase8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Clase8Application implements CommandLineRunner {

	@Autowired
	private ProductRepository productoRepository;

	@Autowired
	private ClientRepository clienteRepository;


	public static void main(String[] args) { SpringApplication.run(Clase8Application.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");
		// Creación de Productos para después imprimirlos.

            /*Producto termo = new Producto();
			termo.setCode("bjhdhshasdb");
			termo.setDescription("Termo negro Stanley");
			termo.setPrice(40000);
			termo.setStock(20);
			this.productoRepository.save(termo);*/
		Optional<Producto> productoGuardado1 = this.productoRepository.findById(1);

            /*Producto auricularesStromberg = new Producto();
			auricularesStromberg.setCode("bAUSHashA");
			auricularesStromberg.setDescription("The sound of people.");
			auricularesStromberg.setPrice(7999);
			auricularesStromberg.setStock(50);
			this.productoRepository.save(auricularesStromberg);*/
		Optional<Producto> productoGuardado2 = this.productoRepository.findById(2);

		if (productoGuardado1.isPresent()) System.out.println(productoGuardado1.get());
		if (productoGuardado2.isPresent())System.out.println(productoGuardado2.get());

		// Creación de Clientes para después imprimirlos.

		/*Cliente cliente1 = new Cliente();
		cliente1.setName("Skrillex");
		cliente1.setLastname("Rodriguez");
		cliente1.setDocnumber(Integer.parseInt("99334005"));
		this.clienteRepository.save(cliente1);*/
		Optional<Cliente> clienteGuardado1 = this.clienteRepository.findById(1);

		/*Cliente cliente2 = new Cliente();
		cliente2.setName("Atahualpa");
		cliente2.setLastname("Yupanqui");
		cliente2.setDocnumber(Integer.parseInt("12312347"));
		this.clienteRepository.save(cliente2);*/
		Optional<Cliente> clienteGuardado2 = this.clienteRepository.findById(2);

		if (clienteGuardado1.isPresent()) System.out.println(clienteGuardado1.get());
		if (clienteGuardado2.isPresent()) System.out.println(clienteGuardado2.get());


	}


}