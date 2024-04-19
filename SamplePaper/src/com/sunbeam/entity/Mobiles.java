package com.sunbeam.entity;

import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Mobiles implements Comparable<Mobiles>{
	private String model;
	private String company;
	private double price;
	
	
	Scanner scanner = new Scanner(System.in);
	
	public Mobiles() {
		
	}
	
	public Mobiles(String model, String company, double price) {
		
		this.model = model;
		this.company = company;
		this.price = price;
	}
	
	
	public void acceptMobile() {
		
		System.out.println("Enter model name: ");
		model = scanner.next();
		System.out.println("Enter company name: ");
		 company = scanner.next();
		System.out.println("Enter price");
		price = scanner.nextDouble();
		
	}
	
	

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobiles [model=" + model + ", company=" + company + ", price=" + price + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(company);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Mobiles))
			return false;
		Mobiles other = (Mobiles) obj;
		return Objects.equals(company, other.company);
	}

	@Override
	public int compareTo(Mobiles o) {
		return this.company.compareTo(o.company);
	}

	
	
	
	
	
	

}
