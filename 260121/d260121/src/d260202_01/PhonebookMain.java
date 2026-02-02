package d260202_01;

import java.io.IOException;
//PhonebookMain-> PhonebookProgram->PhonebookManager -> OraclePhonebookDAO
//생성할 때 필요한 도구를 입력하여 전달하는 형태로 사용: new OraclePhonebookDAO()를 전달하여 사용
//dao의 findAll() 함수까지 추적하기
public class PhonebookMain {

	public static void main(String[] args) throws IOException {
//		프로그램을 처음 시작할 때 어떤  DB를 사용할 것인지 값을 입력하여 처리
//		다른 말로 필요로 하는 도구를 생성자에 입력하여 처리한다.
//		new PhonebookProgram(new OraclePhonebookDAO());
		new PhonebookProgram(new H2PhonebookDAO());
	}

}
