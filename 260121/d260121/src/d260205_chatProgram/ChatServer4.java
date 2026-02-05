package d260205_chatProgram;
//서버에서 노트패드 명령을 내리면 클라이언트 pc에서 노트패드 열리게

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer4 {
    public static void main(String[] args) {
        System.out.println("### 서버프로그램 시작 ###");
        try(ServerSocket server = new ServerSocket(1234)){
            Socket socket = server.accept();
            System.out.println(socket.getRemoteSocketAddress()+" 접속");
            System.out.println("서버시작");

            BufferedWriter out =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true){
                System.out.print("명령 입력: ");
                String msg=new Scanner(System.in).nextLine()+"\r\n";
                out.write(msg);
                out.flush();
                Thread.sleep(100);
            }

        } catch (Exception e){
            System.out.println("서버소켓 미생성!!");
            System.exit(0);
        }
    }
}