package com.salestaxes.entity;

import java.util.ArrayList;
import java.util.List;


import com.salestaxes.model.Product;

public class SalesDTO {

	private List<Product> products; 
	private Double totalValue;
	private Double totalTaxes;
	
	public SalesDTO () {
		
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
	
	
	
}
