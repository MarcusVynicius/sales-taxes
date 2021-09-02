package com.salestaxes.model;

import java.util.ArrayList;
import java.util.List;

public class Sales {

	private List<Product> products; 
	private Double totalValue;
	private Double totalTaxes;
	
	public Sales () {
		
		this.products = new ArrayList<Product>();
		this.totalTaxes = 0.0;
		this.totalValue = 0.0;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Double getTotalTaxes() {
		return totalTaxes;
	}

	public void setTotalTaxes(Double totalTaxes) {
		this.totalTaxes = totalTaxes;
	}
	
	public void incrementTotalTaxes(Double tax) {
		
		this.totalTaxes += tax;
		
	}
	public void incrementTotalAmount(Double amount) {
		
		this.totalValue += amount;
		
	}
	
}
