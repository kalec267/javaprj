package d260204;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer2 {
    public static void main(String[] args) {

//        HTTP 버전
        String html="HTTP/1.1 200 OK\r\n";
        html+="content-type:application/json\r\n";
        html+="Connection:close\r\n";
        html+="\r\n"; //http 프로토콜에서 말하는 빈줄

        html+="{\"result\":\"success\"}";
        html+="\r\n\r\n";
        ServerSocket server = null;
        InputStream in=null;
        OutputStream out=null;

        System.out.println("웹서버 프로그램!!");
        while(true) {

            try {
                server = new ServerSocket(8888);
                Socket socket = server.accept();
                System.out.println("접속!!");
                in = socket.getInputStream();
                out = socket.getOutputStream();

                out.write(html.getBytes("UTF-8"));
                Thread.sleep(1000);
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
