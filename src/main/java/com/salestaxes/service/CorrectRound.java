package com.salestaxes.service;

import java.math.BigDecimal;
import java.math.MathContext;

import com.salestaxes.model.Sales;
;

public class CorrectRound {

	
	public void roundByFive(Sales sales) {

		
		sales.getProducts().forEach(product -> {
			
			product.setAmount(round(product.getAmount()));
					
		});
		
	}
	
	private Double round(Double value) {

		Double price = value;

		BigDecimal big = new BigDecimal(price % 0.10 * 100).round(new MathContext(1));
			
		int cents = big.intValue();

		if(cents < 5 ) {
			
			int forFive = 5 - cents;

			price = price * 100 + forFive;
			price = price / 100;
			return price;
		}
			
		return value;
		
	};
}
