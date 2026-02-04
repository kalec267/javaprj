package d260204;

import java.net.Socket;

public class Client2_test {
    public static void main(String[] args) {
        try {
            System.out.println("클라이언트 프로그램 실행");
            Socket socket = new Socket("192.168.137.173", 5555);
        } catch (Exception e){

        }
    }
}
