package d260123;

import java.io.*;

public class Main5 {
    public static void main(String[] args) throws IOException {
        /*
//        파일로부터 데이터 가져오기(inputStream)
        File file = new File("a.txt"); //file 객체는 정보를 가지고 있다.
        FileInputStream in = new FileInputStream(file); //파일을 바이트 단위로 읽어오는 스트림
        System.out.println(in.available());

        String s="";
        while(in.available()>0){
            s+=(char)in.read();
        }
        System.out.println(s);
    }*/

        /*메모리에 본인의 영문 이름을 입력하고 스트림으로 파일에 메모리의 내용을 기록하기*/
        /*File file = new File("a.txt");
        FileOutputStream out = new FileOutputStream(file);
        String s = "minhan ";
        out.write(s.getBytes());
        System.out.println(s);*/

        String s="";
        s="minhan1 "+s;
        File file = new File("a.txt");
        FileOutputStream out = new FileOutputStream(file);
        for(byte b:s.getBytes()){
            out.write(b);
        }
        out.flush();
    }


}
