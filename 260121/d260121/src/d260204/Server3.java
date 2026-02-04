package d260204;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
//    서버를 중지하면 클라이언트 프로그램도 동시에 중지되는 것을 방지하는 방법
    public static void main(String[] args) {
        try {
            System.out.println("서버 프로그램 시작!");
            ServerSocket server = new ServerSocket(5555);
            Socket socket = server.accept(); //대기상태
            System.out.println("클라이언트가 서버에 접속했습니다!!");

//            서버는 데이터를 제공하는 역할만 처리한다. (outputStream만 존재하면 됨)
            OutputStream out = socket.getOutputStream();
            while (true) {
                out.write('a');
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
