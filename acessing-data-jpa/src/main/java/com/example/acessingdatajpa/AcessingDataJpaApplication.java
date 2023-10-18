package com.example.acessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AcessingDataJpaApplication {

	// Criamos um logger na classe AcessingDataJpaApplication
	private static final Logger log = LoggerFactory.getLogger(AcessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AcessingDataJpaApplication.class, args);
	}

	@Bean // Uma classe que vai ser gerenciada pelo Spring
	public CommandLineRunner demo(CustomerRepository repository) {

		return (args) -> {
			log.info("Inserindo Clientes:");
			Customer c1 = new Customer("John", "Doe");
			repository.save(c1);
			repository.save(new Customer("Jack","Frost"));
			repository.save(new Customer("Alex","Trinner"));
			repository.save(new Customer("Fernand","Biteau"));

			log.info("Consultando Clientes:");
			var clientes = repository.findAll();
			for (var cliente : clientes) {
				log.info(cliente.toString());
			}

			// Buscando todos os clientes, para cada cliente mostrando log.info
			log.info("Buscando todos os clientes:");
			log.info("-------------------------------------");
			repository.findAll().forEach(Customer -> {
				log.info(Customer.toString());
			});
			log.info("");

			// Buscando clientes individuais por ID
			Customer customer = repository.findById(1L);
			log.info("Clientes encontrados com o ID (1L):");
			log.info("-------------------------------------");
			log.info(customer.toString());
			log.info("");

			// Buscando clientes pelo último nome
			log.info("CLientes encontrados pelo último nome (Frost):");
			log.info("-------------------------------------");
			repository.findByLastName("Frost").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}
}
