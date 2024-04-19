package com.sunbeam.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

//2. Create another POJO class Person with fields name (String), birthDate (java.util.Date),
//homeAddr (Address).

public class Person  implements Acceptable ,Comparable<Person>,Serializable{
	
	private String name;
	private Date birthDate;
	private Address homeAddress;
	
	public Person() {
		
	}
	

	public Person(String name, Date birthDate, Address homeAddress) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.homeAddress = homeAddress;
	}
	
	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	
	@Override
	public String toString() {
		return "Person [name=" + name + ", birthDate=" + birthDate.getDate()+"-"+birthDate.getMonth()+"-"+birthDate.getYear() + ", homeAddress=" + homeAddress + "]";
	}


	@Override
	public void acceptData() {
		homeAddress = new Address();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Name: ");
		name = scanner.next();
		System.out.println("Enter birthdate:(dd-mm-yy) ");
		int dd = scanner.nextInt();
		int mm = scanner.nextInt();
		int yy = scanner.nextInt();
		
		birthDate = new Date(yy,mm,dd);
		
		System.out.println("Address field below.. ");
		homeAddress.acceptData();
		
	
		
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}


	@Override
	public int compareTo(Person o) {
		return this.getName().compareTo(o.getName());
		
	}


	
	
	

}
