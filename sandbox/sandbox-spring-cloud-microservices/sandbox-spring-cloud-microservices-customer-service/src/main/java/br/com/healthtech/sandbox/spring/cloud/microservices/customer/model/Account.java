package br.com.healthtech.sandbox.spring.cloud.microservices.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Account {

	private Long id;
	private Integer customerId;
	private String number;

	public Account() {

	}

	public Account(final Long id, final Integer customerId, final String number) {
		this.id = id;
		this.customerId = customerId;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
