package com.example.seckill.jvm;

public class User extends Person {
	
	private int id;
	private String name;

	byte[] a = new byte[1024*100];

	public User(){}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public static void main(String[] args) {

	}
}
