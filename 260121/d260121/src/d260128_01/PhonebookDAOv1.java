package d260128_01;

import java.util.List;

public class PhonebookDAOv1 implements PhonebookDAO, PhonebookUserDAO{

    @Override
    public int insert(int id, String name, String hp, String email) {
        return 0;
    }

    @Override
    public List<Phonebook> findAll() {
        System.out.println("버전1에 대한 전체 리스트를 출력합니다.");
        return List.of();
    }

    @Override
    public Phonebook findById(int id) {
        return null;
    }

    @Override
    public int updateById(Phonebook p) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
