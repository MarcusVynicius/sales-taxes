package com.salestaxes.service;


import java.text.DecimalFormat;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.salestaxes.data.ClassificationMap;
import com.salestaxes.entity.SalesDTO;
import com.salestaxes.model.Product;
import com.salestaxes.model.Sales;


@Service
public class SalesService {

	ClassificationService classification;
	TaxesService taxes;
	ModelMapper model;
	CorrectRound correctRound;
	
	public SalesService() {
		this.classification = new ClassificationService();
		this.taxes = new TaxesService();
		this.model = new ModelMapper();
		this.correctRound = new CorrectRound();
	}
	 
	
	public String calculateReceipt (SalesDTO salesDTO) {
		
		
		Sales sales = model.map(salesDTO, Sales.class);
		
		sales.getProducts().forEach(product -> setType(product));
		
		setShelfAmount(sales);
		
		taxes.calculateProductAmount(sales);
		
		correctRound.roundByFive(sales);
		
		taxes.calculateTotalTaxAmount(sales);
		
		calculateTotalAmount(sales);
	
		return getReceipt(model.map(sales,SalesDTO.class));
		
	}
	
	 void setType (Product product) {
	
		String type = ClassificationMap.getInstance().getMap().get(classification.returnDescription(product.getDescription())) == null ? product.getType() : 
			ClassificationMap.getInstance().getMap().get(classification.returnDescription(product.getDescription()));
				
		product.setType(type);
	
	}
	
	 void calculateTotalAmount(Sales sales) {
		
		sales.getProducts().forEach(product -> {
			
			sales.incrementTotalAmount(product.getAmount());
				
		});
	}
	
	  String getReceipt(SalesDTO sales) {
		
		StringBuilder receipt = new StringBuilder();
		DecimalFormat decimalFormat = new DecimalFormat("0.##");
		
		sales.getProducts().forEach(product -> {
			
			receipt.append(product.getQuantity()+" "+product.getDescription()+": "+decimalFormat.format((product.getAmount()))+"\n");  
		});
		
		receipt.append("Sales Taxes: " +decimalFormat.format(sales.getTotalTaxes())+"\n");
		
		receipt.append("Total: " +decimalFormat.format(sales.getTotalValue())+"\n");
		
		return receipt.toString();
	}
	
	private void setShelfAmount(Sales sales) {
		
		sales.getProducts().forEach(product -> {
			
			Double amount = product.getAmount();
			product.setShelfAmount(amount);
			
		});
		
	}
	
	
	
}
