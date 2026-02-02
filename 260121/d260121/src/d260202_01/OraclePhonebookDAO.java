package d260202_01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//설계된거 직접 만들기
import java.util.List;

public class OraclePhonebookDAO implements PhonebookDAO{

	Connection conn;                           
	
//	생성자
	public OraclePhonebookDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="oracle.jdbc.driver.OracleDriver";
			conn=DriverManager.getConnection(url, "system", "1234");
			if(conn==null) {
				System.out.println("DB연결을 다시 확인하세요.");
				System.out.println("프로그램을 종료합니다.");
			}
					System.out.println("DB 연결 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(Phonebook pb) {
		try {
		String sql="insert into phonebook values(?,?,?,?)";
		  PreparedStatement ps=conn.prepareStatement(sql);
		  ps.setInt(1,  pb.getId());
		  ps.setString(2, pb.getName());
		  ps.setString(3, pb.getHp());
		  ps.setString(4, pb.getEmail());
		  int result=ps.executeUpdate();
		  ps.close();
		return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Phonebook> findAll() {
		try {
		String sql="select * from phonebook";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		/*결과를 이요하여 리스트를 반환할 예정이므로 코드 순서는 다음과 같다
		1. 빈 리스트를 만든다
		2. 반복문을 통해 한 객체를 Phonebook에 담고 담은 내용을 list에 add한다.
		3. 반복문이 끝나고 나서 list를 반환한다.*/
		
		List<Phonebook> list = new ArrayList<Phonebook>(); //1.빈 리스트 만들기
		//2. list에 add
		while(rs.next()) {
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String hp=rs.getString("hp");
			String email=rs.getString("email");
			Phonebook pb = new Phonebook(id, name, hp, email);
			list.add(pb);
		}
		rs.close();
		ps.close();
		//3. list 반환
		return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Phonebook findById(int id) {
		try {
			String sql="select * from phonebook where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				String name=rs.getString("name");
				String hp=rs.getString("hp");
				String email=rs.getString("email");
				Phonebook pb = new Phonebook(id, name, hp, email);
				return pb;
			}
			rs.close();
			ps.close();
			return null;
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	@Override
	public int update(Phonebook pb) {
//		주의사항: 기존의 db값과 함수로 전달되는 pb값의 차이를 확인
//		수정은 수정할 사항에 대해서만 수정처리하면 됨
//		null값이면 값을 변경할 필요가 없음
//		id를 이용하여 기존의 값을 가져로고
//		전달받은 pb값이 null이 아닐경우 값을 변경하여 처리
		PreparedStatement ps=null;
		try {
//			기존의 값을 가져와서 새로운 값으로 교체하는 작업
			Phonebook new_pb=findById(pb.getId());
			if(pb.getName()!=null) {new_pb.setName(pb.getName());}
			if(pb.getHp()!=null) {new_pb.setHp(pb.getHp());}
			if(pb.getEmail()!=null) {new_pb.setEmail(pb.getEmail());}
			
			String sql="update phonebook set name=?, hp=?, email=? where id=?";
			ps=conn.prepareStatement(sql);
		  
			ps.setString(1,  new_pb.getName());
			ps.setString(2, new_pb.getHp());
			ps.setString(3, new_pb.getEmail());
			ps.setInt(4, new_pb.getId());
			int result=ps.executeUpdate();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int delete(int id) {
		PreparedStatement ps=null;
		try {
			String sql="delete from phonebook where id=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, id);
			  int result=ps.executeUpdate();
			  return result;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public int delete() {
		try {
			String sql="delete from phonebook";
			PreparedStatement ps=conn.prepareStatement(sql);
			int result=ps.executeUpdate(); 
			ps.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int count() {
		try {
			String sql="select count(*) as cnt from phonebook";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int cnt=rs.getInt("cnt");
				rs.close();
				ps.close();
				return cnt;
			}
			
			return -1;
			}catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
	}
	
}
