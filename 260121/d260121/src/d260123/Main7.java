package d260123;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main7 {
    public static void main(String[] args) throws IOException {
        /*메모리에 한글 문자열을 입력하고
        * 메모리에 있는 문자열을 파일에 기록하시오*/
        String s="자바프로그래밍!!";
        FileOutputStream fout = new FileOutputStream("c.txt");
        fout.write(s.getBytes());

        /*c.txt 파일의 내용을 1바이트씩 출력하시오*/
        FileInputStream fin = new FileInputStream("c.txt");
        /*while(fin.available()>0){
            System.out.print((char)fin.read());
        }*/

//        한 번에 데이터 가져오기 (Byte 데이터를 String으로 변환)
        byte[] bytes=new byte[256];
        fin.read(bytes);
        System.out.println(new String(bytes));



    }
}
