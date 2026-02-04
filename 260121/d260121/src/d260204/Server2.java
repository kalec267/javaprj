package d260204;

import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {
        //        간단한 서버 만들기
//        서버 소켓을 만들고 소켓으로 들어오는 것을 감지하면 accept를 하여 새로운 소켓이 생성된다.

//        클라이언트는 server 포트번호 5555로 최초 접속되고, 그 이후에 IN, OUT 스트림 통로 만들어짐
        try {
            System.out.println("서버 프로그램 시작!");
            ServerSocket server = new ServerSocket(5555);
            Socket socket = server.accept(); //대기상태
            System.out.println("클라이언트가 서버에 접속했습니다!!");

            socket.getOutputStream().write(new String("반가워 클라이언트야!!").getBytes()); //소켓 내보내기
            socket.getOutputStream().flush(); //소켓 완전히 내보내기

            Thread.sleep(1000);
            socket.close();
            System.out.println("서버 프로그램 종료!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
