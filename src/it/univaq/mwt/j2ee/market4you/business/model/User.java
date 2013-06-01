package it.univaq.mwt.j2ee.market4you.business.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	
	private String username;
	private String password;
	private Token token;
	private String name;
	private String surname;
	private String country;
	private String state;
	private String street;
	private String postcode;
	private String telephone;
	private String city;
	private String email;
	private String sex;
	private Date birthday;
	private String personalNumber;
	private Set<Role> roles=new HashSet<Role>();
	private Set<Product> whishList=new HashSet<Product>();
	
	public User(String password, Token token, String name, String surname,
			String country, String state, String street, String postcode,
			String telephone, String city, String email, String sex,
			Date birthday, String personalNumber, Set<Role> roles,
			Set<Product> whishList) {
		super();
		this.password = password;
		this.token = token;
		this.name = name;
		this.surname = surname;
		this.country = country;
		this.state = state;
		this.street = street;
		this.postcode = postcode;
		this.telephone = telephone;
		this.city = city;
		this.email = email;
		this.sex = sex;
		this.birthday = birthday;
		this.personalNumber = personalNumber;
		this.roles = roles;
		this.whishList = whishList;
	}
	
	public User(String username, String password, Token token, String name,
			String surname, String country, String state, String street,
			String postcode, String telephone, String city, String email,
			String sex, Date birthday, String personalNumber, Set<Role> roles,
			Set<Product> whishList) {
		this(password, token, name, surname, country, state, street, postcode, telephone, city, email, sex, birthday, personalNumber, roles, whishList);
		this.username = username;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Product> getWhishList() {
		return whishList;
	}

	public void setWhishList(Set<Product> whishList) {
		this.whishList = whishList;
	}
	
	
	
	
	
	

}
