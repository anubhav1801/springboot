package com.example.demo.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;


@Entity
public class OrderEntity {
	
	@Id
	@GeneratedValue(generator = "OrderGenerator")
	@SequenceGenerator(name = "OrderGenerator",sequenceName = "OrderSequence",initialValue = 1001)
	private int orderId;
	
	
	private String customerName;
	
	@ManyToOne
	@JoinColumn(name="productId")
	ProductEntity productEntity;
	
	public OrderEntity() {
		super();
	}
	
	

	public OrderEntity(int orderId, String customerName, ProductEntity productEntity) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.productEntity = productEntity;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public ProductEntity getProduct() {
		return productEntity;
	}

	public void setProduct(ProductEntity product) {
		this.productEntity = product;
	}
}