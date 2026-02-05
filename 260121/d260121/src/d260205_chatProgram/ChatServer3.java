package d260205_chatProgram;
//1:1 채팅(무전기 형식)
//서버와 클라이언트간에 동작할 순서 정하기
//클라이언트가 서버에 접속하고 서버가 먼저 말을 걸지, 클라이언트가 먼저 말을 걸지 정해야한다.
//클라이언트 접속 (서-클, 클-서)반복

//문제점
/*만약 10자의 데이터를 보냈음에도 버퍼의 전체 크기만큼 데이터를 수신받아야함
* in.read()로 처리할 경우 byte로 변환 해야함
* */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer3 {
    public static void main(String[] args) {
        System.out.println("### 서버프로그램 시작 ###");
        try(ServerSocket server = new ServerSocket(1234)){
            Socket socket = server.accept();
            System.out.println(socket.getRemoteSocketAddress()+" 접속");
            System.out.println("채팅 시작!!");


            InputStream in=socket.getInputStream();
            OutputStream out =socket.getOutputStream();

            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));

//            반복을 하면서 챗팅을 주고받음
            while(true){

//                서버가 메세지 보내기
                System.out.print("보낼 메세지 입력: ");
                String msg=new Scanner(System.in).nextLine(); //채팅 띄어쓰시 가능하므로 nextLine 사용
                bw.write(msg+"\r\n"); //문자열로 보내기
                bw.flush();
                Thread.sleep(100);

//                수신된 메세지 확인하기
                String recvmsg=br.readLine();
                System.out.print("수신메세지: "+recvmsg);
            }

        } catch (Exception e){
            System.out.println("서버소켓 미생성!!");
            System.exit(0);
        }
    }

}
