package cn.wss.domain;

public class Person {
	private Integer id;
	private String name;

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

	
	public Person() {
		System.out.println("Customer's Constructor..");
	}

	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
