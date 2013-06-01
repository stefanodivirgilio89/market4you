package it.univaq.mwt.j2ee.market4you.business.model;

public class SectionKind {
	
	private Integer id;
	private String name;
	
	public SectionKind(String name) {
		this.name = name;
	}
	
	public SectionKind(Integer id, String name) {
		this(name);
		this.id=id;
	}
	
	public SectionKind(Integer id) {
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