package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.print("userName: ");
		String userName=(new Scanner(System.in)).next();
		System.out.print("password: ");
		char[] password=System.console().readPassword();
		
		String url="jdbc:oracle:thin:@172.16.15.76:1521:xe";
		
		Connection conn=DriverManager.getConnection(url, userName, new String(password));
		
		if(conn==null) {
			System.out.println("계속해서 또는 3번 입력받을 수 있게끔 처리");
			System.exit(0);
		}
		System.out.println("SQL> ");
		
	}

}
