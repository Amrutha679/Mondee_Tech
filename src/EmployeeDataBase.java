import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class DataBase{
	Scanner s = new Scanner(System.in);
	
	void insert(Statement st) throws SQLException {
		
		System.out.println("Enter eid,ename,salary");
		int id = s.nextInt();
		String name = s.next();
		int salary = s.nextInt();
		int x = st.executeUpdate("insert into employee values("+id+",'"+name+"',"+salary+")");
		if(x != 0) {
			System.out.println("Record Inserted");
		}
	}
	void delete(Statement st) throws SQLException {
		System.out.println("Enter the eid you want to delete :");
		int eid = s.nextInt();
		int x = st.executeUpdate("delete from employee where id = "+eid+" ");
		if(x != 0) {
			System.out.println("Record Deleted");
		}
	}
	void select(Statement st) throws SQLException {
		
		ResultSet rs = st.executeQuery("select * from employee");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}	
	}
	void update(Statement st) throws SQLException {
		
		int x = st.executeUpdate("update employee set salary = salary+ "+2000+"");
		if(x != 0) {
			System.out.println("Record Updated");
		}
	}
}
public class EmployeeDataBase {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		DataBase obj = new DataBase();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false","Amrutha","Amrutha@890");
		
		Statement st = connection.createStatement();
		
		char c=' ';
		
		while(c != 'n') {
			System.out.println("Employee database Enter your choice\n1.insert\n2.update\n3.delete\n4.select");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			switch(num) {
			case 1 :
				obj.insert(st);
				break;
			case 2:
				obj.update(st);
				break;
			case 3 :
				obj.delete(st);
				break;
			case 4:
				obj.select(st);
				break;
			default:
				System.out.println("exit");
			}
			System.out.println("\nDo you want to continue? y/n");
			c = sc.next().charAt(0);
			if(c == 'n') {
				System.out.println("exit");
			}
		}
	}
}
