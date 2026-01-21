package d260121;

public class Main2 {
    public static void main(String[] args) {
        PhoneBook pb1 = new PhoneBook();
        pb1.name="hong";
        pb1.hp="010-1111-1111";
        pb1.email="hong@gmail.com";

        PhoneBook pb2 = new PhoneBook();
        pb2.name="kim";
        pb2.hp="010-1111-2222";
        pb2.email="kim@gmail.com";

        pb1.print();
        pb2.print();
    }
}
