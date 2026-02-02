package d260202_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleAccountBookDAO implements AccountbookDAO {
	Connection conn;

	public OracleAccountBookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.17:1521:xe";
			conn = DriverManager.getConnection(url, "system", "admin");
			if (conn == null) {
				System.out.println("DB연결 실패, 프로그램 종료");
			}
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Accountbook> findByCategory(String category) {

        try {
            String sql = "select * from accountbook where category=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

			List<Accountbook> list = new ArrayList<Accountbook>();
            while (rs.next()) {
                String name = rs.getString("name");
                String dbcategory = rs.getString("category");
                Accountbook ab = new Accountbook(name, dbcategory);
                list.add(ab);
            }
            rs.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
			return null;
        }
    }
}

