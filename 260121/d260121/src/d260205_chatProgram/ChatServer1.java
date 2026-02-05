package d260205_chatProgram;
//1:1 채팅(무전기 형식)
//서버와 클라이언트간에 동작할 순서 정하기
//클라이언트가 서버에 접속하고 서버가 먼저 말을 걸지, 클라이언트가 먼저 말을 걸지 정해야한다.
//클라이언트 접속 (서-클, 클-서)반복

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer1 {
    public static void main(String[] args) {
        System.out.println("### 서버프로그램 시작 ###");
        try(ServerSocket server = new ServerSocket(1234)){
            Socket socket = server.accept();
            System.out.println(socket.getRemoteSocketAddress()+" 접속");
            System.out.println("채팅 시작!!");

//            반복을 하면서 챗팅을 주고받음
            InputStream in=socket.getInputStream();
            OutputStream out =socket.getOutputStream();

            while(true){

//                서버가 메세지 보내기
                System.out.print("보낼 메세지 입력: ");
                String msg=new Scanner(System.in).nextLine(); //채팅 띄어쓰시 가능하므로 nextLine 사용
                out.write(msg.getBytes());
                out.flush();
                Thread.sleep(100);

//                수신된 메세지 확인하기
                System.out.print("수신메세지: ");

                while(true){
//                    데이터를 읽기 위해 무한반복을 사용할 경우
//                    반복문 안에 반드시 if를 이용하여 반복문을 빠져나가기 위한 코드를 작성 해야함
                    byte[] byterecv=new byte[256];
                    int i=0;

//                    한 바이트씩 메세지를 누적처리
                    while(in.available()>0){
                        byterecv[i++]= (byte) in.read();
                    }
//                    리시브된 바이트의 수신여부를 확인
                    if(i>0){
//                        i가 0보다 크면 데이터가 들어있단 얘기
//                        수신된 데이터를 출력하고 반복문 빠져나감
                        System.out.println(new String(byterecv).trim());
                        break;
                    }

                }
            }

        } catch (Exception e){
            System.out.println("서버소켓 미생성!!");
            System.exit(0);
        }
    }

}
