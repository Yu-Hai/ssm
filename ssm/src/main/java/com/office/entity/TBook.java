package com.office.entity;

public class TBook {
	private String idBook;// 图书ID

	private String name;// 图书名称

	private int number;// 馆藏数量

	public TBook() {
	}

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "TBook [idBook=" + idBook + ", name=" + name + ", number="
				+ number + "]";
	}

	public TBook(String idBook, String name, int number) {
		super();
		this.idBook = idBook;
		this.name = name;
		this.number = number;
	}

}
