package com.bilgeadam.dto;
// isActive: boolean
// HesCodes: String

public class UserDto extends CommonProperty {
	private static final long serialVersionUID = 1L;
	
	// genel ozellikler
	private boolean isActive;
	private String HesCodes;
	private int admin_id;
	
	private AdminDto adminDto;
	
	public UserDto() {
		this.isActive = true;
	}
	
	public UserDto(boolean isActive, String hesCodes, int admin_id) {
		super();
		this.isActive = isActive;
		HesCodes = hesCodes;
		this.admin_id = admin_id;
	}
	
	public UserDto(String name, String surname, String telNumber, String emailAddress, String password,
			boolean isActive, String hesCodes, int admin_id) {
		super(name, surname, telNumber, emailAddress, password);
		this.isActive = isActive;
		HesCodes = hesCodes;
		this.admin_id = admin_id;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getHesCodes() {
		return HesCodes;
	}
	
	public void setHesCodes(String hesCodes) {
		HesCodes = hesCodes;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	public AdminDto getAdminDto() {
		return adminDto;
	}
	
	public void setAdminDto(AdminDto adminDto) {
		this.adminDto = adminDto;
	}
	
	@Override
	public String toString() {
		return "UserDto [isActive=" + isActive + ", HesCodes=" + HesCodes + ", admin_id=" + admin_id + ", adminDto="
				+ adminDto + ", isActive()=" + isActive() + ", getHesCodes()=" + getHesCodes() + ", getAdmin_id()="
				+ getAdmin_id() + "]";
	}
	
}
