package com.bilgeadam.controller;

import java.util.ArrayList;
import java.util.List;

import com.bilgeadam.dao.IDAOImplements;
import com.bilgeadam.dao.UserDao;
import com.bilgeadam.dto.UserDto;

public class UserController implements IDAOImplements<UserDto> {
	// özellikler
	private UserDto userDto;
	private UserDao userDao;
	private List<UserDto> userList;
	
	// p.szi cons.
	public UserController() {
		userDto = new UserDto();
		userDao = new UserDao();
		userList = new ArrayList<UserDto>();
		
	}
	
	@Override
	public void insert(UserDto t) {
		userDao.insert(t);
		
	}
	
	@Override
	public void update(UserDto t) {
		userDao.update(t);
		
	}
	
	@Override
	public void delete(UserDto t) {
		userDao.delete(t);
		
	}
	
	@Override
	public ArrayList<UserDto> list() {
		return userDao.list();
	}
	
	// değişken
	
	public UserDto getUserDto() {
		return userDto;
	}
	
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<UserDto> getUserList() {
		return userList;
	}
	
	public void setUserList(List<UserDto> userList) {
		this.userList = userList;
	}
	
}
