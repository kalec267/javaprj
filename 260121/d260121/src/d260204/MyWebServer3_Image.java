package d260204;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyWebServer3_Image {

    public static void main(String[] args) {

        System.out.println("웹서버프로그램!!");

        try (ServerSocket server = new ServerSocket(8888)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("접속!");
                OutputStream out = socket.getOutputStream();
                // 전송할 이미지 파일
                File file = new File("C:\\Users\\kalec\\Documents\\GitHub\\Security_Coding\\260121\\d260121");
                byte[] imageBytes = readFile(file);
                // HTTP 헤더
                String header = ""
                        + "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: image/webp\r\n"
                        + "Content-Length: " + imageBytes.length + "\r\n"
                        + "Connection: close\r\n"
                        + "\r\n";
                // 헤더 전송
                out.write(header.getBytes());
                // 이미지 데이터 전송
                out.write(imageBytes);
                out.flush();

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 파일을 byte[]로 읽는 메서드
    private static byte[] readFile(File file) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[1024];
        int read;
        while ((read = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, read);
        }

        fis.close();
        return baos.toByteArray();
    }
}