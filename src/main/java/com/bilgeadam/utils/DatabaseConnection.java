package com.bilgeadam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	// database bağlantısını kuracak class
	private Connection connection;
	
	// url username password çağırmak
	private static DatabaseInformation databaseInformation;
	// =new DatabaseInformation(); burada new oluşturmak hafızada yer kaplar.
	
	// constructor gibi çalışan bir bileşen
	static {
		databaseInformation = new DatabaseInformation();
		// bunu yapmazsak null Pointer exception
	}
	
	// database bağlamak için zorunlu yerdir
	private String url = databaseInformation.getUrl();
	private String userName = databaseInformation.getUserName();
	private String password = databaseInformation.getPassword();
	
	// singleton 1.özellik
	private static DatabaseConnection instance;
	
	// singleton 1.özellik
	private DatabaseConnection() {
		try {
			Class.forName(databaseInformation.getForNameData());
			System.out.println("Postgeresql 42.3.1 jar yüklendi");
			
			this.connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Başarılı bağlantı");
			
		} catch (Exception e) {
			System.out.println("Hatalar meydana geldi");
			e.printStackTrace();
			
		}
		
	}
	
	// singleton 3.özellik
	public static DatabaseConnection getInstance() {
		
		try {
			if (instance == null) {
				instance = new DatabaseConnection();
			} else if (instance.getConnection().isClosed()) {
				instance = new DatabaseConnection();
			}
		} catch (SQLException e) {
			System.out.println("Singleton Hatası");
			e.printStackTrace();
		}
		return instance;
	}
	
	// getter and setter
	public Connection getConnection() {
		return connection;
	}
	
	public static void main(String[] args) {
		
	}
	
}
