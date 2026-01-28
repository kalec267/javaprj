package d260122_01_rebuild;

import java.io.IOException;
import java.util.Scanner;

public class PhoneBookMain {
    public static void main(String[] args) throws IOException {
//        프로그램에 사용할 도구는 최상단에 유지시킴
        PhoneBookManager pm = new PhoneBookManager();
        Scanner scan = new Scanner(System.in);
        String searchName=null;
        while(true) {

//        어떻게 프로그램을 만들것인가를 설계
//        메뉴 만들기(기능 나열)
            System.out.println("+============================+");
            System.out.println("| 전화번호부 관리          |");
            System.out.println("+============================+");
            System.out.println("| 1. 전화번호부 입력       |");
            System.out.println("| 2. 전화번호부 전체출력   |");
            System.out.println("| 3. 전화번호부 찾기       |");
            System.out.println("| 4. 전화번호부 수정       |");
            System.out.println("| 5. 전화번호부 삭제       |");
            System.out.println("| 0. 프로그램 종료         |");
            System.out.println("+============================+");

//        메뉴 선택

//            int select = System.in.read();
            int select=scan.nextInt();
//            System.out.println(select); //ascii 코드로 받아들임

//        문제: 사용자는 ascii 코드보다 숫자를 이해하기 쉬움
//        해결 방법:
//            select = select - 48;
//            System.out.println(select);
//
//        선택된 번호 수행
            switch (select) {
                case 1:
                    System.out.print("전화번호부에 입력할 이름을 입력하세요.");
                    String name = scan.next();
                    System.out.print("전화번호부에 입력할 전화번호를 입력하세요.");
                    String hp = scan.next();
                    System.out.print("전화번호부에 입력할 이메일을 입력하세요.");
                    String email = scan.next();

                    pm.insert(name, hp, email);
                    break;
                case 2:
                    pm.select();
                    System.in.read();
                    break;
                case 3:
                    System.out.print("찾을 이름을 입력하세요.");
                    searchName=scan.next();
                    pm.selectByName(searchName);
                    System.in.read();
                    break;
                case 4:
                    System.out.println("수정할 사람의 이름을 입력 해주세요.");
                    searchName=scan.next();
//                    수정할 사항이 있는지 여부 확인
                    if(pm.isExist(searchName)) {
//                        System.out.println("사람이 존재하여 실행!");
//                        String data=scan.nextLine(); //엔터키까지 받는 함수
//                        System.out.println(data);
//                        pm.update(null, null);
                        System.out.println("수정할 사람의 정보를 입력하세요.");
                        PhoneBook p = new PhoneBook(scan.next(), scan.next(), scan.next());
                        pm.update(searchName, p);
                    }
                    else {
                        System.out.println("수정할 전화번호부가 존재하지 않습니다.");
                    }

                    break;
                case 5:
                    pm.delete(null);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
//                    break;
                    System.exit(0);
            }
        } //end while
    }
}
