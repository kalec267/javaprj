package d260202;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main1_PrepareStatement_insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Statement 객체는 완성된 SQL에서만 사용
//		완성되지 않은 문장은 PrepareStatement
//		PrepadedStatement(사전에 완성된 문장) -> 
//		conn.prepareStatement()(사전에 완성되니 않은)
		
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  String url="jdbc:oracle:thin:@172.30.1.17:1521:xe";
	  Connection conn= DriverManager.getConnection(url, "system", "1234");
	  
	  System.out.println(conn);
	  
	  String sql="insert into phonebook values(?,?,?,?)";
	  PreparedStatement ps=conn.prepareStatement(sql);
	  ps.setInt(1,  5);
	  ps.setString(2,  "김민수");
	  ps.setString(3, "010-1234-5678");
	  ps.setString(4, "kim@gmail.com");
	  int result=ps.executeUpdate(); //Statement 객체와 차이점은 sql을 여기서 실행하는 것이 아님
//	  prepareStatement에  sql이 이미 실행되었기 때문에  executeUpdate는 호출만 하면 됨
	  
	  System.out.println(result);
	  ps.close();
	  conn.close();
	  
	  
	  

	}

}
