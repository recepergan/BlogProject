package com.bilgeadam.designpattern.creation.a1singleton;

public class SingletonDesignPattern {
	
	private static SingletonDesignPattern instance;
	
	private SingletonDesignPattern() {
		
	}
	
	public static SingletonDesignPattern getInstance() {
		if (instance == null) {
			instance = new SingletonDesignPattern();
		}
		return instance;
		
	}
	
}
