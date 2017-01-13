package com.veera.main;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.veera.main.login.LoginClass;
import com.veera.main.reg.RegisterClass;

public class Main extends JFrame {
	
	public static JButton login = new JButton();
	public static JButton register = new JButton();
	public static Dimension buttonsize = new Dimension(100, 50);
	
	
	public static JPanel panel = new JPanel();
	
	public Main() {
		
		this.setTitle("Main Frame");
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		login.setPreferredSize(buttonsize);
		register.setPreferredSize(buttonsize);
		login.setText("Login");
		register.setText("Register"); 
		
		this.add(panel);
		panel.add(login);
		panel.add(register);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoginClass lc = new LoginClass();
				dispose();
				
			}
		});
		
		register.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				RegisterClass rc = new RegisterClass();
				dispose();
				
			}
		});
	}
	
	
	
	
	public static void main(String argd[]){
		
		Main m = new Main();
		
	}

}
