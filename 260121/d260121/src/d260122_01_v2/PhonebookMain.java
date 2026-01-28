package d260122_01_v2;


import java.io.IOException;
import java.util.Scanner;

public class PhonebookMain {

	public static void main(String[] args) throws IOException {
		 //프로그램에서 사용할 도구는 최상단에 위치하여 유지시킴.
		 PhonebookManager pm=new PhonebookManager();
		 Scanner scan=new Scanner(System.in);
		 String searchname=null;

		 String name, hp, email=null;


		 while(true) {
		//어떻게 프로그램을 만들것인가를 설계
		//중요한점:컴퓨터와 사용자는 대화를 한다.
		//메뉴를 만들기(기능의 나열)

		 System.out.println("+===================+");
		 System.out.println("|   전화번호부 관리    |");
		 System.out.println("+===================+");
		 System.out.println("| 1.전화번호부 입력    |");
		 System.out.println("| 2.전화번호부 전체출력 |");
		 System.out.println("| 3.전화번호부 찾기    |");
		 System.out.println("| 4.전화번호부 수정    |");
		 System.out.println("| 5.전화번호부 삭제    |");
		 System.out.println("| 0.프로그램 종료    |");
		 System.out.println("+===================+");
		 //메뉴 선택
		 //int select=System.in.read();
		 int select=scan.nextInt();
		 //System.out.println(select);//ascii코드를 받아 들임
		 //문제:사용자는 ascii코드보다 숫자 1~5인값을 이해하기 쉬움
		 //이를 해결하는 방법은?
		 //select=select-48;
		 //System.out.println(select);

		 /* 선택된 번호를 수행(경우의 수는 여러개 이므로 if, switch문등을 활용) */

		 switch(select) {
		 case 1:
			 System.out.println("전화번호부에 입력할 이름을 입력하세요.");
			 name=scan.next();

			 System.out.println("전화번호부에 입력할 전화번호를 입력하세요.");
			 hp=scan.next();

			 System.out.println("전화번호부에 입력할 이메일 입력하세요.");
			 email=scan.next();

			 pm.insert(name, hp, email);
			 break;
		 case 2:
			 pm.select();
			 System.in.read();
			 break;
		 case 3:
			 System.out.println("찾을 이름을 입력하세요.");
			 searchname=scan.next();
			 pm.selectByName(searchname);
			 System.in.read();
			 break;
		 case 4:
			//scan한 값이 존재하는지 확인하는 함수(버퍼를 비우는 역할)
			if(scan.hasNextLine()) {
				 scan.nextLine();
			}
			 //수정할 사람이 있는지 여부 확인
			 //만약에 수정할 존재한다면 수정값을 입력 받은 후 처리
			 System.out.println("수정할 사람의 이름을 입력하세요.");
			 //searchname=scan.next();

			 //문자열을 공백까지 값으로 받아들이는 함수
			 searchname=scan.nextLine();

			 if(pm.isExist(searchname)) {
//				 System.out.println("수정할 사람의 내용을 입력하세요.[이름/전화번호/이메일]");
//				 //Phonebook p=new Phonebook(scan.next(), scan.next(), scan.next());
//
//
//				 String data=scan.nextLine();
//				 String[] datas=data.split("/");
//				 Phonebook p=new Phonebook(datas[0],datas[1],datas[2]);
//				 System.out.println(p);


				 System.out.println("변경할 이름을 입력하세요.[변경할 사항이 없으면 enter]");
				 name=scan.nextLine();

				 System.out.println("변경할 전화번호를 입력하세요.[변경할 사항이 없으면 enter]");
				 hp=scan.nextLine();

				 System.out.println("변경할 이메일을 입력하세요.[변경할 사항이 없으면 enter]");
				 email=scan.nextLine();

//				 변경사항이 없을 경우 기존의 데이터를 가지고 와서 입력 처리
				 Phonebook p=pm.getPhoneByName(searchname);

//				 값이 빈란이 아닐 때 phonebook 객체를 변경 해준다.
				 if(!name.equals("")){
					 p.setName(name);
				 }

				 if(!hp.equals("")){
					 p.setHp(hp);
				 }

				 if(!email.equals("")){
					 p.setEmail(email);
				 }

				 System.out.println(p);
				 pm.update(searchname, p); //참조이므로 문제 발생

			 }else {
				 System.out.println("수정할 전화번호부가 존재하지 않습니다.");
			 }

			 break;


		 case 5:
			 System.out.println("삭제할 이름을 입력하세요.");
			 searchname=scan.next();
			 if(pm.isExist(searchname)){
				pm.delete(null);
			 }
			 break;

		 case 0:
			 System.out.println("프로그램을 종료합니다.!");
			 //break;
			 System.exit(0);
		 }


		 }//end while
	}

}
