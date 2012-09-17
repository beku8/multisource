package com.fm.multisource.domain;

// Generated Sep 17, 2012 12:14:57 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Item generated by hbm2java
 */
@Entity
@Table(name = "item")
public class Item implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Double price;

	public Item() {
	}

	public Item(String name) {
		this.name = name;
	}

	public Item(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	@Id
	@Column(name = "name", unique = true, nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String toString(){
		return name + " (" + price + ")";
	}

}
