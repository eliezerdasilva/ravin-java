package br.com.devxlabs.ravin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.devxlabs.ravin.enums.ProductType;
import br.com.devxlabs.ravin.models.dtos.ProductDTO;

@SpringBootApplication
public class RavinApplication {

	public static void main(String[] args) {
		SpringApplication.run(RavinApplication.class, args);
	
	}

}
