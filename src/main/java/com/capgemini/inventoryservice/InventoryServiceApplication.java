package com.capgemini.inventoryservice;

import com.capgemini.inventoryservice.entities.Product;
import com.capgemini.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		return args -> {
            productRepository.save(new Product(null,"laptop",100,10));
			productRepository.save(new Product(null,"phone",50,15));
			productRepository.save(new Product(null,"printer",70,9));
			productRepository.findAll().forEach(p->{
				System.out.println(p.getName());
			});
		};
	}
}
