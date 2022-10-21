package Bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;

	public CreateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder(5, 5, 5, 5) );

		setContentPane(contentPane);
		contentPane.setLayout( null );
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUser.getText();
				String password = txtPassword.getText();
				Add(username, password);
				dispose();
			}
		});

		btnNewButton.setBounds(165, 172, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setBounds(54, 61, 46, 14);
		contentPane.add( lblNewLabel );
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(54, 100, 46, 14);
		contentPane.add( lblNewLabel_1 );
		
		txtUser = new JTextField();
		txtUser.setBounds(153, 58, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(153, 97, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
	}
	
	public void Add(String user, String pass) {
		try {
			FileWriter fw = new FileWriter("users.txt", true);
			PrintWriter fstream = new PrintWriter(fw);
			fstream.print( "\nuser:" + user + "\n" );
			fstream.print( "password:"+pass);
			fstream.close();
			JOptionPane.showMessageDialog( null ,"Your account was successfully created!", "SUCCESS" ,  JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e2){
			JOptionPane.showMessageDialog(null, "ERROR..."+e2);
		}
	}
	
}
