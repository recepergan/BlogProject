package com.bilgeadam.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bilgeadam.dto.AdminDto;

// admin_name character varying,
// admin_surname character varying,
// admin_tel_number character varying,
// admin_email_addres character varying,
// admin_password character varying,

public class AdminDao implements IDAOImplements<AdminDto> {
	
	public static void main(String[] args) {
		AdminDto adminDto = new AdminDto();
		adminDto.setName("recep");
		adminDto.setSurname("ergan");
		adminDto.setTelNumber("23456");
		adminDto.setEmailAddress("dfgnfbxca@gmail.com");
		adminDto.setPassword("şifre");
		
		// AdminDao adminDao = new AdminDao();
		// adminDao.insert(adminDto);
		
		AdminDto adminDto1 = new AdminDto();
		adminDto1.setName("recep11");
		adminDto1.setSurname("ergan11");
		adminDto1.setTelNumber("2345611");
		adminDto1.setEmailAddress("dfgnfbxca@gmail.com11");
		adminDto1.setPassword("şifre11");
		adminDto1.setId(3);
		
		// AdminDao adminDao1 = new AdminDao();
		// adminDao1.update(adminDto1);
		
		AdminDto adminDto2 = new AdminDto();
		adminDto2.setId(10);
		
		// AdminDao adminDao2 = new AdminDao();
		// adminDao2.delete(adminDto2);
		
		// AdminDao adminDao3 = new AdminDao();
		// ArrayList<AdminDto> temp = adminDao3.list();
		// temp.forEach(System.out::println);
		
		fileReader();
		
	}
	
	public static void fileReader() {
		String path = "C:\\bilgeadam\\admin.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String toplamSatirlar = "";
			String satir = "";
			
			while ((satir = br.readLine()) != null) {
				toplamSatirlar = toplamSatirlar + satir + "\n";
			}
			System.out.println(toplamSatirlar);
			
		} catch (Exception e) {
			System.out.println("admin.txt ten admin bil. okunamadı");
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into admin_blog (admin_name,admin_surname,admin_tel_number,"
					+ "admin_email_addres,admin_password) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurname());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, t.getPassword());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(AdminDao.class + "Ekleme bassarılı");
			} else {
				System.out.println("Ekleme sırasında bir hata meydana geldi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "AdminDao hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update admin_blog set admin_name=?,admin_surname=?,admin_tel_number=?,"
					+ "admin_email_addres=?,admin_password=? where admin_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurname());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, t.getPassword());
			preparedStatement.setInt(6, t.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(AdminDao.class + "günvcellem bassarılı");
			} else {
				System.out.println("güncelleme sırasında bir hata meydana geldi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "AdminDao hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "delete from admin_blog where admin_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(AdminDao.class + "silme bassarılı");
			} else {
				System.out.println("silme sırasında bir hata meydana geldi");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "AdminDao hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public ArrayList<AdminDto> list() {
		ArrayList<AdminDto> list2 = new ArrayList<AdminDto>();
		AdminDto adminDto;
		
		try (Connection connection = getInterfaceConnection()) {
			String sql = "Select * from admin_blog";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				adminDto = new AdminDto();
				adminDto.setId(resultSet.getInt("admin_id"));
				adminDto.setEmailAddress(resultSet.getString("admin_email_addres"));
				adminDto.setName(resultSet.getString("admin_name"));
				adminDto.setPassword(resultSet.getString("admin_password"));
				adminDto.setSurname(resultSet.getString("admin_surname"));
				adminDto.setCreateDate(resultSet.getDate("created_date"));
				adminDto.setRegisterNumberOfRecords(resultSet.getInt("admin_number_of_records"));
				adminDto.setTelNumber(resultSet.getString("admin_tel_number"));
				list2.add(adminDto);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "AdminDao select hata meydana geldi");
			e.printStackTrace();
		}
		
		return list2;
		
	}
	
}
