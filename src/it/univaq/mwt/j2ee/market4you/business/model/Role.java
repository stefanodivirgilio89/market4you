package it.univaq.mwt.j2ee.market4you.business.model;


public class Role {
	
	private Byte id;
	private String name;
	
	public Role(String name) {
		this.name = name;
	}
	
	public Role(Byte id, String name) {
		this(name);
		this.id=id;
	}
	
	public Byte getId() {
		return id;
	}
	
	public void setId(Byte id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
