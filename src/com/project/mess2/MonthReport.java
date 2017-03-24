package com.project.mess2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
public class MonthReport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	double totalBazarCost;
	double totalMeal;
	Connection connection=null;
	private JButton btnBack;
	private JButton btnExit;
	private JLabel lblMessManagementSystem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonthReport frame = new MonthReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MonthReport() {
		connection=DbConector.dbConector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalMeal = new JLabel("Total meal :");
		lblTotalMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalMeal.setBounds(28, 50, 86, 14);
		contentPane.add(lblTotalMeal);
		
		textField = new JTextField();
		textField.setBounds(124, 47, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalBazarCost = new JLabel("Total Bazar Cost :");
		lblTotalBazarCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalBazarCost.setBounds(0, 100, 114, 14);
		contentPane.add(lblTotalBazarCost);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 97, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMealRate = new JLabel("Meal Rate :");
		lblMealRate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMealRate.setBounds(28, 148, 86, 14);
		contentPane.add(lblMealRate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 145, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
			}
		});
		btnBack.setBounds(248, 46, 89, 23);
		contentPane.add(btnBack);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(248, 96, 89, 23);
		contentPane.add(btnExit);
		
		lblMessManagementSystem = new JLabel("Mess Management System");
		lblMessManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMessManagementSystem.setBounds(96, 11, 252, 25);
		contentPane.add(lblMessManagementSystem);
	}
	
	public void totalMeal(){
		try{
			String query="select sum(meal)from meal";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()){
				String sum=rs.getString("sum(meal)");
				textField.setText(sum);
				totalMeal=Double.parseDouble(sum);
				
				//textField.setText(String.valueOf(totalMeal));
				
               
			}
		}
		catch(Exception s){
			JOptionPane.showMessageDialog(null,s);
			
		}
	}
	public void totalBazarCost(){
		try{
			String query="select sum(bazar)from bazar";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()){
				String sum=rs.getString("sum(bazar)");
				textField_1.setText(sum);
				 totalBazarCost=Double.parseDouble(sum);
				//textField_1.setText(String.valueOf(totalBazarCost));
               
			}
		}
		catch(Exception s){
			JOptionPane.showMessageDialog(null, s);
			
		}
		
	}
	public void mealRate(){
		double mealRate=totalBazarCost/totalMeal;
		textField_2.setText(String.valueOf(mealRate));
	}

}
