package com.bilgeadam.dto;

import java.util.List;

public class AdminDto extends CommonProperty {
	
	private static final long serialVersionUID = -6214174547778684454L;
	
	// özellikler
	private int registerNumberOfRecords;
	
	List<UserDto> userDtoList;
	
	// p.siz cons.
	public AdminDto() {
		
	}
	
	// p.li cons.
	public AdminDto(String name, String surname, String telNumber, String emailAddress, String password,
			int registerNumberOfRecords) {
		super(name, surname, telNumber, emailAddress, password);
		this.registerNumberOfRecords = registerNumberOfRecords;
	}
	// toString
	
	// gettrer an sdsete
	public int getRegisterNumberOfRecords() {
		return registerNumberOfRecords;
	}
	
	public void setRegisterNumberOfRecords(int registerNumberOfRecords) {
		this.registerNumberOfRecords = registerNumberOfRecords;
	}
	
	public List<UserDto> getUserDtoList() {
		return userDtoList;
	}
	
	public void setUserDtoList(List<UserDto> userDtoList) {
		this.userDtoList = userDtoList;
	}
	
	@Override
	public String toString() {
		return "AdminDto [registerNumberOfRecords=" + registerNumberOfRecords + ", userDtoList=" + userDtoList
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getTelNumber()=" + getTelNumber() + ", getEmailAddress()=" + getEmailAddress() + ", getPassword()="
				+ getPassword() + ", getCreateDate()=" + getCreateDate() + "]";
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
