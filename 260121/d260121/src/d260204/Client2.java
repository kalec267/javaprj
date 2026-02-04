package d260204;

import java.io.InputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        //    클라이언트는 소켓을 통해 서버에 접속
        try {
            System.out.println("클라이언트 프로그램 시작!");
            Socket socket = new Socket("192.168.137.173", 5555);
            InputStream in = socket.getInputStream();

            String message = "";
            byte[] bmessage=new byte[256];
            int i=0;
            while (true) {
                while (in.available() > 0) {
//                    message += in.read(); //숫자가 누적된 형태
//                    message += (char)in.read(); //한글은 2바이트 처리이므로 깨짐

                    bmessage[i++]= (byte) in.read();

                    if (in.available() == 0) {
//                        System.out.print(message);
//                        바이트로 보내온 데이터를 바이트로 배여롤 받은 후 문자열로 변환해야 한글이 깨지지 않음
                        System.out.println(new String(bmessage).trim());
//                        위 코드의 문제점은 바이트배열의 최대 크기로 문자열이 되므로 trim을 해줘야함


                        System.out.println("클라이언트 프로그램 종료!!");
                        System.exit(-1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
