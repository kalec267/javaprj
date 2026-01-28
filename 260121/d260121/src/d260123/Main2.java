package d260123;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {
/*        키보드로 입력받은 문자를 한자씩 모두 출력
        스트림에 아무것도 들어있지 않을 때는 -1
        in.read() 함수는 스트림에 값이 없을 때는 키보드 입력 대기 상태가 됨
        스트림에 값이 존재할 때는 대기상태가 아닌 스트림의 값을 읽어오는 상태*/

        int key = 0;
        /*while((key=System.in.read())!=1){
            System.out.println(key+": "+((char)key));
        }*/

        /*
//        키보드 출력 방법2
//        System.in.read();
        while (true){
            key=System.in.read();
            System.out.print((char) key);
            if(key==-1){
                break;
            }
        }
        System.out.println();
        */

//        키보드 출력방법3
        /*
        key=System.in.read();
        System.out.println((char) key);
        while(System.in.available()!=0){
            key=System.in.read();
            System.out.print((char) key);
        }
         */

//        위의 코드의 문제점

        /*출력용으로 화면에만 글자가 나타나고 실제 사용할 경우 해당 데이터를 다시 이용할 수 없음
        * 해결: 문자열을 누락 시켜야함*/
        /*while((key=System.in.read())!=1){
            System.out.println(key+": "+((char)key));
        }*/

//        해결코드
        /*오류: String 변수로 인해 발생하는 문제 (EOF)*/
        /*String str="";
        while((key=System.in.read())!=10){
            str+=(char)key;
        }
        System.out.println("전체 문자열 출력: "+str);
        System.out.println("문자열 길이: "+str.length());*/
//      수정된 코드
        /*StringBuffer str = new StringBuffer();
        while((key=System.in.read())!=10){
            str.append((char) key);
        }
        System.out.println("전체 문자열 출력: "+str.toString());
        System.out.println("문자열 길이: "+str.length());*/

//        한 번에 스트림을 처리하는 방법
        byte[] bytes=new byte[100];
        System.in.read(bytes);
        System.out.println(bytes); //객체만 출력되는 문제 발생
//        byte 배열을 문자열로 변환
        String s = new String(bytes);
        System.out.println(s);
        System.out.println(s.length());

//        if(s.equals("abc")){
        if(s.trim().equals("abc")){
            System.out.println("문자열 입력 일치");
        }
        else{
            System.out.println("불일치");
        }

//        문자열을 바이트로 변환하는 방법
        System.out.println(s.trim().getBytes());
        for(byte b:s.trim().getBytes()){
            System.out.println(b);
        }



    }
}
