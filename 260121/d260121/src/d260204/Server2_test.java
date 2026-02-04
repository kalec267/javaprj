package d260204;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2_test {
    public static void main(String[] args) {
        try{
            System.out.println("서버 프로그램 시작!!!!");
            ServerSocket server = new ServerSocket(5555);
            Socket socket=server.accept();
            System.out.println("클라이언트가 서버에 접속");

            socket.getOutputStream().write(new String("반갑").getBytes());
            socket.getOutputStream().flush();

            Thread.sleep(1000);
            socket.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
