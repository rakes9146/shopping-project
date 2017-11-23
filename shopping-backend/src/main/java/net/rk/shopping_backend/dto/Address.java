package net.rk.shopping_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/************************/
	

	/***********************/

	@Column(name = "address_line_one")
	@NotBlank(message = "Please Enter Address Line")
	private String addressLineOne;

	@Column(name = "address_line_two")
	@NotBlank(message = "Please Enter Address Line Two")
	private String addressLineTwo;
	@NotBlank(message = "Please Enter City")
	private String city;
	@NotBlank(message = "Please Enter State")
	private String state;
	@NotBlank(message = "Please Enter Country")
	private String country;

	@Column(name = "postal_code")
	@Length(min = 6, max = 6, message = "Invalid Pincode Format")
	@NotBlank(message = "Please Enter Postal Code")
	private String postalCode;

	@Column(name = "is_billing")
	private boolean billing;
	@Column(name = "is_shipping")
	private boolean shipping;

	/*
	 * Getters and Setters methods
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	
	@Column(name = "user_id")
	private int userId;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
