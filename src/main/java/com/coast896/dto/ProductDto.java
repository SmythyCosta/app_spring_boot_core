package com.coast896.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ProductDto {
	
	private long id;
	
	@NotEmpty(message = "Name can not be empty.")
	@Length(min = 3, max = 200, message = "Name must contain between 3 and 200 characters.")
	private String name;
	
	@NotNull(message="If the product is active you must be informed.")
	private Boolean active;
	
	@NotNull(message="Cost can not be empty.")
	private BigDecimal cost;

	@NotNull(message="Stock can not be empty.")
	private int stock;
	
	private Date dateCreated;
	
	
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public BigDecimal getCost() {
		return cost;
	}


	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", name=" + name + ", active=" + active + ", cost=" + cost + ", stock=" + stock
				+ ", dateCreated=" + dateCreated + "]";
	}
	


}
