package it.univaq.mwt.j2ee.market4you.business.model;

import java.util.Date;

public class Product {
	
	private Integer id;
	private Shop shop;
	private Category category;
	private String name;
	private double price;
	private String description;
	private boolean sold;
	private Date publishedOn;
	private Date updatedOn;
	private int visitedCount;
	private String imageURI;
	
	public Product(Shop shop, Category category, String name, double price,
			String description, boolean sold, Date publishedOn, Date updatedOn,
			int visitedCount, String imageURI) {
		super();
		this.shop = shop;
		this.category = category;
		this.name = name;
		this.price = price;
		this.description = description;
		this.sold = sold;
		this.publishedOn = publishedOn;
		this.updatedOn = updatedOn;
		this.visitedCount = visitedCount;
		this.imageURI = imageURI;
	}

	public Product(Integer id, Shop shop, Category category, String name,
			double price, String description, boolean sold, Date publishedOn,
			Date updatedOn, int visitedCount, String imageURI) {
		this(shop, category, name, price, description, sold, publishedOn, updatedOn, visitedCount, imageURI);
		this.id = id;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getVisitedCount() {
		return visitedCount;
	}

	public void setVisitedCount(int visitedCount) {
		this.visitedCount = visitedCount;
	}

	public String getImageURI() {
		return imageURI;
	}

	public void setImageURI(String imageURI) {
		this.imageURI = imageURI;
	}
	
	
	
}
