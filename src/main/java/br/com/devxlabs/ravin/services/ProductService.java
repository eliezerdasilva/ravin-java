package br.com.devxlabs.ravin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static br.com.devxlabs.ravin.consts.ExceptionConsts.*;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.devxlabs.ravin.consts.ExceptionConsts;
import br.com.devxlabs.ravin.models.dtos.ProductDTO;
import br.com.devxlabs.ravin.models.entities.Product;
import br.com.devxlabs.ravin.repositories.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ModelMapper mapper;
	
	public List<ProductDTO> listAll(){
		//Duas maneiras de converter uma classe em outra
		List<ProductDTO> productsDTO =  productRepository.findAll()
				.stream()
				.map(product -> mapper.map(product, ProductDTO.class)).toList();
		
		/*
		  List<Product> products =  productRepository.findAll();
		List<ProductDTO> productsDTO = new ArrayList<>();
		
		for (Product product : products) {
			ProductDTO productDto = mapper.map(product,ProductDTO.class);
			productsDTO.add(productDto);
		}*/
		return productsDTO;		
	}
	/*
	public ProductDTO findById(Long id ) {
		if(id==1) {
			return new ProductDTO();
		}
		return null;
		
	}*/
	
	
	public ProductDTO findById(Long id ) {
		Optional<Product> optional = productRepository.findById(id);
		Product product= null;
		ProductDTO productDTO = null;
		
		
		if(optional.isPresent()) {
			product = optional.get();
			productDTO = mapper.map(product, ProductDTO.class);
		}
		
		return productDTO;
	}
	public void deleteById(Long id) {
	productRepository.deleteById(id);
	}
	public List<ProductDTO> search(String name, String productType, double minSalePrice, double maxSalePrice
			,Integer page
			,String orderBy
			,Integer itensPerPage
			,String direction){
		Pageable pageable = PageRequest.of(page,itensPerPage, Direction.fromString(direction));
		Page<Product>products = productRepository.findAll(pageable);
		return null;
		
	}
	
	public Long create(ProductDTO productDTO)throws Exception {
		return save(productDTO);
		
	}
	public Long update(ProductDTO productDTO) throws Exception {
		return save(productDTO);
	}
	private Long save(ProductDTO productDTO) throws Exception {
		if(productDTO.getCostPrice()>productDTO.getSalePrice()) {
			throw new Exception(PRODUCT_COST_PRICE_GRATHER_THEN_SALE_PRICE);
		}
		try {
			
			Product product = mapper.map(productDTO, Product.class);
			Product created =  productRepository.save(product);
			return created.getId();
		}catch (Exception e) {
			throw new Exception(ExceptionConsts.PRODUCT_INSERT_ERROR);
		}
	}

}
