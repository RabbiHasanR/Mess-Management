package com.project.mess2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
public class Account extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTable table;
	private JTextField textField_15;
	double costPerMember;
    Connection connection=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account frame = new Account();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	   public void refreashTable(){
		   try{
				String qurey="select * from payment";
				PreparedStatement pst=connection.prepareStatement(qurey);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
		   
	   }

	/**
	 * Create the frame.
	 */
	public Account() {
		connection=DbConector.dbConector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 494);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFlatRant = new JLabel("Flat Rant :");
		lblFlatRant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFlatRant.setBounds(32, 87, 75, 14);
		contentPane.add(lblFlatRant);
		
		JLabel lblEatAmount = new JLabel("Eat Cost :");
		lblEatAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEatAmount.setBounds(32, 121, 75, 14);
		contentPane.add(lblEatAmount);
		
		JLabel lblCurrentBill = new JLabel("Current Bill :");
		lblCurrentBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentBill.setBounds(32, 163, 75, 14);
		contentPane.add(lblCurrentBill);
		
		JLabel lblMaidCost = new JLabel("Maid Cost :");
		lblMaidCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaidCost.setBounds(32, 203, 75, 14);
		contentPane.add(lblMaidCost);
		
		JLabel lblOtherCost = new JLabel("Other Cost :");
		lblOtherCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOtherCost.setBounds(10, 239, 97, 14);
		contentPane.add(lblOtherCost);
		
		textField = new JTextField();
		textField.setBounds(117, 84, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 118, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 160, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 200, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(117, 236, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnTotal = new JButton("Calculation");
		btnTotal.setBackground(Color.RED);
		btnTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				double flatRant=Double.parseDouble(textField.getText());
				double eatCost=Double.parseDouble(textField_1.getText());
				double currentBill=Double.parseDouble(textField_2.getText());
				double maidCost=Double.parseDouble(textField_3.getText());
				double othersCost=Double.parseDouble(textField_4.getText());
				AccountCalculation ac=new AccountCalculation(flatRant,eatCost,currentBill,maidCost,othersCost);
				textField_5.setText(String.valueOf(AccountCalculation.calcultion()));
				}
				catch(Exception f){
					JOptionPane.showMessageDialog(null,"Please Enter Number Value");
				}
				try{
					String query="select count(ID)from member";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					if(rs.next()){
						String sum=rs.getString("count(ID)");
						int totalMember=Integer.parseInt(sum);
						textField_6.setText(sum);
                        costPerMember=AccountCalculation.calcultion()/totalMember;
                        textField_15.setText(String.valueOf(costPerMember));
					}
				}
				catch(Exception s){
					JOptionPane.showMessageDialog(null,s);
					
				}
			}
		});
		btnTotal.setBounds(71, 280, 103, 23);
		contentPane.add(btnTotal);
		
		JLabel lblTotalCost = new JLabel("Total Cost :");
		lblTotalCost.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalCost.setBounds(32, 314, 75, 14);
		contentPane.add(lblTotalCost);
		
		textField_5 = new JTextField();
		textField_5.setBounds(117, 311, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCostOfPer = new JLabel("Cost of Per Member :");
		lblCostOfPer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCostOfPer.setBounds(0, 381, 123, 14);
		contentPane.add(lblCostOfPer);
		
		textField_6 = new JTextField();
		textField_6.setBounds(117, 353, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblBudgetCalcultion = new JLabel("Budget Calcultion");
		lblBudgetCalcultion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBudgetCalcultion.setBounds(45, 44, 158, 23);
		contentPane.add(lblBudgetCalcultion);
		
		JLabel lblPaymentBord = new JLabel("Payment Bord");
		lblPaymentBord.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPaymentBord.setBounds(253, 44, 136, 23);
		contentPane.add(lblPaymentBord);
		
		JLabel lblMemberName = new JLabel("Member ID :");
		lblMemberName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMemberName.setBounds(263, 87, 79, 14);
		contentPane.add(lblMemberName);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(296, 121, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmount.setBounds(274, 163, 68, 14);
		contentPane.add(lblAmount);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBackground(Color.RED);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DbConector db = new DbConector();
				try{
				db.addMemberInformationPayment(textField_7.getText().toString(),textField_8.getText().toString(),textField_9.getText().toString(),textField_15.getText().toString());	
				}
				catch(Exception e){
					e.printStackTrace();
				}
				refreashTable();
			}
		});
		btnSave.setBounds(253, 199, 89, 23);
		contentPane.add(btnSave);
		
		textField_7 = new JTextField();
		textField_7.setBounds(352, 84, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(352, 118, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(352, 160, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblMemberProfile = new JLabel("Member Profile");
		lblMemberProfile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMemberProfile.setBounds(503, 44, 134, 20);
		contentPane.add(lblMemberProfile);
		
		JLabel lblMemberName_1 = new JLabel("Member ID:");
		lblMemberName_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMemberName_1.setBounds(459, 87, 75, 14);
		contentPane.add(lblMemberName_1);
		
		textField_10 = new JTextField();
		textField_10.setBounds(551, 84, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblTotalPaid = new JLabel("Total Paid :");
		lblTotalPaid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalPaid.setBounds(471, 121, 75, 14);
		contentPane.add(lblTotalPaid);
		
		JLabel lblTotalPay = new JLabel("Total Pay :");
		lblTotalPay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalPay.setBounds(471, 146, 75, 20);
		contentPane.add(lblTotalPay);
		
		JLabel lblTotalDiu = new JLabel("Total Du :");
		lblTotalDiu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalDiu.setBounds(471, 177, 75, 14);
		contentPane.add(lblTotalDiu);
		
		textField_11 = new JTextField();
		textField_11.setBounds(551, 118, 86, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(551, 143, 86, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(551, 174, 86, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(536, 200, 86, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		JLabel lblName = new JLabel("Member ID :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(448, 206, 78, 14);
		contentPane.add(lblName);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.RED);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	try{
					
					String qurey="select * from payment where member_id = ?	 ";
					PreparedStatement pst=connection.prepareStatement(qurey);
					pst.setString(1,textField_14.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next()){
						String add1=rs.getString("member_id");
						textField_10.setText(add1);
						String add2=rs.getString("budget");
						textField_11.setText(add2);
						String add3=rs.getString("paid");
						textField_12.setText(add3);
						
						double due = Double.parseDouble(add2) - Double.parseDouble(add3); 
						textField_13.setText(String.valueOf(due));
					
						
					}
					else{
						JOptionPane.showMessageDialog(null,"Not Found");
					}
					
					
				}
				catch(Exception f){
					JOptionPane.showMessageDialog(null,f);
				}
          
			}
			});
		btnSearch.setBounds(632, 199, 78, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 263, 517, 181);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnWatchPymentBord = new JButton("Watch Pyment Bord");
		btnWatchPymentBord.setBackground(Color.RED);
		btnWatchPymentBord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String qurey="select * from payment";
					PreparedStatement pst=connection.prepareStatement(qurey);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		btnWatchPymentBord.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWatchPymentBord.setBounds(344, 235, 189, 23);
		contentPane.add(btnWatchPymentBord);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(Color.RED);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
			}
		});
		btnBack.setBounds(10, 408, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnClear = new JButton("Clear");
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
				textField_8.setText(null);
				textField_9.setText(null);
				textField_10.setText(null);
				textField_11.setText(null);
				textField_12.setText(null);
				textField_13.setText(null);
				textField_14.setText(null);
				textField_15.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBackground(Color.RED);
		btnClear.setBounds(114, 408, 89, 23);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Total Member :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 356, 97, 14);
		contentPane.add(lblNewLabel);
		
		textField_15 = new JTextField();
		textField_15.setBounds(127, 379, 86, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DbConector db = new DbConector(); 
					db.deleteMemberFromPayment(textField_14.getText().toString());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"NO such name here");
				}
				refreashTable();
			}
		});
		btnDelete.setBounds(632, 231, 78, 23);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("Mess Management System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(290, 11, 256, 23);
		contentPane.add(lblNewLabel_1);
	}
}
