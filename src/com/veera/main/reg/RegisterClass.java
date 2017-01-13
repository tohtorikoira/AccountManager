package com.veera.main.reg;

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

public class RegisterClass extends JFrame {

	public static final JPanel panel = new JPanel();
	public static final JTextField user = new JTextField();
	public static final JPasswordField pass = new JPasswordField();
	public static final JButton reg = new JButton();

	public RegisterClass() {

		this.setTitle("Register Frame");
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		reg.setPreferredSize(new Dimension(90, 50));
		reg.setText("Register");

		user.setPreferredSize(new Dimension(90, 20));
		pass.setPreferredSize(new Dimension(90, 20));
		user.setToolTipText("Username");
		pass.setToolTipText("Password");

		this.add(panel);
		panel.add(user, BorderLayout.WEST);
		panel.add(pass, BorderLayout.WEST);
		panel.add(reg, BorderLayout.CENTER);

		reg.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection conn;
					String databaseName = "tutorialData";
					String url = "jdbc:mysql://localhost/" + databaseName;
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(url, DBdetails.getDbmainuser(), DBdetails.getDbpassw());
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("SELECT * FROM user WHERE uid ='" + user.getText() + "'AND passw ='"
							+ new String(pass.getPassword()) + "'");
					System.out.println("SELECT * FROM user WHERE uid ='" + user.getText() + "'AND passw ='"
							+ new String(pass.getPassword()) + "' AND pvm = '" + LocalDate.now());
					if (res.next()) {
						if (res.getString("uid").equalsIgnoreCase(user.getText())) {
							JOptionPane.showMessageDialog(null, "Already registered!");
						}
					} else {

						java.sql.PreparedStatement resReg = conn
								.prepareStatement("INSERT INTO user (uid, passw,pvm) VALUES('" + user.getText() + "', '"
										+ new String(pass.getPassword()) + "', '" + LocalDate.now() + "')");
						System.out.println("INSERT INTO user (uid, passw,pvm) VALUES('" + user.getText() + "', '"
								+ new String(pass.getPassword()) + "', '" + LocalDate.now() + "')");
						resReg.executeUpdate();

						JOptionPane.showMessageDialog(null, "Registered username: " + user.getText());
						UserActions ua = new UserActions(user.getText());
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
