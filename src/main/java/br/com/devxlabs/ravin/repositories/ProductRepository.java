package br.com.devxlabs.ravin.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.devxlabs.ravin.models.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	Optional<Product> findByName(String name);
	@Query("SELECT p from Product p where p.costPrice <= :constPrice And salePrice >= :salePrice")
	List<Product> findByCostPriceAndSalePrice(@Param("constPrice") double costPrice,@Param("salePrice") double salePrice);
	
	@Query("select p.name from Product p")
	List<String> findProductNames();
	
	@Query(value = "select name frim Product where productType = :tipoProduto AND createdDate = TODAY()", nativeQuery = true)
	List<String> findProductNamesByProductTypeInsertedToday(String tipoProduto);
}
