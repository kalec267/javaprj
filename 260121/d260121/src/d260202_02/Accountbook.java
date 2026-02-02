package d260202_02;

import java.util.Date;
// 기능 설계
// 기능을 가지고 메뉴를 작성 (수입, 지출 입력, 월 사용금액, 월 수입, 지출) 문서로 작성하면서 각각의 입력깂과 출력값을 상세히 명세
//인터페이스를 이용해서 각자 맡은 코드를 나눠서 작성, 나눠서 작성한 것을 다시 결합 (인터페이스의 상속)
//팀장의 역할은 모든 프로그램을 합쳐서 조율하기
//Oracle, H2에 대해 처리
// 어떤값을 어떻게 입력하고 출력할지 
public class Accountbook {
//	private int id; //아이디
//	private String type; //수입 또는 지출
//	private int amount; //금액
	private String name;
	private String category; //분류
//	private String date;
//	private java.util.Date date; //사용날짜 or java.sql.Date

	public Accountbook() {}


	public Accountbook(String name, String category) {
		this.name = name;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Accountbook{" +
				"name='" + name + '\'' +
				", category='" + category + '\'' +
				'}';
	}
}
