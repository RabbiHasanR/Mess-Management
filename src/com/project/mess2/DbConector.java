package com.project.mess2;
import java.sql.*;
import javax.swing.*;

public class DbConector {
	static Connection conn=null;
	
	public static Connection dbConector(){
		try{
			Class.forName("org.sqlite.JDBC");
		      conn=DriverManager.getConnection("jdbc:sqlite:F:\\mess_management\\mess_management.sqlite");
			JOptionPane.showMessageDialog(null,"Connection is succsesfull");
			return conn;
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	
	public void addMemberInformation(String name , String email , String address, String phone , String occuption , String sex) throws SQLException{
		try{
		String query = "Insert into member(member_name,member_email,member_address,member_phone,member_occuption,sex) values(?,?,?,?,?,?) ";
		PreparedStatement psmt = conn.prepareStatement(query);
		psmt.setString(1, name);
		psmt.setString(2,email);
		psmt.setString(3,address);
		psmt.setString(4,phone);
		psmt.setString(5,occuption);
		psmt.setString(6,sex);
	    int value = 	psmt.executeUpdate();
	    if(value==1){
	    	JOptionPane.showMessageDialog(null,"Data Inserted");
	    	
	    }
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please Give Data.Data Not Insert");
		}

		 
		
		
	
	}
	public void deleteMember(String ID ){
		String query = "delete from member where ID= ? ";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, ID);
			//psmt.setString(1, ID);
			int value = psmt.executeUpdate();
			if(value==1){
				JOptionPane.showMessageDialog(null, "Data Delete");
			}
			else{
				JOptionPane.showMessageDialog(null,"Name Not Match.Try Again");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteMemberFromPayment(String id ){
		String query = "delete from payment where member_id= ? ";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, id);
			int value = psmt.executeUpdate();
			if(value==1){
				JOptionPane.showMessageDialog(null, "Data Delete");
			}
			/*else{
				JOptionPane.showMessageDialog(null," Not Match.Try Again");
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteBazar(String ID ){
		String query = "delete from bazar where member_id= ? ";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, ID);
			//psmt.setString(1, ID);
			int value = psmt.executeUpdate();
			if(value==1){
				JOptionPane.showMessageDialog(null, "Data Delete");
			}
			else{
				JOptionPane.showMessageDialog(null,"Name Not Match.Try Again");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMeal(String ID ){
		String query = "delete from meal where member_id= ? ";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(query);
			psmt.setString(1, ID);
			//psmt.setString(1, ID);
			int value = psmt.executeUpdate();
			if(value==1){
				JOptionPane.showMessageDialog(null, "Data Delete");
			}
			else{
				JOptionPane.showMessageDialog(null,"Name Not Match.Try Again");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addMemberInformationPayment(String ID,String date,String paid,String budget) throws SQLException{
		//String ID = null;
		try{
		/*String query1="select ID from member where member_name=?";
		PreparedStatement pst=conn.prepareStatement(query1);
		pst.setString(1,name);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			 ID=rs.getString("ID");
			//id=Integer.parseInt(ID);
			
		}*/
		
		String query = "Insert into payment(member_id,payment_month,paid,budget) values(?,?,?,?)  ";
		PreparedStatement psmt = conn.prepareStatement(query);
		psmt.setString(1, ID);
		psmt.setString(2,date);
		psmt.setString(3,paid);
		psmt.setString(4,budget);
	    int value = 	psmt.executeUpdate();
	    if(value==1){
	    	JOptionPane.showMessageDialog(null,"Data Inserted");
	    	
	    }
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please Give Value.Data Not Insert");
		}

		 
		
		
	
	}
	
	public void addMemberInformationBazar(String ID,String month,String bazarCost,String date) throws SQLException{
		//String ID = null;
		try{
		/*String query1="select ID from member where member_name=?";
		PreparedStatement pst=conn.prepareStatement(query1);
		pst.setString(1,name);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			 ID=rs.getString("ID");
			//id=Integer.parseInt(ID);
			
		}*/
		
		String query = "Insert into bazar(month,member_id,bazar,date) values(?,?,?,?) ";
		PreparedStatement psmt = conn.prepareStatement(query);
		psmt.setString(1,month);
		psmt.setString(2,ID);
		psmt.setString(3,bazarCost);
		psmt.setString(4,date);
	    int value = psmt.executeUpdate();
	    if(value==1){
	    	JOptionPane.showMessageDialog(null,"Data Inserted");
	    	
	    }
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please Give Data.Data Not Inserted");
		}

		 
		
		
	
	}
	
	public void addMemberInformationMill(String ID,String month,String meal,String date) throws SQLException{
		//String ID=null;
		try{
		/*String query1="select ID from member where member_name=?";
		PreparedStatement pst=conn.prepareStatement(query1);
		pst.setString(1,name);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			 ID=rs.getString("ID");
			//id=Integer.parseInt(ID);
			
		}*/
		
		
		
		String query = "Insert into meal(meal_month,member_id,meal,date) values(?,?,?,?) ";
		PreparedStatement psmt = conn.prepareStatement(query);
		psmt.setString(1,month);
		psmt.setString(2,ID);
		psmt.setString(3,meal);
		psmt.setString(4,date);
	    int value = 	psmt.executeUpdate();
	    if(value==1){
	    	JOptionPane.showMessageDialog(null,"Data Inserted");
	    	
	    }
	   
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please Give Data.Data Not Inserted");
		}
	    

		 
		
		
	
	}
	
	}
		 
	


	
