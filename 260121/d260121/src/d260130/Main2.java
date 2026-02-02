package d260130;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {

        // 1. 드라이버 로드
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // 2. DB 접속
        Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@172.30.1.17:1521:xe",
            "system",
            "admin"
        );
        System.out.println("DB 연결 성공");

        Statement stat = conn.createStatement();

        // 3. 테이블 삭제 (없으면 무시)
        try {
            stat.execute("drop table phonebook");
        } catch (SQLException e) {
            // 테이블 없으면 무시
        }

        // 4. 테이블 생성
        String ctable =
            "create table phonebook (" +
            "id number, " +
            "name varchar2(10), " +
            "hp varchar2(13), " +
            "email varchar2(30)" +
            ")";
        stat.execute(ctable);
        System.out.println("테이블 생성 완료");

        // 5. 데이터 삽입
        String sql =
            "insert into phonebook values " +
            "(100, '테스트', '010-1111-1111', 'hong@gmail.com')";
        int result = stat.executeUpdate(sql);
        System.out.println("insert 결과: " + result);

        // 6. 자원 해제
        stat.close();
        conn.close();
    }
}
