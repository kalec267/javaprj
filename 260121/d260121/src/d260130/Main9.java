package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main9 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.76:1521:xe", "system", "1234");

		System.out.println(conn);
		
		Statement stat = conn.createStatement();
		
		int result=
		stat.executeUpdate("update phonebook set hp='010-1234-1234' where id=1");
		
		if(result<1) {
			System.out.println("update fail!!!");
			return;
		}
		System.out.println("update success!!");
	}

}
