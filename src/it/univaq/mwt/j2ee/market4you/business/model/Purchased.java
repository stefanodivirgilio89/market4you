package it.univaq.mwt.j2ee.market4you.business.model;

import java.util.Date;

public class Purchased {
	
	private Integer id;
	private Product product;
	private User buyer;
	private Review review;
	private Date orderDate;
	private double price;
	private byte score;
	
	public Purchased(Product product, User buyer, Review review,
			Date orderDate, double price, byte score) {
		super();
		this.product = product;
		this.buyer = buyer;
		this.review = review;
		this.orderDate = orderDate;
		this.price = price;
		this.score = score;
	}

	public Purchased(Integer id, Product product, User buyer, Review review,
			Date orderDate, double price, byte score) {
		this(product, buyer, review, orderDate, price, score);
		this.id = id;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte getScore() {
		return score;
	}

	public void setScore(byte score) {
		this.score = score;
	}
	
	
	
	
	
	
	
	
	
	
}