package com.bilgeadam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.bilgeadam.dto.UserDto;

public class UserDao implements IDAOImplements<UserDto> {
	
	public static void main(String[] args) {
		
		UserDto userDto = new UserDto();
		userDto.setName("recep");
		userDto.setSurname("ergan");
		userDto.setTelNumber("23456");
		userDto.setEmailAddress("dfgnfbxca@gmail.com");
		userDto.setPassword("şifre");
		userDto.setAdmin_id(9);
		
		// UserDao userDao = new UserDao();
		// userDao.insert(userDto);
		
		UserDto userDto1 = new UserDto();
		userDto1.setName("sdfg");
		userDto1.setSurname("sdf");
		userDto1.setTelNumber("2345");
		userDto1.setEmailAddress("cvb@gmail.com");
		userDto1.setPassword("dv");
		userDto1.setId(5);
		
		// UserDao userDao1 = new UserDao();
		// userDao1.update(userDto1);
		
		UserDto userDto2 = new UserDto();
		userDto2.setId(13);
		
		// UserDao userDao2 = new UserDao();
		// userDao2.delete(userDto2);
		
		// UserDao userDao3 = new UserDao();
		// ArrayList<UserDto> temp = userDao3.list();
		// temp.forEach(System.out::println);
		
		loginBlog();
		
	}
	
	public static void loginBlog() {
		Scanner sc = new Scanner(System.in);
		UserDto userDto5 = new UserDto();
		System.out.println("Lütfen email giriniz");
		userDto5.setEmailAddress(sc.nextLine());
		System.out.println("Litfen password girizid");
		userDto5.setPassword(sc.nextLine());
		UserDao userDao4 = new UserDao();
		System.out.println(userDao4.getSearchLogin(userDto5));
		
	}
	
	public boolean getSearchLogin(UserDto userDto) {
		ArrayList<UserDto> list3 = new ArrayList<UserDto>();
		UserDto userDto1;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select user_blog.user_password,user_blog.user_email_address "
					+ "from  user_blog where user_blog.user_email_address = ? and user_blog.user_password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userDto.getEmailAddress());
			preparedStatement.setString(2, userDto.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "UserDao select hata meydana geldi");
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public ArrayList<UserDto> list() {
		ArrayList<UserDto> list2 = new ArrayList<UserDto>();
		UserDto UserDto;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "Select * from user_blog";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserDto = new UserDto();
				UserDto.setId(resultSet.getInt("user_id"));
				UserDto.setEmailAddress(resultSet.getString("user_email_address"));
				UserDto.setName(resultSet.getString("user_name"));
				UserDto.setPassword(resultSet.getString("user_password"));
				UserDto.setSurname(resultSet.getString("user_surname"));
				UserDto.setCreateDate(resultSet.getDate("created_date"));
				UserDto.setHesCodes(resultSet.getString("user_hescode"));
				UserDto.setActive(resultSet.getBoolean("user_is_active"));
				UserDto.setTelNumber(resultSet.getString("user_tel_number"));
				UserDto.setAdmin_id(resultSet.getInt("admin_id"));
				list2.add(UserDto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "UserDao select hata meydana geldi");
			e.printStackTrace();
		}
		
		return list2;
		
	}
	
	public void insert(UserDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into user_blog (user_name,user_surname,user_tel_number,"
					+ "user_email_address,user_password,admin_id) values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurname());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, t.getPassword());
			preparedStatement.setInt(6, t.getAdmin_id());
			
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(UserDao.class + "Ekleme bassarılı");
			} else {
				System.out.println("Ekleme sırasında bir hata meydana geldi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "UserDao hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	public void update(UserDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update user_blog set user_name=?,user_surname=?,user_tel_number=?,"
					+ "user_email_address=?,user_password=? where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurname());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, t.getPassword());
			preparedStatement.setInt(6, t.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(UserDao.class + "günvcellem bassarılı");
			} else {
				System.out.println("güncelleme sırasında bir hata meydana geldi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "UserDao hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	public void delete(UserDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "delete from user_blog where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(UserDao.class + "silme bassarılı");
			} else {
				System.out.println("silme sırasında bir hata meydana geldi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "UserDao hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
}
