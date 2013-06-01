package it.univaq.mwt.j2ee.market4you.business.model;

public class SectionKind {
	
	private Byte id;
	private String name;
	
	public SectionKind(String name) {
		this.name = name;
	}
	
	public SectionKind(Byte id, String name) {
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
