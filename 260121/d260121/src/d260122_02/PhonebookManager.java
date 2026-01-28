package d260122_02;

public class PhonebookManager {
    private Phonebook[] pb = new Phonebook[100];
    private int index = 0;

    public PhonebookManager() {
        insert("홍길동", "010-1111-1111", "hong@gmail.com");
        insert("김길동", "010-1111-2222", "kim@gmail.com");
        insert("류길동", "010-1111-3333", "ryu@gmail.com");
        //System.out.println(pb[0].hashCode());
    }

    public void insert(String name, String hp, String email) {
        pb[index] = new Phonebook(index + 1, name, hp, email);
        index = index + 1;
    }

    public void select() {
        for (int i = 0; i < index; i++) {
            if (pb[i].getId() != 0) {
                System.out.println(pb[i]);
            }
        }

    }

    public void update(String searchname, Phonebook p) {

        for (int i = 0; i < index; i++) {
            if (searchname.equals(pb[i].getName())) {
                if (p.getName() != null) {
                    pb[i].setName(p.getName());
                }
                if (p.getHp() != null) {
                    pb[i].setHp(p.getHp());
                }
                if (p.getEmail() != null) {
                    pb[i].setEmail(p.getEmail());
                }
                return;
            }
        }

    }

    public void delete(String name) {
        for (int i = 0; i < index; i++) {
            if (pb[i].getName().equals(name)) {
                pb[i].setId(0);
            }
        }
    }

    public void selectByName(String name) {
        int i = 0;
        for (i = 0; i < index; i++) {
            if (pb[i].getName().equals(name) && pb[i].getId() != 0) {
                System.out.println(pb[i]);
                break;
            }

            //i, index를 조건문으로 처리해도 가능함(for int로 정의될때)
        }
        //System.out.println("index:"+index);
        //System.out.println("i:"+i);
        if (index == i) {
            System.out.println("전화번호부가 존재하지 않습니다.");
        }
    }

    //찾는 사람이 배열에 존재하는 여부 확인하는 함수
    public boolean isExist(String searchname) {
        for (int i = 0; i < index; i++) {
            if (pb[i].getName().equals(searchname)) {
                return true;
            }
        }
        return false;
    }

    public Phonebook getPhonebookByName(String name) {
        int i = 0;
        for (i = 0; i < index; i++) {
            if (pb[i].getName().equals(name) && pb[i].getId() != 0) {
                //return pb[i]; //참조에 의한 전달이므로 문제의 소지가 발생
                //이를 해결하기 위한 방법은 객체의 복사방법
                return new Phonebook(pb[i].getName(), pb[i].getHp(), pb[i].getEmail());
                //BeanUtils.copyProperties(); //spring 객체

            }
        }

        return null;
    }
}