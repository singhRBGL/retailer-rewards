package com.task.retailerrewards.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long price;

	@Column(name = "purchase_date")
	private Date purchaseDate;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_id")
	private String customerId;

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}



	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customer_name) {
		this.customerName = customer_name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customer_id) {
		this.customerId = customer_id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
