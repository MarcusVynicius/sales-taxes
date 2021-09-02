package com.salestaxes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.salestaxes.model.Product;

class ClassificationServiceTest {

	ClassificationService classificationService = new ClassificationService();
	
	@Test
	void ShouldDefineIfProductIsImported() {
		
		Product product = new Product();
		Product product2 = new Product();
		
		product.setDescription("book");
		
		product2.setDescription("imported box of chocolates");
		
		classificationService.validadeImported(product);
		classificationService.validadeImported(product2);
		
		assertEquals(product.isImported(), false);		
		assertEquals(product2.isImported(), true);		
		
	}
	
	@Test
	void ShouldReturnDescriptionOfProductCategory() {
		
		String descriptionReceived =  "bottle of perfume";
		String descriptionReceived2 =  "imported box of chocolates";
		String descriptionReceived3 =  "book";
		String descriptionReceived4 =  "packet of headache pills";
		String descriptionReceived5 =  "imported book";
		
		assertEquals(classificationService.returnDescription(descriptionReceived), "perfume");		
		assertEquals(classificationService.returnDescription(descriptionReceived2), "chocolates");		
		assertEquals(classificationService.returnDescription(descriptionReceived3), "book");		
		assertEquals(classificationService.returnDescription(descriptionReceived4), "pills");		
		assertEquals(classificationService.returnDescription(descriptionReceived5), "book");		
		
	}

}
