package it.univaq.mwt.j2ee.market4you.business.model;


public class Role {
	
	private Integer id;
	private String name;
	
	public Role(String name) {
		this.name = name;
	}
	
	public Role(Integer id, String name) {
		this(name);
		this.id=id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
