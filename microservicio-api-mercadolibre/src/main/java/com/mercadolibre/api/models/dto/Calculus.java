package com.mercadolibre.api.models.dto;

import java.util.List;

public class Calculus {

	private List<String> items_ids;
	private Float amount;

	public List<String> getItems_ids() {
		return items_ids;
	}

	public void setItems_ids(List<String> items_ids) {
		this.items_ids = items_ids;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

}
