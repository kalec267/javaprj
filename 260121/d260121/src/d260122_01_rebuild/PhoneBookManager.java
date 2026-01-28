package d260122_01_rebuild;

public class PhoneBookManager {
    PhoneBook[] pb= new PhoneBook[100];
    private int index=0;

    public PhoneBookManager() {
        insert("홍길동", "010-1111-1111", "hong@@gmail.com");
        insert("김길동", "010-1111-2222", "kim@@gmail.com");
        insert("유길동", "010-1111-3333", "ryu@@gmail.com");
    }

    public void insert(String name, String hp, String email){
        pb[index]=new PhoneBook(index+1, name, hp, email);
        index++;
    }

    public void select(){
        for(int i=0;i<index;i++){
            if(pb[i].getId()!=0){
                System.out.println(pb[i]);
            }
        }
    }

    public void update(String searchName, PhoneBook p){
    for (int i = 0; i < index; i++) {
        if (pb[i].getName().equals(searchName)) {

            if (p.getName() != null) {
                pb[i].setName(p.getName());
            }
            if (p.getHp() != null) {
                pb[i].setHp(p.getHp());
            }
            if (p.getEmail() != null) {
                pb[i].setEmail(p.getEmail());
            }

            return; // 찾았을 때만 종료
        }
    }
}


    public void delete(String name){
        for(int i=0;i<index;i++){
            if(pb[i].getName().equals(name)){
                pb[i].setId(0);
            }
        }
    }

    public void selectByName(String name){
    for (int i = 0; i < index; i++) {
        if (pb[i].getName().equals(name)) {
            System.out.println(pb[i]);
            return;
        }
    }
    System.out.println("전화번호부가 존재하지 않습니다.");
}


//    찾는 사람이 배열에 존재하는지 여부 확인하는 함수
    public boolean isExist(String searchName) {
        for (int i = 0; i < index; i++) {
            if (pb[i].getName().equals(searchName)) {
                return true;
            }
        }
        return false;
    }


}
