package com.salestaxes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.salestaxes.model.Product;
import com.salestaxes.model.Sales;

class TaxesServiceTest {

	TaxesService taxesService = new TaxesService();
	
	@Test
	void ShouldReturnThePercentualOfTaxes() {
		
		Sales sales = new Sales();
		Product product = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		
		product.setDescription("book");
		product.setType("book");
		
		product2.setDescription("imported box of chocolates");
		product2.setType("food");
		product2.setImported(true);
		
		product3.setDescription("imported bottle of perfume");
		product3.setType("common");
		product3.setImported(true);
		
		sales.getProducts().add(product);
		sales.getProducts().add(product2);
		sales.getProducts().add(product3);
		
		taxesService.calculatePercentualTaxes(sales);
		
		assertThat(product.getPercentualTax()).isNotNull();
		assertThat(product2.getPercentualTax()).isNotNull();
		assertThat(product3.getPercentualTax()).isNotNull();
		
		assertEquals(product.getPercentualTax(), 0.0);		
		assertEquals(product2.getPercentualTax(), 0.05);		
		assertEquals(product3.getPercentualTax(), 0.05 + 0.1);		
		
	}

	@Test
	void ShouldReturnTheCalculationOfTaxes() {
		
		Sales sales = new Sales();
		Product product = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		Product product4 = new Product();
		
		product.setAmount(10.00);
		product.setPercentualTax(0.0);
		
		product2.setAmount(10.00);
		product2.setPercentualTax(0.1);
		
		product3.setAmount(10.00);
		product3.setPercentualTax(0.05);
		
		product4.setAmount(10.00);
		product4.setPercentualTax(0.15);
		
		sales.getProducts().add(product);
		sales.getProducts().add(product2);
		sales.getProducts().add(product3);
		sales.getProducts().add(product4);
		
		taxesService.calculateTaxAmount(sales);
		
		assertThat(product.getTaxAmount()).isNotNull();
		assertThat(product2.getTaxAmount()).isNotNull();
		assertThat(product3.getTaxAmount()).isNotNull();
		assertThat(product4.getTaxAmount()).isNotNull();
		
		assertEquals(product.getTaxAmount(), product.getAmount()*product.getPercentualTax());		
		assertEquals(product2.getTaxAmount(), product2.getAmount()*product2.getPercentualTax());		
		assertEquals(product3.getTaxAmount(), product3.getAmount()*product3.getPercentualTax());		
		assertEquals(product4.getTaxAmount(), product4.getAmount()*product4.getPercentualTax());		
		
	}
	
	@Test
	void ShouldReturnTheCalculationOfTotalTaxes() {
		
		Sales sales = new Sales();
		Product product = new Product();
		Product product2 = new Product();
		
		product.setAmount(11.50);
		product.setShelfAmount(10.00);
		
		product2.setAmount(11.00);
		product2.setShelfAmount(10.00);
		
		sales.getProducts().add(product);
		sales.getProducts().add(product2);
		
		taxesService.calculateTotalTaxAmount(sales);
		
		assertThat(sales.getTotalTaxes()).isNotNull();
		
		assertEquals(sales.getTotalTaxes(), 2.50);		
		
	}
	
	@Test
	void ShouldReturnTheCalculationOfProductsAmount() {
		
		Sales sales = new Sales();
		Product product = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		
		product.setAmount(10.00);
		product.setShelfAmount(10.00);
		product.setDescription("book");
		product.setType("book");
		
		product2.setAmount(10.00);
		product2.setShelfAmount(10.00);
		product2.setDescription("imported box of chocolates");
		product2.setType("food");
		
		product3.setAmount(10.00);
		product3.setShelfAmount(10.00);
		product3.setDescription("imported bottle of perfume");
		product3.setType("common");
		
		sales.getProducts().add(product);
		sales.getProducts().add(product2);
		sales.getProducts().add(product3);
		
		taxesService.calculateProductAmount(sales);
		
		assertEquals(product.getAmount(), product.getShelfAmount() + product.getTaxAmount());		
		assertEquals(product2.getAmount(), product2.getShelfAmount() + product2.getTaxAmount());		
		assertEquals(product3.getAmount(), product3.getShelfAmount() + product3.getTaxAmount());		
		
	}

	
}
