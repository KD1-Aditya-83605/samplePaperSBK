package com.sunbeam.tester;

import java.awt.Choice;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import com.sunbeam.dao.MobilesDao;
import com.sunbeam.entity.Mobiles;

public class Program01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		int choice;
		
		
		
		do {
			
			System.out.println("Press 0 : for exit");
			System.out.println("Press 1 : Add a mobile");
			System.out.println("Press 2 : Show all mobiles");
			System.out.println("Press 3 : Search mobile by model");
			System.out.println("Press 4 : Delete mobile by model");
			System.out.println("Press 5 : Sort mobiles by company");
			System.out.println("Press 6 : Sort mobiles by price");
			
			 choice = scanner.nextInt();
			 
			 
			switch (choice) {
			case 1:
			{
				try {
					MobilesDao mobilesDao = new MobilesDao();
					Mobiles mobiles = new Mobiles();
					mobiles.acceptMobile();
					
					mobilesDao.addMobile(mobiles);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			case 2:
			{
				
				try {
					MobilesDao mobilesDao;
					mobilesDao = new MobilesDao();
				ArrayList<Mobiles> ansArrayList = 	   mobilesDao.displayAllMobiles();
				
				for (Mobiles mobiles : ansArrayList) {
					System.out.println(mobiles);
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
				break;
				
			case 3:
			{
				
				try {
					MobilesDao mobilesDao = new MobilesDao();
					System.out.println("Enter model you want to search for: ");
					String mString = scanner.next();
					ArrayList<Mobiles> list  =   mobilesDao.searchByModel(mString);
					
					for (Mobiles mobiles : list) {
						System.out.println(mobiles);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			break;
			
			case 4:
			{
				try {
					MobilesDao mobilesDao = new MobilesDao();
					System.out.println("Enter model you want to delete for: ");
					String mString = scanner.next();
					 
					 boolean ans = mobilesDao.deleteByModel(mString);
					 if(ans) {
						 System.out.println("deleted successfully");
					 }
					 else {
						System.out.println("Err while deleting");
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			break;
			
			case 5:
			{
				
				try {
					MobilesDao mobilesDao = new MobilesDao();
					ArrayList<Mobiles> list = mobilesDao.sortByCompany();
					
					for (Mobiles mobiles : list) {
						System.out.println(mobiles);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			}
			break;
			
			
			case 6:
			{
				try {
					MobilesDao mobilesDao = new MobilesDao();
					ArrayList<Mobiles> list = mobilesDao.sortByPrice();
					
					for (Mobiles mobiles : list) {
						System.out.println(mobiles);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			default:
				break;
			}
			
			
			
		} while(choice != 0); 
		
		
		

	}

}
