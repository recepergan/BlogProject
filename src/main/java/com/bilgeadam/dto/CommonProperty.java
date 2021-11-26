package com.bilgeadam.dto;

import java.io.Serializable;
import java.sql.Date;

// id:int
// name: String
// surname: String
// telNumber: String
// emailAddress: String
// password: String
// createDate: Date
public class CommonProperty implements Serializable {
	
	private static final long serialVersionUID = -6379649305611466126L;
	// özellikler
	private int id;
	private String name;
	private String surname;
	private String telNumber;
	private String emailAddress;
	private String password;
	private Date createDate;
	
	public CommonProperty() {
		// TODO Auto-generated constructor stub
	}
	
	public CommonProperty(String name, String surname, String telNumber, String emailAddress, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.telNumber = telNumber;
		this.emailAddress = emailAddress;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
