package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main8 {

	public static void main(String[] args){

		Connection conn=null;
		String url=null;
		String userName=null;
		char[] password= null;
		int count=0;
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 확인하세요");
			return;
		}
		do {
			System.out.print("userName: ");
			userName=(new Scanner(System.in)).next();
			System.out.print("password: ");
			password=System.console().readPassword();
			
			url="jdbc:oracle:thin:@172.16.15.76:1521:xe";
			
			try {
				conn=DriverManager.getConnection(url, userName, new String(password));
			} catch (SQLException e) {
				System.out.println("id와 password를 확인하세요.");
			}
			count++;
			if(conn!=null) break;
		} while(count<3);
		
		if(conn==null) {
			System.out.println("다음에 다시 시도");
			System.exit(0);
		}
		
		System.out.println("SQL> ");
		
	}

}
