package com.salestaxes.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salestaxes.entity.SalesDTO;
import com.salestaxes.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {
	
	SalesService salesService;
	
	public SalesController() {
		
		this.salesService = new SalesService();
		
	}
	
	
	@PostMapping(consumes = "application/json")
    public String calculateTax(@Valid @RequestBody SalesDTO body){

		String receipt = salesService.calculateReceipt(body);

        return receipt;
    }
}
