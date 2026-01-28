package d260122;

public class Test {

//    단위테스트 실행
//    @org.junit.Test
//    public void test() {
//        PhoneBookManager pm = new PhoneBookManager();
//        pm.insert("홍길동", "010-1111-1111", "hong@@gmail.com");
//        pm.insert("김길동", "010-1111-2222", "kim@@gmail.com");
//        pm.select();
//    }

    public static void main(String[] args){
        PhoneBookManager pm = new PhoneBookManager();
        pm.insert("홍길동", "010-1111-1111", "hong@@gmail.com");
        pm.insert("김길동", "010-1111-2222", "kim@@gmail.com");
        pm.insert("유길동", "010-1111-3333", "ryu@@gmail.com");

//        pm.update("김길동", new PhoneBook(null, "010-1111-3333", null));
        pm.delete("김길동");
        pm.insert("김길동", "010-1111-4444", "kim@@gmail.com");
//        pm.select();
        pm.selectByName("김길동");
    }
}
