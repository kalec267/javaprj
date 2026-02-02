package d260130;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMain1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		사용할 db의 드라이버를 로드한다.
		
//		1. Class.forName(드라이버 위치); 드라이브 로드 (import)
		Class.forName("org.h2.Driver");
		
//		2. 접속 객체를 이용하여 접속한다.Connection
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://172.16.15.97:8082/~/test", "sa", "");
		System.out.println(conn);
		if(conn==null) {
			System.out.println("연결 실패!");
			 return;
		}
		System.out.println("시험 성공");
		
//		3. 접속 객체를 이용하여  sql문을 처리할 객체를 만든다 Statement
		Statement stat=(Statement) conn.createStatement();
		String sql="insert into phonebook values(1, '김민한', '010-1111-1111', 'hong@gmail.com')";
//		stat.executeQuery(select문의 sql문);
//		stat.executeUpdate(insert/ update/ delete문의 sql문);
		int result=stat.executeUpdate(sql); //결과 0:실패 1:성공
		if(result<0) System.out.println("입력 실패");
		else System.out.println("입력성공");
		
//		4. sql 객체를 이용하여 sql을 실행한다. Statement에 있는 함수 이용
		
//		위의 연결은 체인처럼 연결되어 있는 구조이다.
//		순서: 드라이버 로드-DB접속-문장객체생성-실행
		
		
	}

}
