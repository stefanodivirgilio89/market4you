package it.univaq.mwt.j2ee.market4you.business.model;

public class Shop {
	
	private Integer id;
	private User user;
	private String name;
	private String country;
	private String address;
	private String postcode;
	private String telephone;
	private String city;
	private byte rating;
	
	public Shop(User user, String name, String country, String address,
			String postcode, String telephone, String city, byte rating) {
		super();
		this.user = user;
		this.name = name;
		this.country = country;
		this.address = address;
		this.postcode = postcode;
		this.telephone = telephone;
		this.city = city;
		this.rating = rating;
	}

	public Shop(Integer id) {
		this.id=id;
	}
	public Shop(Integer id, User user, String name, String country,
			String address, String postcode, String telephone, String city,
			byte rating) {
		this(user, name, country, address, postcode, telephone, city, rating);
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	
	
	
	
	
	
	
	
	
	

}
