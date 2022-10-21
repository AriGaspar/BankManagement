package Bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LogIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private static Scanner sc;
	private static String user, pwd;
	private JPasswordField txtPassword;
	List<User> users = new ArrayList<User>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Checking( String name , String password ) {
		
		StoreFileIntoUsers();
		boolean foundIt = false;
		
		for (int i = 0 ; i < users.toArray().length ; i++) {
			if (users.get(i).name.equals( name ) && users.get(i).password.equals( password)  ) {
				foundIt = true;
			}
		}
		
		if ( foundIt ) {
			System.out.println( "Login!");
		}else {
			System.out.println( "No coincidence founded" );
		}
	
	}
	
	public void StoreFileIntoUsers() {
		List<String> fileString = getFileIntoString();
		String[] fArray = fileString.toArray(String[]::new);
		
		for (int i = 0; i < fArray.length; i++) {
			String name , pass;
			
			if ( fArray[i].contains("user:") ) {
				name = fArray[i].substring( 5 );
				
				if ( (i+1) < fArray.length ) {//Check if password (next line) exists
					if ( fArray[i+1].contains("password:") ) {//Check if it is really "password"
						pass = fArray[i+1].substring(9);
						User s = new User(name , pass);
						users.add( s );
					}
				}
			}
		}
	}
	
	public List<String> getFileIntoString(){
		List<String> result = new ArrayList<>();
		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader("users.txt"));

			String line;
			while ((line = br.readLine()) != null) {
				result.add(line);
//				System.out.println( line );
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	


	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bank Management Log In\r\n");
		lblNewLabel.setBounds(116, 11, 197, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User:");
		lblNewLabel_1.setBounds(31, 75, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(31, 114, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Checking( txtUser.getText() , txtPassword.getText() ); 
			}
		});
		btnNewButton.setBounds(141, 165, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Need an Account? Click here");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {			
			public void mouseClicked(MouseEvent e) {
				CreateUser open = new CreateUser(); 
				open.setVisible(true);
			}
		});
		lblNewLabel_3.setBounds(106, 215, 207, 14);
		contentPane.add(lblNewLabel_3);
		
		txtUser = new JTextField();
		txtUser.setBounds(116, 72, 147, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(116, 111, 147, 20);
		contentPane.add(txtPassword);
	}
}
