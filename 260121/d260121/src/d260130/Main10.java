package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main10 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.76:1521:xe", "system", "1234");

		System.out.println(conn);
		
		Statement stat = conn.createStatement();
		
		int result=
		stat.executeUpdate("delete phonebook where id=1");
		
		if(result<1) {
			System.out.println("delete fail!!!");
			return;
		}
		System.out.println("delete success!!");
	}

}
