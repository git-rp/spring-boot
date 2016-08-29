package com.test.springboot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer
    {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String address;
	private String cardId;
	@OneToMany(targetEntity=Purchase.class,fetch=FetchType.EAGER)
	@JoinColumn(name="client_id")
	private List<Purchase> purchases;
	public List<Purchase> getPurchases() {
	    return purchases;
	}
	public void setPurchases(List<Purchase> purchases) {
	    this.purchases = purchases;
	}
	public long getId() {
	    return id;
	}
	public void setId(long id) {
	    this.id = id;
	}
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	public String getAddress() {
	    return address;
	}
	public void setAddress(String address) {
	    this.address = address;
	}
	public String getCardId() {
	    return cardId;
	}
	public void setCardId(String cardId) {
	    this.cardId = cardId;
	}
	
	

    }
