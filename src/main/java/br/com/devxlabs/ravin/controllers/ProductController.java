package br.com.devxlabs.ravin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devxlabs.ravin.models.dtos.PersonDTO;
import br.com.devxlabs.ravin.models.dtos.ProductDTO;
import br.com.devxlabs.ravin.services.ProductService;
import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping
	public List<ProductDTO> listAll(){
		return service.listAll();
		}
	@GetMapping(value= "/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		ProductDTO product = service.findById(id);
		if(product==null) {
			return   ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
		
	}/*
	public PersonDTO findById(@PathVariable Long id){
		
	}*/
	@DeleteMapping(value= "/{id}")
	public void deleteByID(@PathVariable Long id) {
		service.deleteById(id);
	}
	@GetMapping(value = "/search")
	public List<ProductDTO> search(
			@RequestParam(value ="name") String name,
			@RequestParam(value ="productType")String productType,
			@RequestParam(value ="minSalePrice") double minSalePrice,
			@RequestParam(value ="maxSalePrice")double maxSalePrice,
			@RequestParam(value ="page",defaultValue = "0",required = false)Integer page,
			@RequestParam(value ="orderBy",defaultValue= "id"  ,required = false)String orderBy,
			@RequestParam(value ="itensPerPage",defaultValue= "10",required= false)Integer itensPerPage,
			@RequestParam(value ="direction",defaultValue= "ASC",required = false)String direction
			){
		
		return service.search(name, productType, minSalePrice, maxSalePrice,page,orderBy, itensPerPage, direction);
	}
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody ProductDTO productDTO) {
		try {
			return ResponseEntity.ok(service.create(productDTO));
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
	}
	@PutMapping(value = "/{id}")
	public void update(@RequestBody ProductDTO product, @PathVariable Integer id) {
		System.out.println(product);
	}
	
	
}
