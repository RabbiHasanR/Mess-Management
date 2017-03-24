package com.project.mess2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
public class MemberInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldOccuption;
	private JTextField textFieldSex;
	private JTextField etSearchID;
	Connection connection=null;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInformation frame = new MemberInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

   public void refreashTable(){
	   try{
			String qurey="select * from member";
			PreparedStatement pst=connection.prepareStatement(qurey);
			ResultSet rs=pst.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	   
   }
	/**
	 * Create the frame.
	 */
	public MemberInformation() {
		connection=DbConector.dbConector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 80, 52, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEamil = new JLabel("Eamil :");
		lblEamil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEamil.setBounds(39, 122, 46, 14);
		contentPane.add(lblEamil);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(18, 162, 67, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(33, 204, 52, 14);
		contentPane.add(lblPhone);
		
		JLabel lblOccuption = new JLabel("Occuption :");
		lblOccuption.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOccuption.setBounds(33, 255, 74, 14);
		contentPane.add(lblOccuption);
		
		JLabel lblSex = new JLabel("Sex :");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSex.setBounds(39, 299, 46, 14);
		contentPane.add(lblSex);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(95, 77, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(95, 119, 86, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(95, 159, 86, 20);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(95, 201, 86, 20);
		contentPane.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		textFieldOccuption = new JTextField();
		textFieldOccuption.setBounds(105, 252, 86, 20);
		contentPane.add(textFieldOccuption);
		textFieldOccuption.setColumns(10);
		
		textFieldSex = new JTextField();
		textFieldSex.setBounds(105, 296, 86, 20);
		contentPane.add(textFieldSex);
		textFieldSex.setColumns(10);
		
		JButton btnAddInformation = new JButton("Add Information");
		btnAddInformation.setForeground(Color.BLACK);
		btnAddInformation.setBackground(Color.RED);
		btnAddInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DbConector db = new DbConector(); 
				try {
					db.addMemberInformation(textFieldName.getText().toString(), textFieldEmail.getText().toString(),textFieldAddress.getText().toString(),
							textFieldPhone.getText().toString(), textFieldOccuption.getText().toString(), textFieldSex.getText().toString());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				refreashTable();
			}
		});
		btnAddInformation.setBounds(10, 353, 136, 23);
		contentPane.add(btnAddInformation);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(Color.RED);
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldName.setText(null);
				textFieldEmail.setText(null);
				textFieldAddress.setText(null);
				textFieldPhone.setText(null);
				textFieldOccuption.setText(null);
				textFieldSex.setText(null);
				etSearchID.setText(null);
				
			}
		});
		btnClear.setBounds(156, 353, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnShow = new JButton("Show All Member Data");
		btnShow.setBackground(Color.RED);
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String qurey="select * from member";
					PreparedStatement pst=connection.prepareStatement(qurey);
					ResultSet rs=pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnShow.setBounds(360, 66, 176, 23);
		contentPane.add(btnShow);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.RED);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String qurey="select * from member where ID=? ";
					PreparedStatement pst=connection.prepareStatement(qurey);
					pst.setString(1,etSearchID.getText());
					//pst.setString(1,etSearchID.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next()){
						String add1=rs.getString("member_name");
						textFieldName.setText(add1);
						String add2=rs.getString("member_email");
						textFieldEmail.setText(add2);
						String add3=rs.getString("member_address");
						textFieldAddress.setText(add3);
						String add4=rs.getString("member_phone");
						textFieldPhone.setText(add4);
						String add5=rs.getString("member_occuption");
						textFieldOccuption.setText(add5);
						String add6=rs.getString("sex");
						textFieldSex.setText(add6);
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
		btnSearch.setBounds(542, 353, 89, 23);
		contentPane.add(btnSearch);
		
		etSearchID = new JTextField();
		etSearchID.setBounds(438, 354, 86, 20);
		contentPane.add(etSearchID);
		etSearchID.setColumns(10);
		
		JLabel lblName = new JLabel("Name Or ID:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(347, 357, 81, 14);
		contentPane.add(lblName);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.RED);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DbConector db = new DbConector(); 
					db.deleteMember(etSearchID.getText().toString());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"NO such name here");
				}
				refreashTable();
			
			}
		});
		btnDelete.setBounds(542, 387, 89, 23);
		contentPane.add(btnDelete);
		
		table = new JTable();
		table.setBounds(317, 327, 318, -204);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(347, 327, 291, -204);
		contentPane.add(table_1);
		
		JScrollPane showTable = new JScrollPane();
		showTable.setBounds(201, 100, 507, 245);
		contentPane.add(showTable);
		
		table_2 = new JTable();
		showTable.setViewportView(table_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp=new HomePage();
				hp.setVisible(true);
			}
		});
		btnBack.setBounds(18, 387, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Mess Management System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(246, 11, 249, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBounds(156, 387, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="update member set member_name='"+textFieldName.getText() +"' ,member_email='"+textFieldEmail.getText() +"' ,member_address='"+textFieldAddress.getText() +"' ,member_phone='"+textFieldPhone.getText() +"' ,member_occuption='"+textFieldOccuption.getText() +"' ,sex='"+textFieldSex.getText() +"' where ID='"+etSearchID.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null,"Data Update");
					pst.close();
				}
				catch(Exception i){
					JOptionPane.showMessageDialog(null,"Data not Update");
					
				}
				refreashTable();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBackground(Color.RED);
		btnUpdate.setBounds(435, 389, 89, 23);
		contentPane.add(btnUpdate);
		//refreashTable();
	}
}
