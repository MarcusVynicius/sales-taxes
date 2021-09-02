package com.salestaxes.service;

import com.salestaxes.model.Sales;

public class TaxesService {

	ClassificationService classification;

	public TaxesService() {

		this.classification = new ClassificationService();

	}

	public void calculateProductAmount(Sales sales) {

		sales.getProducts().forEach(product -> {

			classification.validadeImported(product);

		});

		calculatePercentualTaxes(sales);
		calculateTaxAmount(sales);

		sales.getProducts().forEach(product -> {

			product.setAmount(product.getAmount() + product.getTaxAmount());

		});

	}

	 void calculatePercentualTaxes(Sales sales) {

		sales.getProducts().forEach(product -> {

			if (product.getType().equals("common")) {

				product.incrementTax(0.1);

			}

			if (product.isImported()) {

				product.incrementTax(0.05);

			}
		});
	}

	 void calculateTaxAmount(Sales sales) {

		sales.getProducts().forEach(product -> {

			product.setTaxAmount(product.getAmount() * product.getPercentualTax());

		});

	}

	 void calculateTotalTaxAmount(Sales sales) {

		sales.getProducts().forEach(product -> {

			sales.incrementTotalTaxes(product.getAmount() - product.getShelfAmount());

		});

	}

}
