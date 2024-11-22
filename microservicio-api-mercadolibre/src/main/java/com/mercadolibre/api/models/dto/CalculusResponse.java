package com.mercadolibre.api.models.dto;

import java.util.List;

public class CalculusResponse {

	private List<String> items_ids;
	private Float total;

	public List<String> getItems_ids() {
		return items_ids;
	}

	public void setItems_ids(List<String> items_ids) {
		this.items_ids = items_ids;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

}
