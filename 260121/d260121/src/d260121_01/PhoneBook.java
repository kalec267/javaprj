package d260121_01;

public class PhoneBook {

        private String name;
        private String hp;
        private String email;

//        1. 생성자, get, set, toString 함수 생성
//        기본 생성자
//        public PhoneBook(){}

//        필드 생성자
        public PhoneBook(String name, String hp, String email){
            this.name=name;
            this.hp=hp;
            this.email=email;
        }
//        왜 필요한가? name

        public String getName(){
            return name;
        }
        public String getHp(){
            return hp;
        }
        public String getEmail(){
            return email;
        }

        public void setName(String name){
            this.name=name;
        }
        public void setHp(String hp){
            this.hp=hp;
        }
        public void setEmail(String email){
            this.email=email;
        }

//        toString 재정의

//    toString 재정의하기
    @Override
    public String toString() {
        return "PhoneBook[name="+name+", "+"hp="+hp+", "+"email="+email+"]";
    }
}
