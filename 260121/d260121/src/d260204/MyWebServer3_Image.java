package d260204;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer3_Image {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8888);
        System.out.println("이미지 웹서버 실행");

        while (true) {
            Socket socket = server.accept();
            System.out.println("접속!");

            OutputStream out = socket.getOutputStream();

            // 전송할 이미지 파일
            File file = new File("C:\\Users\\kalec\\Documents\\GitHub\\Security_Coding\\260121\\d260121\\karina.png");
            byte[] imageBytes = new byte[(int) file.length()];

            FileInputStream fis = new FileInputStream(file);
            fis.read(imageBytes);
            fis.close();

            // HTTP 헤더
            String header = "HTTP/1.1 200 OK\r\n";
            header += "Content-Type: image/jpeg\r\n";
            header += "Content-Length: " + imageBytes.length + "\r\n";
            header += "Connection: close\r\n\r\n";

            // 헤더 전송
            out.write(header.getBytes());

            // 이미지 바이너리 전송
            out.write(imageBytes);
            out.flush();

            socket.close();
        }
    }
}
