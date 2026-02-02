package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.15.76:1521:xe","system", "1234");
		System.out.println(conn);
		
		Statement stat=conn.createStatement();
		ResultSet rs=stat.executeQuery("select * from phonebook");
		
		System.out.println(rs);
		
		while(rs.next()) {
			System.out.print("아이디:"+rs.getInt("id")+" ");
			System.out.print("이름:"+rs.getString("name")+" ");
			System.out.print("전화번호:"+rs.getString("hp")+" ");
			System.out.print("이메일:"+rs.getString("email")+" ");
			System.out.println();
			
		}
		rs.close();
		stat.close();
		conn.close();
	}

}
