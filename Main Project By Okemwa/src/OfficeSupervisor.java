import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class OfficeSupervisor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficeSupervisor frame = new OfficeSupervisor();
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
	public OfficeSupervisor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Office Supervisor Add Staff");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(99, 11, 199, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Staff Id");
		lblNewLabel_1.setBounds(34, 39, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Staff Name");
		lblNewLabel_2.setBounds(34, 76, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(34, 101, 78, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(34, 137, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address ");
		lblNewLabel_5.setBounds(34, 162, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(122, 36, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Customer ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer frame = new AddCustomer();
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 227, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection conn=null;
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbrproject","root","");
					
				    System.out.println("database connected ");
				    
	                Statement st=conn.createStatement();
	               // st.executeUpdate("INSERT INTO `staffdetails`(`staff Id`, `staff name`,'phone number','Email','Address') VALUES ('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"')");
	               st.executeUpdate("INSERT INTO `supervisor`(`staff Id`, `staff name`, `phone number`, `Email`, `Address`) VALUES ('"+textField.getText()+"','"+textField_1.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"')");
	         //INSERT INTO `office supervisor table`(`staff Id`, `staff name`, `phone number`, `Email`, `Address`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]')
	                st.close();
	                conn.close();
	                
				}catch(Exception e1) {
					System.out.print("db not connected to DB-ERROR:"+e1);
				}
				
			}
		});
		btnNewButton_1.setBounds(10, 193, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(new String[]{});
				dispose();
			}
		});
		btnNewButton_2.setBounds(122, 227, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(122, 193, 89, 23);
		contentPane.add(btnNewButton_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 67, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 98, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 134, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(122, 159, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Payroll");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payroll frame = new payroll();
				frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(63, 261, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Show Office Staff");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection conn=null;
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mbrproject","root","");
					
				    System.out.println("database connected ");
				    String query="SELECT * FROM ` supervisor` WHERE staff Id =?";
				    PreparedStatement pst=conn.prepareStatement(query);
				    ResultSet rs=pst.executeQuery();
				    table.setModel(DbUtils.resultSetToTableModel(rs));
				    
	                
	                conn.close();
	                
				}catch(Exception e1) {
					System.out.print("db not connected to DB-ERROR:"+e1);
				}
			
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_5.setBounds(339, 261, 238, 23);
		contentPane.add(btnNewButton_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 39, 385, 211);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("Staffs Details ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(378, 12, 89, 14);
		contentPane.add(lblNewLabel_6);
	}
}
