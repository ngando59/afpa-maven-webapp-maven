package fr.ngando.product.domain;

import fr.ngando.commons.decimalformatprintable.DecimalFormatPrintable;

public class Product implements DecimalFormatPrintable {
	private int id;
	private String title;
	private String thumbnail;
	private String description;
	private Double price;
	private int public_id;
	private int category_id;
	
	public Product(String title, String thumbnail, String description, Double price, int public_id, int category_id) {
		super();
		this.title = title;
		this.thumbnail = thumbnail;
		this.description = description;
		this.price = price;
		this.public_id = public_id;
		this.category_id = category_id;
	}	
	
	public Product(int id, String title, String thumbnail, String description, Double price, int public_id, int category_id) {
		super();
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.description = description;
		this.price = price;
		this.public_id = public_id;
		this.category_id = category_id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPublic_id() {
		return public_id;
	}

	public void setPublic_id(int public_id) {
		this.public_id = public_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}	
		
}