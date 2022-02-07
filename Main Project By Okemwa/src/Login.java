import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MRB investment  ltd  login page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(74, 21, 213, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username ");
		lblNewLabel_1.setBounds(31, 68, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password ");
		lblNewLabel_2.setBounds(31, 115, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("department ");
		lblNewLabel_3.setBounds(31, 166, 78, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				try {
				String username=textField.getText();
				String password=passwordField.getText();
				if(password.contains("1234")&&username.contains("alpha")) {
					textField.setText(null);
					passwordField.setText(null);
					AddStaffAdmin frame = new AddStaffAdmin();
					frame.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"check your password and try again");
					textField.setText(null);
					passwordField.setText(null);
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(87, 191, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(154, 65, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 112, 119, 20);
		contentPane.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				String password=passwordField.getText();
				try {
				
				if(password.contains("4321")&&username.contains("alpha")) {
					
				ProductionManager frame = new ProductionManager();
					frame.setVisible(true);
					
					textField.setText(null);
					passwordField.setText(null);
			
			
				}else if(password.contains("1234")&&username.contains("alpha22")) {
					textField.setText(null);
					passwordField.setText(null);
					
					PackingManager frame = new PackingManager();
					frame.setVisible(true);
				
				}else if(password.contains("12345")&&username.contains("alpha23")){
					textField.setText(null);
					passwordField.setText(null);
					
					LogisticManager frame = new LogisticManager();
					frame.setVisible(true);
					
				}else if(password.contains("123456")&&username.contains("alpha24")) {
					
						OfficeSupervisor frame = new OfficeSupervisor();
						frame.setVisible(true);
								
					}
				
				else {
					JOptionPane.showMessageDialog(null,"check your password and try again");
					textField.setText(null);
					passwordField.setText(null);
				}
				}catch(Exception e1) {
					e1.printStackTrace();
					
				}
				
					//AddStaffAdmin frame = new AddStaffAdmin();
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
				//ProductionManager frame = new ProductionManager();
				//frame.setVisible(true);
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT POSITION HERE...", "PRODUCTION MANAGER", "PACKING MANAGER", "LOGISTICS MANAGER", "OFFICE SUPERVISOR"}));
		comboBox.setBounds(155, 162, 132, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(236, 191, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection conn=null;
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbrproject","root","");
				
				    System.out.println("database connected successfully");
				    
	                Statement st=conn.createStatement();
	                st.executeUpdate("INSERT INTO `authentication`(`username`, `password`) VALUES ('"+textField.getText()+"','"+passwordField.getText()+"')");
	                
	                System.out.print("logged in successfully");
	                st.close();
	                conn.close();
	                
				}catch(Exception e1) {
					System.out.print("db not connected to DB-ERROR:"+e1);
				}
				
				
			}
		});
		btnregister.setBounds(107, 225, 213, 23);
		contentPane.add(btnregister);
	}
}
