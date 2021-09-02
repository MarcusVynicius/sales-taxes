package com.salestaxes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.salestaxes.entity.SalesDTO;
import com.salestaxes.model.Product;
import com.salestaxes.model.Sales;

class SalesServiceTest {

	SalesService salesService = new SalesService();
			
	@Test
	void ShouldReturnProductTypeWhenRecieveProductDescription() {
		
		Product product = new Product();
		
		product.setDescription("imported box of chocolates");
		
		salesService.setType(product);
		
		assertThat(product.getType()).isNotEmpty();
		assertEquals(product.getType(), "food");		
		
	}

	@Test
	void ShouldReturnCalculationOfTotalAmountFromProducts() {
		
		Sales sales = new Sales();
		Product product = new Product();
		Product product2 = new Product();
		
		product.setAmount(10.00);
		product2.setAmount(10.00);
		
		sales.getProducts().add(product);
		sales.getProducts().add(product2);
		
		salesService.calculateTotalAmount(sales);
		
		assertThat(sales.getTotalValue()).isNotNull();
		assertEquals(sales.getTotalValue(), 20.00);		
		
	}
			
	@Test
	void ShouldReturnCalculationOfReceipt() {
		
		SalesDTO sales = new SalesDTO();	
		Product product = new Product();
		
		product.setQuantity(1);
		product.setAmount(27.99);
		product.setDescription("imported bottle of perfume");
		
		sales.getProducts().add(product);
		
		assertEquals(salesService.calculateReceipt(sales), "1 imported bottle of perfume: 32,19\nSales Taxes: 4,2\nTotal: 32,19\n");		
	
	}
	
	@Test
	void ShouldReturnDataOfReceipt() {
		
		SalesDTO sales = new SalesDTO();
		
		Product product = new Product();
		
		product.setQuantity(1);
		product.setAmount(11.00);
		product.setDescription("imported bottle of perfume");
		sales.setTotalTaxes(1.00);
		sales.setTotalValue(11.00);
		
		sales.getProducts().add(product);
		
		assertEquals(salesService.getReceipt(sales),"1 imported bottle of perfume: 11\nSales Taxes: 1\nTotal: 11\n");
	
	}
	
	@Test
	void ShouldCalculateRoundNearestFive() {
		
		SalesDTO sales = new SalesDTO();	
		Product product = new Product();
		
		product.setQuantity(1);
		product.setAmount(11.25);
		product.setDescription("imported bottle of perfume");
		
		sales.getProducts().add(product);
		
		assertEquals(salesService.calculateReceipt(sales), "1 imported bottle of perfume: 12,95\nSales Taxes: 1,7\nTotal: 12,95\n");		
	
	}
	
}
