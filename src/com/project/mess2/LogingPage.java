package com.project.mess2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class LogingPage {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogingPage window = new LogingPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogingPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 550, 277);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(276, 63, 104, 20);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(276, 97, 104, 20);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(390, 66, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLoging = new JButton("Loging");
		btnLoging.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Image img=new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		btnLoging.setIcon(new ImageIcon(img));
		btnLoging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String username=textField.getText();
					String password=passwordField.getText();
					
					if(username.equals("Rabbi")&& password.equals("12345")){
						JOptionPane.showMessageDialog(null,"Loging Succesfully");
						frame.dispose();
						HomePage hp=new HomePage();
						hp.setVisible(true);
					}
					else if(username.equals("")&& password.equals("")){
						JOptionPane.showMessageDialog(null,"Please give username and password");
					}
					else{
						JOptionPane.showMessageDialog(null,"Username and Password incorrect.Try Again");
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
					
				}
			}
		});
		btnLoging.setBounds(261, 146, 136, 41);
		frame.getContentPane().add(btnLoging);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(420, 147, 89, 38);
		frame.getContentPane().add(btnExit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(390, 100, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/Login1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(10, 11, 256, 205);
		frame.getContentPane().add(lblNewLabel);
	}
}
