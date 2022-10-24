package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery("select * from users");
			while( resultSet.next() ) {
				System.out.println(resultSet.getString("user_password"));
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Alert",JOptionPane.WARNING_MESSAGE); 
		}
		
	}

}
