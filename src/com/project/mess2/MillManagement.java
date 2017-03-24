package com.project.mess2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
public class MillManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTable table_1;
	 Connection connection=null;
	 private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MillManagement frame = new MillManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	  public void refreashTable(){
		   try{
				String qurey="select * from bazar";
				PreparedStatement pst=connection.prepareStatement(qurey);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		   
	   }
	  
	  public void refreashTable1(){
		   try{
				String qurey="select * from bazar";
				PreparedStatement pst=connection.prepareStatement(qurey);
				ResultSet rs=pst.executeQuery();
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		   
	   }

	/**
	 * Create the frame.
	 */
	public MillManagement() {
		connection=DbConector.dbConector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBazarManagement = new JLabel("Bazar Management");
		lblBazarManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBazarManagement.setBounds(49, 33, 156, 26);
		contentPane.add(lblBazarManagement);
		
		JLabel lblName = new JLabel("ID :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(48, 70, 23, 14);
		contentPane.add(lblName);
		
		JLabel lblBazarCost = new JLabel("Bazar Cost :");
		lblBazarCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBazarCost.setBounds(6, 138, 74, 14);
		contentPane.add(lblBazarCost);
		
		JLabel lblMonth = new JLabel("Month :");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth.setBounds(11, 113, 60, 14);
		contentPane.add(lblMonth);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(25, 171, 46, 14);
		contentPane.add(lblDate);
		
		textField = new JTextField();
		textField.setBounds(81, 67, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 135, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 107, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(81, 168, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.RED);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbConector db = new DbConector();
				try{
				db.addMemberInformationBazar(textField.getText().toString(),textField_2.getText().toString(),textField_1.getText().toString(),textField_3.getText().toString());	
				}
				catch(Exception h){
					h.printStackTrace();
				}
				refreashTable();
			}
		});
		btnSave.setBounds(35, 199, 89, 23);
		contentPane.add(btnSave);
		
		JLabel lblMealManagement = new JLabel("Meal Management");
		lblMealManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMealManagement.setBounds(286, 33, 143, 26);
		contentPane.add(lblMealManagement);
		
		JLabel lblName_1 = new JLabel("ID :");
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName_1.setBounds(265, 70, 36, 14);
		contentPane.add(lblName_1);
		
		JLabel lblMonth_1 = new JLabel("Month :");
		lblMonth_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth_1.setBounds(255, 110, 46, 14);
		contentPane.add(lblMonth_1);
		
		JLabel lblMeal = new JLabel("Add Meal :");
		lblMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMeal.setBounds(227, 146, 74, 14);
		contentPane.add(lblMeal);
		
		JLabel lblDate_1 = new JLabel("Date :");
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate_1.setBounds(255, 182, 46, 14);
		contentPane.add(lblDate_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(311, 67, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(311, 110, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(311, 143, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(311, 179, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setBackground(Color.RED);
		btnSave_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DbConector db = new DbConector();
				try{
				db.addMemberInformationMill(textField_4.getText().toString(),textField_5.getText().toString(),textField_6.getText().toString(),textField_7.getText().toString());	
				}
				catch(Exception h){
					h.printStackTrace();
				}
				refreashTable1();
				
			}
		});
		btnSave_1.setBounds(284, 221, 89, 23);
		contentPane.add(btnSave_1);
		
		JButton btnNewButton = new JButton("Watch Bazar Table");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String qurey="select * from bazar";
					PreparedStatement pst=connection.prepareStatement(qurey);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception g){
					JOptionPane.showMessageDialog(null,g);
				}
			}
		});
		btnNewButton.setBounds(104, 250, 156, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 343, 163);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnWatchMealTable = new JButton("Watch Meal Table");
		btnWatchMealTable.setBackground(Color.RED);
		btnWatchMealTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWatchMealTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String qurey="select * from meal";
					PreparedStatement pst=connection.prepareStatement(qurey);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception j){
					JOptionPane.showMessageDialog(null,j);
				}
			}
		});
		btnWatchMealTable.setBounds(472, 250, 156, 23);
		contentPane.add(btnWatchMealTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(361, 284, 341, 162);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.RED);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
			}
		});
		btnClear.setBounds(458, 66, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
			}
		});
		btnBack.setBounds(458, 109, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(458, 146, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblMemberId = new JLabel("Member ID :");
		lblMemberId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMemberId.setBounds(588, 70, 86, 14);
		contentPane.add(lblMemberId);
		
		textField_8 = new JTextField();
		textField_8.setBounds(588, 112, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnDelete = new JButton("Delete From Bazar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DbConector db = new DbConector(); 
					db.deleteBazar(textField_8.getText().toString());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"NO such name here");
				}
				refreashTable();
			}
		});
		btnDelete.setBackground(Color.RED);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(552, 201, 150, 23);
		contentPane.add(btnDelete);
		
		JButton btnDeletFromMeal = new JButton("Delet From Meal");
		btnDeletFromMeal.setBackground(Color.RED);
		btnDeletFromMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeletFromMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DbConector db = new DbConector(); 
					db.deleteMeal(textField_8.getText().toString());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"NO such name here");
				}
				refreashTable1();
			}
		});
		btnDeletFromMeal.setBounds(565, 169, 137, 23);
		contentPane.add(btnDeletFromMeal);
		
		JLabel lblMessManagementSystem = new JLabel("Mess Management System");
		lblMessManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMessManagementSystem.setBounds(265, 11, 237, 26);
		contentPane.add(lblMessManagementSystem);
	}
}
