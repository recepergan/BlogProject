package com.bilgeadam.main;

import com.bilgeadam.controller.UserController;
import com.bilgeadam.dto.AdminDto;
import com.bilgeadam.dto.UserDto;

public class DataBlog {
	
	public static void main(String[] args) {
		// ekleme
		
		AdminDto adminDto = new AdminDto();
		adminDto.setName("rcep");
		adminDto.setSurname("eran");
		adminDto.setTelNumber("2356");
		adminDto.setEmailAddress("dfbxca@gmail.com");
		adminDto.setPassword("şie");
		
		// AdminController adminController = new AdminController();
		// adminController.insert(adminDto);
		//
		AdminDto adminDto1 = new AdminDto();
		adminDto1.setName("recep11");
		adminDto1.setSurname("ergan11");
		adminDto1.setTelNumber("2345611");
		adminDto1.setEmailAddress("dfgnfbxca@gmail.com11");
		adminDto1.setPassword("şifre11");
		adminDto1.setId(12);
		
		// AdminController adminController2 = new AdminController();
		// adminController2.update(adminDto1);
		
		AdminDto adminDto2 = new AdminDto();
		adminDto2.setId(13);
		// AdminController adminController3 = new AdminController();
		// adminController3.delete(adminDto2);
		
		// AdminController adminController4 = new AdminController();
		// ArrayList<AdminDto> temp = adminController4.list();
		// temp.forEach(System.out::println);
		
		UserDto userDto = new UserDto();
		userDto.setName("recep");
		userDto.setSurname("ergan");
		userDto.setTelNumber("23456");
		userDto.setEmailAddress("dfgnfbxca@gmail.com");
		userDto.setPassword("şifre");
		userDto.setAdmin_id(2);
		
		UserController userController = new UserController();
		userController.insert(userDto);
		
	}
}