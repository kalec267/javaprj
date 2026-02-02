package d260202_01;

import java.util.List;

//인터페이스 설계하기
//DAO뜻: Data Access Object
//설계: insert(입력), select(전체, 선택), update(수정), delete(삭제)
public interface PhonebookDAO {
		
		public int insert(Phonebook pb);
		public List<Phonebook> findAll();
		public Phonebook findById(int id);
		public int update(Phonebook pb);
		public int delete(int id);
		
		public int delete(); 
		
		public int count(); //전체 글의 갯수 확인

	

}
