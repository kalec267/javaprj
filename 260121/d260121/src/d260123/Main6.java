package d260123;

import java.io.*;

public class Main6 {
    public static void main(String[] args) throws IOException {
//        입력 스트림은 파일이 존재하지 않을 경우 오류 발생
//        FileInputStream fin=new FileInputStream("b.txt");

//        출력 스트림은 파일이 없을 경우 자동으로 생성
//        FileOutputStream fout=new FileOutputStream("b.txt");

//        파일 객체는 파일의 정보를 확인하기 위한 객체
        /*File file = new File("karina.png");
        System.out.println(file.getAbsolutePath());*/

//        파일의 데이터 출력
        String s="";
        FileInputStream fin=new FileInputStream("karina.png");
        while(fin.available()>0){
            s+=(char)fin.read();
        }
        System.out.println(s);
    }
}
