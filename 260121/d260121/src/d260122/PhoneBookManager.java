package d260122;

public class PhoneBookManager {
    //    겍체 공간 100개 확보
    PhoneBook[] pb = new PhoneBook[100];
    private int index = 0;


    //    100개의 데이터를 관리하는 함수(기능)
//    insert (입력 시 필요한 사항은 무엇인가?)
    public void insert(String name, String hp, String email) {
//    pb[0]=new PhoneBook(name, hp, email);
//    위의 데이터는 0번째에 들어가는 문제, 자동으로 객체를 생성해서 입력 해줘야함
        pb[index] = new PhoneBook(index+1, name, hp, email);
        index++;

    }

    //    select
    public void select() {
//        pb 배열이 null값이 존재하게 되면 오류 발생
//        for (PhoneBook p : pb) {
//            System.out.println(p);
//        }

//        null 처리를 위한 코드 수정
//        for (int i = 0; i < index; i++) {
//            System.out.println(pb[i]);
//        }

//        id=0으로 삭제된 코드는 출력되지 않게 처리
        for(int i=0;i<index;i++){
            if(pb[i].getId()!=0){
                System.out.println(pb[i]);
            }
        }
    }

    //    update
    public void update(String searchName, PhoneBook p) {

//        가장 기본적인 검색 알고리즘
//        searchname와 pb의 i번째에서 가져온 이름과 일치하면 true 반환
//        이름만 변경하고 싶을 때 다른 정보는 null값이 될 수 있는 문제 있음
//        ---------------------------------------------------------------
//        for(int i=0;i<index;i++) {
//            if(searchName.equals(pb[i].getName())) {
//                pb[i].setName(p.getName());
//                pb[i].setHp(p.getHp());
//                pb[i].setEmail(p.getEmail());
//                break;
//            }
//        }
//        수정하는 값에서 전화번호만 있고 나머지 값이 존재하지 않은 경우(null)
//        이름과 이메일이 null로 변경되어 데이터 왜곡 발생
//        이를 해결하기 위해 null값은 수정을 하지 않게 처리

        for (int i = 0; i < index; i++) {
            if (searchName.equals(pb[i].getName())) {
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

    //    delete
    public void delete(String name) {
        for(int i=0;i<index;i++){
            if(pb[i].getName().equals(name)){
                pb[i].setId(0); //id가 0이면 삭제
//                위의 코드로 인해서 파생되는 수정코드는 전체 출력일 때 id가 0인 것은 출력되지 않도록 처리

            }
        }
    }

//    찾기-select에서 파생되어 만들어지는 함수
    public void selectByName(String name) {
//        for(int i=0;i<index;i++){
//            if(pb[i].getName().equals(name)){
//                System.out.println(pb[i]);
//                break;
//            }
//        }
//        위의 코드의 문제점: 삭제된 이름을 검색할 때 삭제된 이름의 배열이 출력되는 문제

        for(int i=0;i<index;i++){
            if(pb[i].getName().equals(name)&&pb[i].getId()!=0){
                System.out.println(pb[i]);
                break;
            }
        }
    }
}
