package com.project.mess2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 349);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMemberInformation = new JButton("Member Information");
		btnMemberInformation.setForeground(Color.WHITE);
		btnMemberInformation.setBackground(Color.RED);
		btnMemberInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMemberInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemberInformation mi=new MemberInformation();
				mi.setVisible(true);
			}
		});
		btnMemberInformation.setBounds(45, 75, 164, 29);
		contentPane.add(btnMemberInformation);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.setForeground(Color.WHITE);
		btnAccount.setBackground(Color.RED);
		btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Account a=new Account();
				a.setVisible(true);
			}
		});
		btnAccount.setBounds(45, 124, 89, 29);
		contentPane.add(btnAccount);
		
		JButton btnMillManagement = new JButton("Mill Management");
		btnMillManagement.setForeground(Color.WHITE);
		btnMillManagement.setBackground(Color.RED);
		btnMillManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMillManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MillManagement mm=new MillManagement();
				mm.setVisible(true);
			}
		});
		btnMillManagement.setBounds(45, 178, 155, 29);
		contentPane.add(btnMillManagement);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(45, 260, 89, 29);
		contentPane.add(btnExit);
		
		JButton btnMonthReport = new JButton("Month Report");
		btnMonthReport.setForeground(Color.WHITE);
		btnMonthReport.setBackground(Color.RED);
		btnMonthReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMonthReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonthReport mr=new MonthReport();
				mr.setVisible(true);
				mr.totalMeal();
				mr.totalBazarCost();
				mr.mealRate();
			}
		});
		btnMonthReport.setBounds(45, 218, 134, 29);
		contentPane.add(btnMonthReport);
		
		JLabel lblNewLabel = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(255, 44, 276, 255);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mess Management System");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(101, 11, 243, 29);
		contentPane.add(lblNewLabel_1);
	}
}
