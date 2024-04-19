package com.sunbeam.entity;

import java.io.Serializable;
import java.util.Scanner;

//Create a POJO class Address with fields area (String), dist (String), and pin (int).


public class Address implements Acceptable ,Serializable{
	private String areaString;
	private String dist;
	private int pin;
	
	
	public Address() {
		
	}
	
	

	public Address(String areaString, String dist, int pin) {
		
		this.areaString = areaString;
		this.dist = dist;
		this.pin = pin;
	}
	
	
	
	
	public String getAreaString() {
		return areaString;
	}
	public void setAreaString(String areaString) {
		this.areaString = areaString;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	@Override
	public String toString() {
		return " Area=" + areaString + ", dist=" + dist + ", pin=" + pin + "]";
	}



	@Override
	public void acceptData() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter area: ");
		areaString = scanner.next();
		System.out.println("Enter dist: ");
		dist = scanner.next();
		System.out.println("Enter pin: ");
		pin = scanner.nextInt();
		
	}
	
	
	

}
