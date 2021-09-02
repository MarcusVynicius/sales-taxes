package com.salestaxes.model;

public class Product {
	
	private Integer quantity;
	private String type;
	private String description; 
	private Double amount;
	private Double shelfAmount;
	private boolean imported;
	private Double percentualTax;
	private Double taxAmount;
	
	public Product() {
		
		this.type = "common";
		this.percentualTax = 0.0;
		this.amount = 0.00;
		this.shelfAmount = 0.0;
		this.taxAmount = 0.0;
		
	}
	
	public Product(Integer quantity,String description, Double amount, Boolean isImported) {
		
		this.quantity = quantity;
		this.type = "common";
		this.percentualTax = 0.0;
		this.amount = amount;
		this.shelfAmount = 0.0;
		this.taxAmount = 0.0;
		this.description = description;
		this.imported = isImported;
		
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public Double getPercentualTax() {
		return percentualTax;
	}

	public void setPercentualTax(Double percentualTax) {
		this.percentualTax = percentualTax;
	}

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Double getShelfAmount() {
		return shelfAmount;
	}

	public void setShelfAmount(Double shelfAmount) {
		this.shelfAmount = shelfAmount;
	}

	public void incrementTax(Double percentualTax) {
		
		this.percentualTax += percentualTax;
	}
	
	
}
