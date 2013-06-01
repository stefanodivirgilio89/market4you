package it.univaq.mwt.j2ee.market4you.business.model;

import java.util.Date;

public class Review {

	private Integer id;
	private String body;
	private Date dateAdded;
	
	public Review(String body, Date dateAdded) {
		super();
		this.body = body;
		this.dateAdded = dateAdded;
	}

	public Review(Integer id, String body, Date dateAdded) {
        this(body, dateAdded);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
	
	
	
	
	
}
