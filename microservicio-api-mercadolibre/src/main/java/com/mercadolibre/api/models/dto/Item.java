package com.mercadolibre.api.models.dto;

public class Item {

	private String id;
	private String title;
	private Float price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", price=" + price + "]";
	}

}
