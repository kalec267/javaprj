package d260202;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import org.h2.command.Prepared;

public class Main3_PrepareStatement_insert_where {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@172.16.15.76:1521:xe";
		Connection conn = DriverManager.getConnection(url, "system", "1234");
		System.out.println(conn);
		
//		String sql="select * from phonebook";
		String sql="select id, name, hp, email from phonebook where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
//		?가 있으므로 set 함수가 존재
		System.out.print("찾을 아이디를 입력하세요.");
		int id=(new Scanner(System.in)).nextInt();
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		System.out.println("_________________________________");
		System.out.println("| 아이디  |      전화번호      |   이메일 |");
		System.out.println("_________________________________");
		/*
		 * while(rs.next()) { System.out.print(rs.getInt(1)); //필드명 대신 순서번호 입력 가능
		 * System.out.print(rs.getString(2)); System.out.print(rs.getString(3));
		 * System.out.println(rs.getString(4));
		 * System.out.println("--------------------------------"); }
		 */
//		id가 중복되지 않는다고 가정할 경우 결과는 1개이므로  if문을 사용
		if(rs.next()) {
			System.out.print("아이디:"+ rs.getInt(1)+"  "); //필드명 대신 순서번호 입력 가능
			System.out.print("이름:"+ rs.getString(2)+"  ");
			System.out.print("전화번호:"+ rs.getString(3)+"  ");
			System.out.println("이메일:"+ rs.getString(4)+"  ");
			System.out.println("--------------------------------");
		}
	
		rs.close();
		ps.close();
		conn.close();
		

	}

}
