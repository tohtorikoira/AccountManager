package com.veera.userform;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.veera.db.Add;
import com.veera.db.DBdetails;

public class UserActions extends JFrame {

	public static JFrame frame = new JFrame();

	public static final JButton reg = new JButton();

	private JLabel labelSumma = new JLabel("Summa: ");
	private JLabel labelSelite = new JLabel("Selite: ");
	private JLabel labelTapahtuma = new JLabel("Selite: ");

	private JButton buttonAdd = new JButton("Lis‰‰");
	private JComboBox<String> tapahtuma = new JComboBox();
	private JTextField summa = new JTextField(30);
	private JTextArea selite = new JTextArea(5, 30);
	private JLabel hello = new JLabel();
	private static GridBagConstraints constraints = new GridBagConstraints();
	private static JPanel newPanel = new JPanel(new GridBagLayout());;
	public static JTextArea textAreaTapahtumat = new JTextArea(30, 30);
	public static int total;
	public static JLabel totalSumma = new JLabel(Integer.toString(total));

	JScrollPane sp = new JScrollPane();

	public static void update(String username) {
		textAreaTapahtumat.setText(null);

		try {
			Connection conn;
			String databaseName = "tutorialData";
			String url = "jdbc:mysql://localhost/" + databaseName;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, DBdetails.getDbmainuser(), DBdetails.getDbpassw());
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM accountactions WHERE uid ='" + username + "'");
			ResultSetMetaData rsmd = res.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			int counter = 0;
			int counterLines = 0;
			textAreaTapahtumat.append("K‰ytt‰j‰ Tapahtuma Summa Selite\n");
			while (res.next()) {
				if (counterLines < 15) {

					for (int i = 1; i < columnsNumber + 1; i++) {
						counter++;
						textAreaTapahtumat.append(res.getString(i) + " ");
						System.out.println(res.getString(i));
						if (counter == 3) {
							System.out.println("total " + Integer.parseInt(res.getString(i)));
							total = total + Integer.parseInt(res.getString(i));
						}

						if (counter == 4) {
							textAreaTapahtumat.append("\n");
							counterLines++;
							counter = 0;
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		constraints.gridx = 0;
		constraints.gridy = 8;
		newPanel.add(new JLabel("Total:"), constraints);
		constraints.gridx = 1;
		constraints.gridy = 8;
		newPanel.add(totalSumma, constraints);
		totalSumma.setText(Integer.toString(total));

	}

	public UserActions(String username) {

		// TODO Auto-generated constructor stub
		super("Lis‰‰ tapahtuma");
		this.setVisible(true);
		this.setSize(1000, 1000);
		update(username);
		frame.add(sp);
		frame.add(newPanel);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		hello.setText("Hello " + username);

		sp.add(newPanel);

		constraints.gridx = 1;
		constraints.gridy = 1;
		newPanel.add(hello, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		newPanel.add(labelSumma, constraints);

		constraints.gridx = 1;
		constraints.gridy = 2;
		newPanel.add(summa, constraints);

		add(newPanel);

		constraints.gridx = 1;
		constraints.gridy = 2;
		newPanel.add(summa, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		newPanel.add(labelSelite, constraints);

		constraints.gridx = 1;
		newPanel.add(selite, constraints);

		tapahtuma.addItem("Osto");
		tapahtuma.addItem("Pano");

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(tapahtuma, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(buttonAdd, constraints);

		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(textAreaTapahtumat, constraints);

		buttonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Add add = new Add(username, summa.getText(), tapahtuma.getSelectedItem().toString(), selite.getText());
				summa.setText(null);
				selite.setText(null);
				total = 0;
				totalSumma.setText(null);
				update(username);

			}
		});

		setLocationRelativeTo(null);

	}

}
