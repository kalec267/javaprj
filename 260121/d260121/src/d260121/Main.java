package d260121;

public class Main {

	public static void main(String[] args) {
		PhoneBook pb1=null;
		System.out.println(pb1);
//		pb1.name="kim";
//		System.out.println(pb1.name);
		pb1=new PhoneBook(); //PhoneBook()는 생성자 함수
//		생성자 함수는 자동으로 생성되는 함수이다.
		System.out.println(pb1);
		pb1.name="kim";
		System.out.println(pb1.name);
		pb1.print();

		pb1.myprint("lee", "010-1111-1111", "kim@gmail.com");
	}

}
