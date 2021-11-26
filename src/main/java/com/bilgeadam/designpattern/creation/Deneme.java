package com.bilgeadam.designpattern.creation;

public interface Deneme {
	void denemeMethod();
	
	default void method() {
		System.out.println("Deneme");
		
	}
	
}
