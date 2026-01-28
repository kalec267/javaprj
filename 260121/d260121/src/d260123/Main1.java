package d260123;

import java.io.IOException;

public class Main1 {
    public static void main(String[] args) throws IOException {
        //입력 스트림을 이용하여 키보드에서 읽어서 메모리에 입력하기
        System.out.println(System.in.available()); //

        int ch=System.in.read(); //엔터값 포함((엔터는 2개로 구성)

        System.out.println(ch);
        System.out.println((char)ch);
        System.out.println(System.in.available());

        ch=System.in.read();
        System.out.println((char)ch);
        System.out.println(System.in.available());

        System.out.println("end program!!");
    }
}
