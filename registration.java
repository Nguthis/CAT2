
package cattwo;



import java.awt.BorderLayout;

import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JOptionPane;



import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



import javax.swing.JTextField;

import javax.swing.JButton;



@SuppressWarnings("unused")

public class registration extends JFrame {



	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField name;

	private JTextField user;

	private JTextField pass;

	private JTextField conpass;

	private JTextField email;

	private JTextField phone;

	private JTextField Address;



	/**

	 * Launch the application.

	 */

	

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					registration frame = new registration();

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

	public registration() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 500);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));



		setContentPane(contentPane);

		contentPane.setLayout(null);

		

		JLabel lblNewLabel = new JLabel("Register Form");

		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));

		lblNewLabel.setBounds(24, 23, 142, 38);

		contentPane.add(lblNewLabel);

		

		JLabel label = new JLabel("Name:");

		label.setFont(new Font("Tahoma", Font.BOLD, 13));

		label.setBounds(67, 95, 49, 14);

		contentPane.add(label);

		

		JLabel lblNewLabel_1 = new JLabel("Username:");

		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNewLabel_1.setBounds(43, 137, 73, 14);

		contentPane.add(lblNewLabel_1);

		

		JLabel lblNewLabel_2 = new JLabel("Password:");

		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNewLabel_2.setBounds(43, 173, 73, 14);

		contentPane.add(lblNewLabel_2);

		

		JLabel lblNewLabel_3 = new JLabel("Confirm Password:");

		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNewLabel_3.setBounds(10, 212, 127, 14);

		contentPane.add(lblNewLabel_3);

		

		JLabel lblNewLabel_4 = new JLabel("Email:");

		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNewLabel_4.setBounds(67, 250, 49, 14);

		contentPane.add(lblNewLabel_4);

		

		JLabel lblNewLabel_5 = new JLabel("Phone:");

		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNewLabel_5.setBounds(67, 290, 49, 14);

		contentPane.add(lblNewLabel_5);

		

		JLabel lblNewLabel_6 = new JLabel("Address:");

		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNewLabel_6.setBounds(43, 333, 73, 14);

		contentPane.add(lblNewLabel_6);

		

		name = new JTextField();

		name.setBounds(147, 93, 262, 20);

		contentPane.add(name);

		name.setColumns(10);

		

		user = new JTextField();

		user.setBounds(147, 135, 262, 20);

		contentPane.add(user);

		user.setColumns(10);

		

		pass = new JTextField();

		pass.setBounds(147, 171, 262, 20);

		contentPane.add(pass);

		pass.setColumns(10);

		

		conpass = new JTextField();

		conpass.setBounds(147, 210, 262, 20);

		contentPane.add(conpass);

		conpass.setColumns(10);

		

		email = new JTextField();

		email.setBounds(147, 248, 262, 20);

		contentPane.add(email);

		email.setColumns(10);

		

		phone = new JTextField();

		phone.setBounds(147, 288, 262, 20);

		contentPane.add(phone);

		phone.setColumns(10);

		

		Address = new JTextField();

		Address.setBounds(147, 331, 262, 20);

		contentPane.add(Address);

		Address.setColumns(10);

		

		JButton reset = new JButton("Reset");

		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				name.setText("");

				user.setText("");

				pass.setText("");

				conpass.setText("");

				email.setText("");

				phone.setText("");

				Address.setText("");

			}

		});

		reset.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));

		reset.setBounds(232, 389, 89, 23);

		contentPane.add(reset);

		

		JButton submit = new JButton("Submit");

		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cat","root","jackspurs");

					

					String sqL="INSERT INTO registration(name,username,Password,Confirmpassword,email,phone,address)VALUES(?,?,?,?,?,?,?)";

					PreparedStatement pr = con.prepareStatement(sqL);

					pr.setString(1,name.getText());

					pr.setString(2,user.getText());

					pr.setString(3,pass.getText());

					pr.setString(4,conpass.getText());

					pr.setString(5,email.getText());

					pr.setString(6,phone.getText());

					pr.setString(7,Address.getText());

					int count = pr.executeUpdate();

					if(count ==1) {

						JOptionPane.showMessageDialog(null,"Record added successfully");

						con.close();

					}

					else {

						JOptionPane.showMessageDialog(null,"No record added");

						con.close();

					}

					

				}catch(Exception e1) {

				

				}

			}



			

		});

		submit.setFont(new Font("Tahoma", Font.BOLD, 13));

		submit.setBounds(122, 390, 89, 23);

		contentPane.add(submit);

		

		JButton close = new JButton("Close");

		close.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

			System.exit(0);

		}}

		);

		close.setFont(new Font("Tahoma", Font.BOLD, 13));

		close.setBounds(337, 390, 89, 23);

		contentPane.add(close);

	}

}