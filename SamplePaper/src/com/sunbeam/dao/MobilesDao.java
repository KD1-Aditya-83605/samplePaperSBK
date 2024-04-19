package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mysql.cj.protocol.Resultset;
import com.sunbeam.entity.Mobiles;
import com.sunbeam.utils.MobileUtils;

public class MobilesDao {
	private Connection connection;
	
	public MobilesDao() throws SQLException {
		connection = MobileUtils.getConnection();
	}
	
	
	
	public void addMobile(Mobiles mob) throws SQLException  {
		
		
		
		String sqlString = "insert into mobiles values(?,?,?)";
		
		
		try(PreparedStatement statement = connection.prepareStatement(sqlString)){
			statement.setString(1, mob.getModel());
			statement.setString(2, mob.getCompany());
			statement.setDouble(3, mob.getPrice());
			
			statement.executeUpdate();
			
			System.out.println("Mobile added..");
		}
	}
	
	
	public ArrayList<Mobiles> displayAllMobiles() {
		
		ArrayList<Mobiles> list = new ArrayList<>();
		
		String sqlString = "select * from mobiles";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Mobiles mobiles = new Mobiles();
				
				mobiles.setModel(resultSet.getString(1));
				mobiles.setCompany(resultSet.getString(2));
				mobiles.setPrice(resultSet.getDouble(3));
				
				list.add(mobiles);
			}
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	
	}
	
	
	public ArrayList<Mobiles> searchByModel(String model){
		
		String sqlString = "select * from mobiles where Model=?";
		
		ArrayList<Mobiles> list = new ArrayList<>();
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, model);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Mobiles mobiles = new Mobiles();
				mobiles.setModel(resultSet.getString(1));
				mobiles.setCompany(resultSet.getString(2));
				mobiles.setPrice(resultSet.getDouble(3));
				
				list.add(mobiles);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	public boolean deleteByModel(String model) {
		
		boolean ans = false;
		
		String sqlString = "delete from mobiles where model = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			
			statement.setString(1, model);
			
			int val = statement.executeUpdate();
			
			if(val>0) {
				ans = true;
			}
			else {
				ans = false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}
	
	public ArrayList<Mobiles> sortByCompany() {
		
		ArrayList<Mobiles> list = new ArrayList<>();
		
		String sqlString = "select * from mobiles";  //or you can directly pass query order by
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Mobiles mobiles = new Mobiles();
				
				mobiles.setModel(resultSet.getString(1));
				mobiles.setCompany(resultSet.getString(2));
				mobiles.setPrice(resultSet.getDouble(3));
				
				list.add(mobiles);
			}
			
			class companyName implements Comparator<Mobiles>{

				@Override
				public int compare(Mobiles o1, Mobiles o2) {
					return o1.getCompany().compareTo(o2.getCompany());
					
				}
			}
			
			Comparator<Mobiles> cmpComparator = new companyName();
			
			Collections.sort(list,cmpComparator);
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		return list;
		
	}
	
	
public ArrayList<Mobiles> sortByPrice() {
		
		ArrayList<Mobiles> list = new ArrayList<>();
		
		String sqlString = "select * from mobiles";  //or you can directly pass query order by
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlString);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Mobiles mobiles = new Mobiles();
				
				mobiles.setModel(resultSet.getString(1));
				mobiles.setCompany(resultSet.getString(2));
				mobiles.setPrice(resultSet.getDouble(3));
				
				list.add(mobiles);
			}
			
			class companyName implements Comparator<Mobiles>{

				@Override
				public int compare(Mobiles o1, Mobiles o2) {
					return Double.compare(o1.getPrice(), o2.getPrice());
					
				}
			}
			
			Comparator<Mobiles> cmpComparator = new companyName();
			
			Collections.sort(list,cmpComparator);
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
		return list;
		
	}
	
	
	
	
	



	
	
	

}
