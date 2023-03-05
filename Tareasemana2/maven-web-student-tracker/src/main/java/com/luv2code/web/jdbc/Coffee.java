package com.luv2code.web.jdbc;

public class Coffee {

	private int id;
	private String name;
	private String toppings;
	private String price;

	public Coffee(String name, String toppings, String price) {
		this.name = name;
		this.toppings = toppings;
		this.price = price;
	}

	public Coffee(int id, String name, String toppings, String price) {
		this.id = id;
		this.name = name;
		this.toppings = toppings;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Coffee [id=" + id + ", name=" + name + ", toppings=" + toppings + ", price=" + price + "]";
	}	
}
