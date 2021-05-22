package com.example.demo;

import lombok.Data;

@Data
public class MyTest {
	String name;
	int age;
	

	
	public static void main(String[] args) {
		System.out.println("hi");
		MyTest user = new MyTest();
		user.setName("Jack");
		user.setAge(20);
		System.out.println(user.toString());
		user.getName();
		System.out.println(tooString());
	}
	
	public static String tooString() {
		return "a"+"b";
	}

}
