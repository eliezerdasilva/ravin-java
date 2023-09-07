package br.com.decxlabs.ravin.services;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.devxlabs.ravin.enums.ProductType;
import br.com.devxlabs.ravin.models.dtos.ProductDTO;
import br.com.devxlabs.ravin.models.entities.Product;
import br.com.devxlabs.ravin.repositories.ProductRepository;
import br.com.devxlabs.ravin.services.ProductService;

public class ProductServiceTest {


	@Mock
	ProductRepository productRepository;
	@Mock
	ModelMapper mapper;
	
	@InjectMocks
	ProductService productService;
	
	public void save_ShouldSave() {
		
		
	}
	public ProductDTO createProductDTO()
	{
		ProductDTO productDTO = new ProductDTO(1l,"Hamburguer","Veggie","8451ce",19.5,20.5, "10 Minutos","",ProductType.SNACK,true);
	
		return productDTO;
	}
	public Product createProduct() {
		//Product product = new Product(1l,"Hamburguer","Veggie","8451ce",19.5,20.5, "10 Minutos","",ProductType.SNACK,true, new Date(),"", new Date,"");
		//return product;
		return null;
		
		
	}
}
