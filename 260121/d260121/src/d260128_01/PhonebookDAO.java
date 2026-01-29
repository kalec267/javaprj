package d260128_01;

import java.util.List;
//기능리스트(설계)
//클래스에서 인터페이스로 변경
public interface PhonebookDAO {
//    기능 설계(입력, 전체출력, 수정, 삭제)
//    insert 함수는 입력 4개 있고 입력값에 따라 1:성공 0:실패
    public int insert(int id, String name, String hp, String email);
//    findAll 함수는 입력값이 없고 전체 리스트를 반환함. 데이터가 없을 경우 null
    public List<Phonebook> findAll();
    public Phonebook findById(int id);
    public int updateById(Phonebook p);

    public int deleteById(int id);


}
