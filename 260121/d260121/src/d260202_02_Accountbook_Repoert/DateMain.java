package d260202_02_Accountbook_Repoert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMain {
	public static void main(String[] args) {
//		일반적인 날짜 처리
		java.util.Date udate=new Date();
//		System.out.println(udate);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(udate));
		
//		sql에서의 날짜 객체는 날짜가 들어있는 상태가 아님
//		java.sql.Date 객체는 입력깂으로 long타입을 가져야한다.
//		java.util.Date()객체를 long 타입으로 변경하는 함수는 getTime()이다.
		
//		SQL에 날짜를 넣을려면 long 타입으로 넣어야함
		java.sql.Date sdate=new java.sql.Date((new java.util.Date()).getTime());
		System.out.println(sdate);
	}

}
