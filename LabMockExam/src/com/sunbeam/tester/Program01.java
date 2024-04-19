package com.sunbeam.tester;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.sunbeam.entity.Person;

public class Program01 {

	public static void main(String[] args) {
		
		Scanner scanner  = new Scanner(System.in);
		
		LinkedHashSet<Person> persons = new LinkedHashSet<>();
		
//		A. Person with same name should not be added.
//		B. Display should display people in order of insertion.
//		C. Find by name should be done using appropriate collection method.
//		It should only display message, found or not found.
//		D. Save in file should be done using serialization.
//		E. Load from file should get data back into the collection.
//		F. All resources should be closed properly.
//		G. Dates should be accepted and displayed in dd/MM/yyyy format.
		
		int choice;
		do {
			System.out.println("Press 0 : To exit");
			System.out.println("Press 1 : To Add new person");
			System.out.println("Press 2 : Display all person");
			System.out.println("Press 3 : Find person by name");
			System.out.println("Press 4 : Save data in file");
			System.out.println("Press 5 : Load data from file");
			System.out.println("Press 6 : Display in sorted order of dist");
			System.out.println("Press 7 : Display in sorted order of name");
			
			choice = scanner.nextInt();
			
			switch (choice) {
			case 0:
			{
				System.out.println("Thanks");
				
			}
				
				break;
				
			case 1:
			{
				Person person = new Person();
				person.acceptData();
				persons.add(person);
			}
			break;
			
			case 2:
			{
				for (Person person : persons) {
					System.out.println(person);
				}
				
			}
			break;
			
			case 3:
			{
				
				Person person = new Person();
				System.out.println("Enter name you want to check: ");
				String name = scanner.next();
				person.setName(name);
				
				boolean isIt = persons.contains(person);
				
				if(isIt) System.out.println("Found");
				
				else System.out.println("Not found");

				
			}
			break;
			
			case 4:
			{
				try {
					FileOutputStream fileOutputStream = new FileOutputStream("Person.txt");
					ObjectOutputStream oStream = new ObjectOutputStream(fileOutputStream);
					
					oStream.writeObject(persons);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			break;
			
			case 5:
			{
				
				FileInputStream fileInputStream;
				try {
					fileInputStream = new FileInputStream("Person.txt");
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					
					LinkedHashSet<Person> persons2 = new LinkedHashSet<>();
					
					persons2  = (LinkedHashSet<Person>) objectInputStream.readObject();
					
					for (Person person : persons2) {
						System.out.println(person);
					}
					
					System.out.println("Data displyed from file...");
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
			}
			break;
			
			case 6:
			{
				ArrayList<Person> arrayListPersons = new ArrayList<>();
				
				for (Person p : persons) {
					arrayListPersons.add(p);
				}
				
				Comparator<Person> cmpComparator = new Comparator<Person>() {
					
					@Override
					public int compare(Person o1, Person o2) {
						
						return o1.getHomeAddress().getDist().compareTo(o2.getHomeAddress().getDist());
					}
				};
				
				arrayListPersons.sort(cmpComparator);
				
				for (Person person : arrayListPersons) {
					System.out.println(person);
				}
				
			}
			break;
			
			case 7:
			{
				ArrayList<Person> arrayListPersons = new ArrayList<>();
				
				for (Person p : persons) {
					arrayListPersons.add(p);
				}
				
				Comparator<Person> cmpComparator = new Comparator<Person>() {
					
					@Override
					public int compare(Person o1, Person o2) {
						
						return o1.getName().compareTo(o2.getName());
					}
				};
				
				arrayListPersons.sort(cmpComparator);
				
				for (Person person : arrayListPersons) {
					System.out.println(person);
				}
				
			}
			break;

			default:
				break;
			}
			
			
			
			
		}while(choice!=0);
	}

}
