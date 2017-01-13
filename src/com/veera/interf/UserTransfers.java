// package com.veera.interf;
//
// import java.awt.BorderLayout;
// import java.awt.EventQueue;
//
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.border.EmptyBorder;
// import java.awt.GridBagLayout;
// import javax.swing.JTextField;
// import java.awt.GridBagConstraints;
// import java.awt.Insets;
// import javax.swing.JLabel;
// import javax.swing.JComboBox;
// import java.awt.Font;
// import java.awt.GraphicsConfiguration;
//
// import javax.swing.JButton;
// import javax.swing.JTable;
// import javax.swing.JTextArea;
//
// public class UserTransfers extends JFrame {
//
// private JPanel contentPane;
// private JTextField txtSumma;
// private JTextField txtTapahtuma;
// private JTextField txtSelite;
// private JLabel lblSumma;
// private JComboBox comboBox;
// private JLabel lblHei;
// private JLabel lblLisTapahtuma;
// private JButton btnLis;
// private JLabel lblTapahtuma;
// public static JTextArea textAreaTapahtumat;
//
// /**
// * Launch the application.
// */
// public static void main(String[] args) {
// EventQueue.invokeLater(new Runnable() {
// public void run() {
// try {
// UserTransfers frame = new UserTransfers();
// frame.setVisible(true);
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// });
// }
//
// /**
// * Create the frame.
// */
// public UserTransfers() {
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setBounds(100, 100, 450, 496);
// contentPane = new JPanel();
// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
// setContentPane(contentPane);
// GridBagLayout gbl_contentPane = new GridBagLayout();
// gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
// gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
// gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
// Double.MIN_VALUE};
// gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
// 0.0, 0.0, 1.0, Double.MIN_VALUE};
// contentPane.setLayout(gbl_contentPane);
//
// lblHei = new JLabel("Hei, !");
// GridBagConstraints gbc_lblHei = new GridBagConstraints();
// gbc_lblHei.insets = new Insets(0, 0, 5, 5);
// gbc_lblHei.gridx = 4;
// gbc_lblHei.gridy = 0;
// contentPane.add(lblHei, gbc_lblHei);
//
// lblLisTapahtuma = new JLabel("Lis\u00E4\u00E4 tapahtuma");
// lblLisTapahtuma.setFont(new Font("Tahoma", Font.BOLD, 11));
// GridBagConstraints gbc_lblLisTapahtuma = new GridBagConstraints();
// gbc_lblLisTapahtuma.insets = new Insets(0, 0, 5, 5);
// gbc_lblLisTapahtuma.gridx = 4;
// gbc_lblLisTapahtuma.gridy = 1;
// contentPane.add(lblLisTapahtuma, gbc_lblLisTapahtuma);
//
// lblSumma = new JLabel("Summa:");
// GridBagConstraints gbc_lblSumma = new GridBagConstraints();
// gbc_lblSumma.anchor = GridBagConstraints.EAST;
// gbc_lblSumma.insets = new Insets(0, 0, 5, 5);
// gbc_lblSumma.gridx = 4;
// gbc_lblSumma.gridy = 2;
// contentPane.add(lblSumma, gbc_lblSumma);
//
// txtSumma = new JTextField();
// GridBagConstraints gbc_txtSumma = new GridBagConstraints();
// gbc_txtSumma.insets = new Insets(0, 0, 5, 0);
// gbc_txtSumma.anchor = GridBagConstraints.WEST;
// gbc_txtSumma.gridx = 5;
// gbc_txtSumma.gridy = 2;
// contentPane.add(txtSumma, gbc_txtSumma);
// txtSumma.setColumns(10);
//
// comboBox = new JComboBox();
// GridBagConstraints gbc_comboBox = new GridBagConstraints();
// gbc_comboBox.anchor = GridBagConstraints.EAST;
// gbc_comboBox.insets = new Insets(0, 0, 5, 5);
// gbc_comboBox.gridx = 4;
// gbc_comboBox.gridy = 3;
// contentPane.add(comboBox, gbc_comboBox);
//
// txtTapahtuma = new JTextField();
// GridBagConstraints gbc_txtTapahtuma = new GridBagConstraints();
// gbc_txtTapahtuma.anchor = GridBagConstraints.WEST;
// gbc_txtTapahtuma.insets = new Insets(0, 0, 5, 0);
// gbc_txtTapahtuma.gridx = 5;
// gbc_txtTapahtuma.gridy = 3;
// contentPane.add(txtTapahtuma, gbc_txtTapahtuma);
// txtTapahtuma.setColumns(10);
//
// JLabel lblSelite = new JLabel("Selite:");
// GridBagConstraints gbc_lblSelite = new GridBagConstraints();
// gbc_lblSelite.anchor = GridBagConstraints.EAST;
// gbc_lblSelite.insets = new Insets(0, 0, 5, 5);
// gbc_lblSelite.gridx = 4;
// gbc_lblSelite.gridy = 4;
// contentPane.add(lblSelite, gbc_lblSelite);
//
// txtSelite = new JTextField();
// GridBagConstraints gbc_txtSelite = new GridBagConstraints();
// gbc_txtSelite.anchor = GridBagConstraints.WEST;
// gbc_txtSelite.insets = new Insets(0, 0, 5, 0);
// gbc_txtSelite.gridx = 5;
// gbc_txtSelite.gridy = 4;
// contentPane.add(txtSelite, gbc_txtSelite);
// txtSelite.setColumns(10);
//
// btnLis = new JButton("Lis\u00E4\u00E4:");
// GridBagConstraints gbc_btnLis = new GridBagConstraints();
// gbc_btnLis.insets = new Insets(0, 0, 5, 5);
// gbc_btnLis.gridx = 4;
// gbc_btnLis.gridy = 6;
// contentPane.add(btnLis, gbc_btnLis);
//
// lblTapahtuma = new JLabel("Tapahtuma");
// GridBagConstraints gbc_lblTapahtuma = new GridBagConstraints();
// gbc_lblTapahtuma.insets = new Insets(0, 0, 5, 5);
// gbc_lblTapahtuma.gridx = 4;
// gbc_lblTapahtuma.gridy = 7;
// contentPane.add(lblTapahtuma, gbc_lblTapahtuma);
//
// textAreaTapahtumat = new JTextArea();
// GridBagConstraints gbc_textArea = new GridBagConstraints();
// gbc_textArea.gridwidth = 4;
// gbc_textArea.insets = new Insets(0, 0, 0, 5);
// gbc_textArea.fill = GridBagConstraints.BOTH;
// gbc_textArea.gridx = 2;
// gbc_textArea.gridy = 9;
// contentPane.add(textAreaTapahtumat, gbc_textArea);
// }
//
// public UserTransfers(String username) {
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setBounds(100, 100, 450, 300);
// contentPane = new JPanel();
// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
// setContentPane(contentPane);
// GridBagLayout gbl_contentPane = new GridBagLayout();
// gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
// gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
// gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
// Double.MIN_VALUE};
// gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
// 0.0, 0.0, 1.0, Double.MIN_VALUE};
// contentPane.setLayout(gbl_contentPane);
//
// lblHei = new JLabel("Hei, "+username+ "!");
// GridBagConstraints gbc_lblHei = new GridBagConstraints();
// gbc_lblHei.insets = new Insets(0, 0, 5, 5);
// gbc_lblHei.gridx = 4;
// gbc_lblHei.gridy = 0;
// contentPane.add(lblHei, gbc_lblHei);
//
// lblLisTapahtuma = new JLabel("Lis\u00E4\u00E4 tapahtuma");
// lblLisTapahtuma.setFont(new Font("Tahoma", Font.BOLD, 11));
// GridBagConstraints gbc_lblLisTapahtuma = new GridBagConstraints();
// gbc_lblLisTapahtuma.insets = new Insets(0, 0, 5, 5);
// gbc_lblLisTapahtuma.gridx = 4;
// gbc_lblLisTapahtuma.gridy = 1;
// contentPane.add(lblLisTapahtuma, gbc_lblLisTapahtuma);
//
// lblSumma = new JLabel("Summa:");
// GridBagConstraints gbc_lblSumma = new GridBagConstraints();
// gbc_lblSumma.anchor = GridBagConstraints.EAST;
// gbc_lblSumma.insets = new Insets(0, 0, 5, 5);
// gbc_lblSumma.gridx = 4;
// gbc_lblSumma.gridy = 2;
// contentPane.add(lblSumma, gbc_lblSumma);
//
// txtSumma = new JTextField();
// GridBagConstraints gbc_txtSumma = new GridBagConstraints();
// gbc_txtSumma.insets = new Insets(0, 0, 5, 0);
// gbc_txtSumma.anchor = GridBagConstraints.WEST;
// gbc_txtSumma.gridx = 5;
// gbc_txtSumma.gridy = 2;
// contentPane.add(txtSumma, gbc_txtSumma);
// txtSumma.setColumns(10);
//
// comboBox = new JComboBox();
// GridBagConstraints gbc_comboBox = new GridBagConstraints();
// gbc_comboBox.anchor = GridBagConstraints.EAST;
// gbc_comboBox.insets = new Insets(0, 0, 5, 5);
// gbc_comboBox.gridx = 4;
// gbc_comboBox.gridy = 3;
// contentPane.add(comboBox, gbc_comboBox);
//
// txtTapahtuma = new JTextField();
// GridBagConstraints gbc_txtTapahtuma = new GridBagConstraints();
// gbc_txtTapahtuma.anchor = GridBagConstraints.WEST;
// gbc_txtTapahtuma.insets = new Insets(0, 0, 5, 0);
// gbc_txtTapahtuma.gridx = 5;
// gbc_txtTapahtuma.gridy = 3;
// contentPane.add(txtTapahtuma, gbc_txtTapahtuma);
// txtTapahtuma.setColumns(10);
//
// JLabel lblSelite = new JLabel("Selite:");
// GridBagConstraints gbc_lblSelite = new GridBagConstraints();
// gbc_lblSelite.anchor = GridBagConstraints.EAST;
// gbc_lblSelite.insets = new Insets(0, 0, 5, 5);
// gbc_lblSelite.gridx = 4;
// gbc_lblSelite.gridy = 4;
// contentPane.add(lblSelite, gbc_lblSelite);
//
// txtSelite = new JTextField();
// GridBagConstraints gbc_txtSelite = new GridBagConstraints();
// gbc_txtSelite.anchor = GridBagConstraints.WEST;
// gbc_txtSelite.insets = new Insets(0, 0, 5, 0);
// gbc_txtSelite.gridx = 5;
// gbc_txtSelite.gridy = 4;
// contentPane.add(txtSelite, gbc_txtSelite);
// txtSelite.setColumns(10);
//
// btnLis = new JButton("Lis\u00E4\u00E4:");
// GridBagConstraints gbc_btnLis = new GridBagConstraints();
// gbc_btnLis.insets = new Insets(0, 0, 5, 5);
// gbc_btnLis.gridx = 4;
// gbc_btnLis.gridy = 6;
// contentPane.add(btnLis, gbc_btnLis);
//
// lblTapahtuma = new JLabel("Tapahtuma");
// GridBagConstraints gbc_lblTapahtuma = new GridBagConstraints();
// gbc_lblTapahtuma.insets = new Insets(0, 0, 5, 5);
// gbc_lblTapahtuma.gridx = 4;
// gbc_lblTapahtuma.gridy = 7;
// contentPane.add(lblTapahtuma, gbc_lblTapahtuma);
//
//// table = new JTable();
// textAreaTapahtumat = new JTextArea();
// GridBagConstraints gbc_table = new GridBagConstraints();
// gbc_table.insets = new Insets(0, 0, 0, 5);
// gbc_table.fill = GridBagConstraints.BOTH;
// gbc_table.gridx = 4;
// gbc_table.gridy = 9;
// contentPane.add(textAreaTapahtumat, gbc_table);
// }
//
// }
