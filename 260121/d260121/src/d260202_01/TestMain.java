package d260202_01;

public class TestMain {

	public static void main(String[] args) {
//		테스트 진행
//		만든 객체를 인터페이스를 활용하여 테스트 진행
//		PhonebookDAO dao = new OraclePhonebookDAO();
		PhonebookDAO dao = new H2PhonebookDAO();
//		전체삭제
//		System.out.println(dao.delete());

		// 입력
		
//		 dao.insert(new Phonebook(1, "홍길동1", "010-1111-1111","hong1@gmail.com"));
//		 dao.insert(new Phonebook(2, "홍길동2", "010-1111-2222","hong2@gmail.com"));
//		 dao.insert(new Phonebook(3, "홍길동3", "010-1111-3333","hong3@gmail.com"));
		 

//		선택출력
//		System.out.println(dao.findById(1));

//		수정
		System.out.println(dao.findById(1));
		dao.update(new Phonebook(2, null, "010-1234-5678", null));

//		삭제
//		dao.delete(2);

//		 System.out.println(dao.count());
//		전체출력
//		System.out.println(dao.findAll());
		
		

	}

}
