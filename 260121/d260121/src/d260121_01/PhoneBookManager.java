package d260121_01;

public class PhoneBookManager {
//    1개의 PhoneBook 객체를 100개 관리하는 객체임
    PhoneBook[] pb = new PhoneBook[100];
    int index=0;

//    관리하기 위한 기능(입력, 출력, 수정, 삭제)
    public void insert(String name, String hp, String email){
//        객체 생성
        pb[index]=new PhoneBook(name, hp, email);
        index++;
    }
    public void select(){
//        100개의 배열에 null값이 존재하면 오류 발생
//        for(PhoneBook p:pb){
//            System.out.println(p);
//        }

        for(int i=0;i<index;i++){
            System.out.println(pb);
        }
    }
    public void update(){

    }
    public void delete(){

    }
}
