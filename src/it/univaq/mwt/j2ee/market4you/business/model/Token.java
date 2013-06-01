package it.univaq.mwt.j2ee.market4you.business.model;

import java.util.Date;

public class Token {
	
	private Integer id;
	private int number;
	private Date expire;
	
	public Token(int number, Date expire) {
		super();
		this.number = number;
		this.expire = expire;
	}

	public Token(Integer id, int number, Date expire) {
		this(number, expire);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}
	
	

	
	
	
	
	

}
