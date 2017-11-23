package net.rk.shopping_backend.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="product")
public class Product implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	
	@NotBlank(message = "Please Enter the Product Name!")
	private String name;
	@NotBlank(message = "Please Enter the Product Brand!")
	private String brand;
	
	@NotBlank(message = "Please Enter the Product Description!")
	private String description;
	@Column(name="unit_price")
	@Min(value=1,message="The price can not be less then one")
	private double unitPrice;
	private int quantity;
	
	@Column(name="is_active")
	private boolean active;
	@Column(name="category_id")

	@JsonIgnore
	private int categoryId;
	@Column(name="supplier_id")
	@JsonIgnore
	private int supplierId;
	private int purchase;
	private int views;
	
	@Transient
	private MultipartFile file;
	
	
	
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	//default constructor
	public Product(){
		
		this.code = UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	//setters and getters method
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPurchase() {
		return purchase;
	}
	public void setPurchase(int purchase) {
		this.purchase = purchase;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	
	
}
