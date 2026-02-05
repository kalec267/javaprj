package d260205;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class MyWebServer4 {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8888)) {
            System.out.println("서버프로그램 실행중......");

            while (true) {
                Socket socket = server.accept();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                //1byte인 inputstream을 2바이트인 InputStreamReader로 변환하고 사용하기 쉬운 BufferedReader 생성
                BufferedReader br
                        = new BufferedReader(new InputStreamReader(in));

                String data = br.readLine();
                System.out.println(data);
                //들어오는 데이터는 요청방식에 따라 GET/POST/PUT/DELETE 방식이 있음
                if (data.startsWith("GET")) {

                    if (data.contains("favicon.ico")) {
                        //favicon.ico이미지를 전송
                    } else {
                        FileInputStream fis
                                = new FileInputStream("E:/workspace/d260121/src/d260204/upload.html");
                        byte[] body = fis.readAllBytes();

                        String header = "HTTP/1.1 200 OK\r\n"
                                + "Content-Type: text/html\r\n"
                                + "Content-Length: " + body.length + "\r\n"
                                + "\r\n";

                        out.write(header.getBytes());
                        out.write(body);
                        out.flush();
                        fis.close();
                    }

                } else if (data.startsWith("POST")) {
                    //1)들어오는 데이터를 읽어보자
                    //라인을 읽은 후 완료되었을 때 null값 확인보다는 empty함수를 사용하는게 맞음
				/*
				String line="";
				while(!(line=br.readLine()).isEmpty()) {
					System.out.println(line);
				}
				System.out.println("라인을 모두 읽었습니다.");
				*/

                    //2)읽은 데이터 중에서 파일의 데이터만을 추출하여 파일스트림으로 파일을 생성

                    int length = 0;
                    String boundary = null;
                    String line = "";

                    //한줄을 계속해서 읽는 상태에서 한줄에 대한 정보만 존재하며
                    //이전 데이터는 사라짐을 인식하고 있는 상태에서 코드 확인
                    while (!(line = br.readLine()).isEmpty()) {
                        System.out.println("----:" + line);
                        if (line.startsWith("Content-Length")) {
                            //파일의 데이터 길이 추출
                            length = Integer.parseInt(line.split(":")[1].trim());
                            System.out.println("파일길이:" + length);
                        }
                        if (line.startsWith("Content-Type")) {
                            boundary = line.split("boundary=")[1];
                            System.out.println("바운드리 확인:" + boundary);
                        }
                    }
                    //Accept-Language데이터까지만 읽은 후 반복문을 빠져나옴
                    //이후 데이터를 body에 바이트형태로 저장하게 됨
                    byte[] body = in.readNBytes(length);
                    System.out.println("파일의 전송된 데이터:");
                    System.out.println(new String(body));

                    byte[] sep = "\r\n\r\n".getBytes();
                    System.out.println("파일 구분자:");
                    System.out.println(new String(sep));

                    int start = indexOf(body, sep) + sep.length;
                    int end = indexOf(body, ("--" + boundary).getBytes()) - 2;
                    System.out.println("쓸 파일의 위치번호");
                    System.out.println("시작위치" + start);
                    System.out.println("끝위치" + end);
                    System.out.println("파일에 쓸 데이터:"
                            + new String(Arrays.copyOfRange(body, start, body.length)));
                    System.out.println("파일에 쓸 데이터:"
                            + new String(Arrays.copyOfRange(body, start, body.length - boundary.length())));
                    end = body.length - boundary.length();
                    //파일에 필요한 데이터만을 쓰는 작업(파일 저장하는 작업)
                    try (FileOutputStream fos = new FileOutputStream("upload.txt")) {
                        //fos.write(body, start, end-2);
                        String s = new String(Arrays.copyOfRange(body, start, body.length - boundary.length()));
                        fos.write(s.getBytes());
                        fos.flush();
                        fos.close();
                    } catch (Exception e) {
                        System.out.println("오류발생");
                    }
                    //클라이언트(웹브라우저)에게 response데이터를 보내는 작업(잘 받았음 표시)
                    out.write((
                            "HTTP/1.1 200 OK\r\n" +
                                    "Content-Type: text/html;charset=UTF-8\r\n"
                                    + "Connection: close\r\n"
                                    + "\r\n" +
                                    "업로드 완료"
                                    + "\r\n\r\n").getBytes());

                }
                socket.close();
            }

        } catch (Exception e) {
        }

    }

    //위치(번호)를 확인하는 함수
    static int indexOf(byte[] data, byte[] target) {
        for (int i = 0; i < data.length - target.length; i++) {
            boolean ok = true;
            for (int j = 0; j < target.length; j++)
                if (data[i + j] != target[j]) {
                    ok = false;
                    break;
                }
            if (ok) return i;
        }
        return -1;
    }

}