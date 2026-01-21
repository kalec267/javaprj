package d260121;

public class Main3 {
    public static void main(String[] args) {
//        객체 변수에 new를 선언한 객체를 인스턴스라 함.
//        pb1 ~ pb100까지 생성할 경우 출력 및 여러가지를 한번에 처리하지 못하는 문제 발생

        PhoneBook[] pb = new PhoneBook[100];
//        객체를 생성할 PhoneBook() 생성자 함수를 호출했지만
//        배열을 생성할 때는 new PhoneBook[생성갯수];

        int i=1;
        for(PhoneBook p:pb){
            System.out.println((i++)+":"+p);
        }

        for(int j=0;j<pb.length;j++){
            pb[j]=new PhoneBook();
            System.out.println((j)+":"+pb[j]);
        }

//        데이터 입력
        for(int j=0;j<pb.length;j++){
            pb[j]=new PhoneBook();
            pb[j].name="kim"+j;
            pb[j].hp="010-11"+j+"-11"+j;
            pb[j].email="kim"+j+"@gmail.com";
        }
//        데이터 출력
        for(int j=0;j<pb.length;j++){
            pb[j].print();
        }
    }
}
