package d260205_chatProgram;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient1 {
    public static void main(String[] args) {

        System.out.println("### 클라이언트 프로그램 시작 ###");

        try (Socket socket = new Socket("192.168.137.173", 1234)) {
            System.out.println("서버에 접속했습니다.");

//            서버와 메세지 교환
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            while (true) {

//                수신된 메세지 확인하기
//                메세지 대기
                while (true) {
//                    메세지 들어오면
                    if (in.available() > 0) {
//                        readAllBBytes는 수신에 문제가 있음
//                        byte[] recvmsg = in.readAllBytes();
                        byte[] recvmsg =new byte[256];
                        in.read(recvmsg);
                        System.out.print("서버에서 수신한 메세지: ");
                        System.out.println(new String(recvmsg));
                        break;
                    }
                }


//                서버에 메세지 보내기
                System.out.print("서버에 보낼 메세지 입력: ");
                String msg = new Scanner(System.in).nextLine(); //채팅 띄어쓰시 가능하므로 nextLine 사용
                out.write(msg.getBytes());
                out.flush();
                Thread.sleep(100);
            }

        } catch (Exception e) {
            System.out.println("서버와 접속이 되지 않습니다.");
            System.exit(0);
        }
    }
}
