package com.salestaxes.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.salestaxes.entity.SalesDTO;
import com.salestaxes.model.Product;

class SalesControllerTest {
	
	@MockBean
	SalesController controller = new SalesController();
	
	@Test
	void ShouldReturnReceiptInput1() {
		
		List<Product> products = new ArrayList<Product>();
		products.add(newProduct(1,"book", 12.49, false));
		products.add(newProduct(1,"music CD", 14.99, false));
		products.add(newProduct(1,"chocolate bar", 0.85 , false));
		
		
		assertEquals(controller.calculateTax(createSales(products)), "1 book: 12,49\n1 music CD: 16,49\n1 chocolate bar: 0,85\nSales Taxes: 1,5\nTotal: 29,83\n");		
		
	}
	
	private SalesDTO createSales(List<Product> product) {
		
		SalesDTO sales = new SalesDTO();
		
		sales.getProducts().addAll(product);
		
		return sales;
	}
	
	private Product newProduct(Integer quantity,String description,Double amount, Boolean isImported) {
		
		return new Product(quantity,description,amount,isImported);
		
	}
	
	
}
