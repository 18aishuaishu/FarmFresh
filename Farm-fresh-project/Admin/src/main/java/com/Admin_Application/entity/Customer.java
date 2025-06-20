package com.Admin_Application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custid")
	private long custid;
	private String cusName;
	private String cusAddress;
	private long cusAccount;
	private long cusPhone;
	private String cusEmail;
	public long getCustid() {
		return custid;
	}
	public void setCustid(long custid) {
		this.custid = custid;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public long getCusAccount() {
		return cusAccount;
	}
	public void setCusAccount(long cusAccount) {
		this.cusAccount = cusAccount;
	}
	public long getCusPhone() {
		return cusPhone;
	}
	public void setCusPhone(long cusPhone) {
		this.cusPhone = cusPhone;
	}
	public String getCusEmail() {
		return cusEmail;
	}
	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}
	
	
}
