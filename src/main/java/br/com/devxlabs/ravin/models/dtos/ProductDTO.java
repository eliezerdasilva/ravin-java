package br.com.devxlabs.ravin.models.dtos;

import java.io.Serial;
import java.io.Serializable;

import br.com.devxlabs.ravin.enums.ProductType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductDTO implements Serializable {

	@Serial
	private static final long serialVersionUID = 42L;
	
	public static final String MIN_COST_PRICE = "0.0";
	public static final String MIN_SAlE_PRICE = "0.0";
	
	private Long id;
	@NotBlank(message = "O campo nome não pode estar em branco.")
	@NotEmpty(message = "O campo nome não pode estar vazio.")
	private String name;
	@NotBlank(message = "O campo descrição não pode estar em branco.")
	@NotEmpty(message = "O campo descrição não pode estar vazio.")
	private String description;
	@NotBlank(message = "O campo código não pode estar em branco.")
	@NotEmpty(message = "O campo código não pode estar vazio.")
	private String code;
	@DecimalMin(value = MIN_COST_PRICE, message = "O preço de custo não pode ser negativo.")
	private double costPrice;
	@DecimalMin(value = MIN_SAlE_PRICE, message = "O preço de venda não pode ser negativo.")
	private double salePrice;
	@NotBlank(message = "O campo tempo de preparo não pode estar em branco.")
	@NotEmpty(message = "O campo tempo de preparo não pode estar vazio.")
	private String preparationTime;
	
	private ProductType productType;
	private String comments;
	private boolean hasActive = true;

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(Long id,String name, String description, String code, double costPrice, double salePrice,
			String preparationTime, String comments, ProductType productType, boolean hasActive) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.code = code;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		this.preparationTime = preparationTime;
		this.comments = comments;
		this.productType = productType;
		this.hasActive = hasActive;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public boolean isHasActive() {
		return hasActive;
	}

	public void setHasActive(boolean hasActive) {
		this.hasActive = hasActive;
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", description=" + description + ", code=" + code + ", costPrice="
				+ costPrice + ", salePrice=" + salePrice + ", preparationTime=" + preparationTime + ", comments="
				+ comments + ", productType=" + productType + ", hasActive=" + hasActive + "]";
	}
}