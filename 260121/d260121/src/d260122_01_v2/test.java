package d260122_01_v2;

public class test {
    public static void main(String[] args) {
//        값이냐? 참조냐?
//        복사냐? 참조냐?
//        결론: 소문자도 된 형태(int, float, char, byte 등) = 복사 (값을 복사)

//        객체는 참조다.
        int a=10;
        int b=a;
        Phonebook p1 = new Phonebook();
        System.out.println(p1.hashCode());
        Phonebook p2=new Phonebook();
        System.out.println(p2.hashCode());

        p1=p2; //참조이다
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println("================================");

        Phonebook p3 = new Phonebook("hong", "010-1111-1111", "hong@gmail.com");
        Phonebook p4 = p3;
        System.out.println(p4);
        p3.setName("kim");
        System.out.println(p4);

        PhonebookManager pm=new PhonebookManager();
//        함수를 통해서 가져오는 객체의 hashcode

        System.out.println(pm.getPhoneByName("홍길동").hashCode());
    }
}
