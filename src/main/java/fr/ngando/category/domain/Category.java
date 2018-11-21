package fr.ngando.category.domain;

public class Category {
	private int id;
	private String name;
	private String tag;
	
	public Category(String name, String tag) {
		super();
		this.name = name;
		this.tag = tag;
	}
	
	public Category(int id, String name, String tag) {
		super();
		this.id = id;
		this.name = name;
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean equals(Category cat) {
		return this.tag.equals(cat.getTag());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
