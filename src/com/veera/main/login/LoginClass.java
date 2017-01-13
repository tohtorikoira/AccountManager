package com.veera.main.login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.veera.db.DBdetails;
import com.veera.userform.UserActions;

public class LoginClass extends JFrame {

	public static final JPanel panel = new JPanel();
	public static final JTextField user = new JTextField();
	public static final JPasswordField pass = new JPasswordField();
	public static final JButton logon = new JButton();

	public LoginClass() {

		this.setTitle("Login Frame");
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		logon.setPreferredSize(new Dimension(90, 50));
		logon.setText("Login");

		user.setPreferredSize(new Dimension(90, 20));
		pass.setPreferredSize(new Dimension(90, 20));
		user.setToolTipText("Username");
		pass.setToolTipText("Password");

		this.add(panel);
		panel.add(user, BorderLayout.WEST);
		panel.add(pass, BorderLayout.WEST);
		panel.add(logon, BorderLayout.CENTER);

		logon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn;
					String databaseName = "tutorialData";
					String url = "jdbc:mysql://localhost/" + databaseName;
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(url, DBdetails.getDbmainuser(), DBdetails.getDbpassw());
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("SELECT * FROM user WHERE uid ='" + user.getText() + "'AND passw ='"
							+ pass.getText() + "'");
					System.out.println("SELECT * FROM user WHERE uid ='" + user.getText() + "'AND passw ='"
							+ pass.getText() + "'" + LocalDate.now());
					if (res.next()) {
						// JOptionPane.showMessageDialog(null, "Logged in!");
						UserActions ua = new UserActions(user.getText());
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Wrong username/password! ");
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

}
