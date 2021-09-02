package com.salestaxes.service;

import com.salestaxes.model.Product;

public class ClassificationService {

	public String returnDescription(String description) {

		String[] input = description.split(" ");

		if (description.toLowerCase().contains("of") && description.toLowerCase().contains("imported")) {

			return input[3];

		} else if (description.toLowerCase().contains("of") && !description.toLowerCase().contains("pills")) {

			return input[2];

		} else if (description.toLowerCase().contains("imported")) {

			return input[1];

		} else if (description.toLowerCase().contains("pills")) {

			return input[input.length-1];

		} else {

			return input[0];
		}

	}

	public void validadeImported(Product product) {
		
		if (product.getDescription().toLowerCase().contains("imported")) {

			product.setImported(true);;

		}
		
	}
}
