package d260123;

import java.io.*;
import java.util.Arrays;

public class Main8 {
    public static void main(String[] args) throws IOException {
        /*
//        Buffer는 완충 역할을 한다.
//        아래는 기본 구조로서 inputStream에 해당하는 데이터가 존재 해야함
//        inputStream은 데이터이므로 FileInputStream으로 여기에 위치할 수 있음

        BufferedInputStream bis=new BufferedInputStream(new InputStream() {
            String s="hello";
            byte[] data=s.getBytes();
            private int index=0; //위치값
            @Override
            public int read() throws IOException {
                if(index>=data.length){
                    return -1;
                }
                return data[index++] & 0xff; //마스크 처리
            }
        });

//        available는 직접 생성할 경우 졍의를 통해 계산 처리 해야함
        System.out.println(bis.available());
//      위의 정의가 안되서 사용할 수 없음
        while(bis.available()>0){
            System.out.print((char) bis.read());
        }
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());
        System.out.print((char) bis.read());
    }*/
//        new InputStreamReader(null).read(); //데이터를 변수로부터 들고옴
//        new FileInputStream(null).readAllBytes(); //데이터를 파일로부터 가져옴

        byte[] bytes = new byte[1024];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c.txt"));
        bytes = bis.readAllBytes();
//        값의 리턴을 통해서 bytes배열에 값을 넣는 구조
        System.out.println(bytes); //배열 객체
        System.out.println(new String(bytes)); //문자 변환
        System.out.println(Arrays.toString(bytes)); //배열 안의 값을 리스트로 표현

//        함수에 바이트 배열의 변수를 입력값으로 주면 bytes변수 안에 값을 담는 구조
//        new InputStreamReader(null).read(bytes);


//        여러 줄의 데이터를 제어할 때 1번째 줄에 있는 데이터만 출력하고 싶은 경우
//        어떻게 처리를 하는가? 이 문제를 해결하기 위해 라인 단위로 데이터를 읽을 수 있는 스트림이 존재함
        FileReader reader = new FileReader("c.txt");
        reader.read(); //reader 함수밖에 읽기할 함수가 없음

//        BufferdReader는 파일이더를 필요오 하고, 파일리더는 파일을 필요로 한다.
        BufferedReader reader2 =
                new BufferedReader(
                        new FileReader(
                                new File("c.txt")));
        System.out.println(reader2.readLine());

//        줄 단위로 계속해서 읽어오는 방법
        String s = "";
        while ((s = reader2.readLine()) != null) {
            System.out.println(s);
        }

//        파일에 줄 단위로 쓰기
//        BufferedWriter write = new BufferedWriter(new Writer());
        s = "AWS 보안 프로그래밍";
        BufferedWriter writer = new BufferedWriter(new FileWriter("c.txt", true));
        writer.newLine();
        writer.append(s);

        writer.close();
//        문제점: 기존 파일의 내용이 삭제됨
//        new BufferedWriter(new FileWriter("c.txt", true)); //이러면 기존 내용 삭제 안됨
//        추가 방법: writer.write(s); writer.newLine();
    }
}
