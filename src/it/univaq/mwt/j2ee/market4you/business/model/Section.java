package it.univaq.mwt.j2ee.market4you.business.model;

public class Section {

	private Integer id;
	private String title;
	private String body;
	private Shop shop;
	private SectionKind sectionKind;
	
	public Section(String title, String body, Shop shop,
			SectionKind sectionKind) {
		this.title = title;
		this.body = body;
		this.shop = shop;
		this.sectionKind = sectionKind;
	}

	public Section(Integer id, String title, String body, Shop shop,
			SectionKind sectionKind) {
		this(title, body, shop, sectionKind);
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public SectionKind getSectionKind() {
		return sectionKind;
	}

	public void setSectionKind(SectionKind sectionKind) {
		this.sectionKind = sectionKind;
	}

	
	
	
	
	
	
	
	
}