package d260202;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import org.h2.command.Prepared;

public class Main2_PrepareStatement_select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@172.16.15.76:1521:xe";
		Connection conn = DriverManager.getConnection(url, "system", "1234");
		System.out.println(conn);
		
//		String sql="select * from phonebook";
		String sql="select id, name, hp, email from phonebook";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		System.out.println("_________________________________");
		System.out.println("| 아이디  |      전화번호      |   이메일 |");
		System.out.println("_________________________________");
		while(rs.next()) {
			System.out.print(rs.getInt(1)); //필드명 대신 순서번호 입력 가능
			System.out.print(rs.getString(2));
			System.out.print(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println("--------------------------------");
		}
		

	}

}
