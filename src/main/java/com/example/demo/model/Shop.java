package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="shop")
public class Shop {

	@Id
	@Column(name="id_shop")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idShop;
	@Column(name="name")
	private String name;
	@Column(name="city")
	private String city;
	@Column(name="street")
	private String street;
	@ManyToOne
	@JoinColumn(name="id_product")
	@JsonBackReference
	private Product product;
	
	public Shop () {}

	public int getIdShop() {
		return idShop;
	}

	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
