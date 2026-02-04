package d260204;

import java.io.InputStream;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) {
        /*//    클라이언트는 소켓을 통해 서버에 접속
        try {
            System.out.println("클라이언트 프로그램 시작!");
            Socket socket = new Socket("192.168.137.173", 5555);
            InputStream in = socket.getInputStream();
            while (true) {
                System.out.println("남아있는 데이터 갯수: "+in.available());
                System.out.println("전달받은 데이터: "+in.read());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        Socket socket = null;
        InputStream in = null;
        System.out.println("클라이언트 프로그램 시작!");
        try {
            socket = new Socket("192.168.137.173", 5555);
            in = socket.getInputStream();
        } catch (Exception e) {
        }

        while (true) {
            System.out.println(socket.isConnected());
//            결론: 서버소켓이 닫혀도 위의 상태 변화로는 확인 불가


            try {
                System.out.println("남아있는 데이터 갯수: " + in.available());
            } catch (Exception e) {}

            try {
                System.out.println("전달받은 데이터: " + in.read());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                if(e.getMessage().equals("Connection reset")){
                    System.out.println("클라이언트 프로그램 종료!");
                    System.exit(0);
                }
            }


            /*if(!socket.isClosed()){
                System.out.println("프로그램을 종료합니다.");
                System.exit(-1);
            }*/

        }


    }
}
