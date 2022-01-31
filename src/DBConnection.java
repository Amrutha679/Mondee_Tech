import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "Amrutha";
		String password = "Amrutha@890";
		
		Connection connection = DriverManager.getConnection(url,username,password);
		if(connection != null) {
			System.out.println("Connection Established!!");
		}
		Statement st = connection.createStatement();
		int x =st.executeUpdate("insert into student values(105,'Keerthi','civil',490)");
		
		if(x!=0) {
			System.out.println("Record inserted!");
		}
	}
}
