package d260123;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main3 {
    public static void main(String[] args) throws IOException {
//        시용자 정의 스트림
        byte[] bytes={1,2,3,4,5,6,7,8,9}; //byte형의 배열 데이터
//        데이터를 스트림으로 변환
        /*InputStream in = new InputStream() {
            @Override
            public int read() throws IOException {

                return 0;
            }
        };*/

//        byte 배열을 inputStream으로 변환
        InputStream in=new ByteArrayInputStream(bytes);
        int data;
        while ((data=in.read())!=-1) {
            System.out.print(data);
        }
//        정리: 변수는 메모리에 저장된 값, 스트림은 큐에 저장된 값
    }
}
