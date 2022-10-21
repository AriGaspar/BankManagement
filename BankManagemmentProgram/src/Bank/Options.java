package Bank;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Options extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Options frame = new Options();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	   
    int ln;
    String Username,Password,Email;
    private JTextField txtUser;
    private JTextField txtPassword;

    public Options() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(52, 80, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(52, 117, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(146, 77, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(146, 114, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUser.getText();
				System.out.print( "asdasdaß" );
				String password = txtPassword.getText();
				//Add(username,password); 
			}
		});
		btnNewButton.setBounds(146, 173, 89, 23);
		contentPane.add(btnNewButton);
	}

}
