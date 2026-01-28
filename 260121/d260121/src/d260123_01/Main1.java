package d260123_01;

import d260122_01_v2.Phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws IOException {
        /*작업 순서
         * 1. PhoneBook.txt 파일의 내용을 메모리에 로드한다
         * 2. 메모리에 로드된 줄단위 내용을 분리한다
         * 3. 분리된 데이터를 PhoneBook 객체로 생성한다
         * 4. 생성된 PhoneBook객체는 리스트 형태로 관리한다.
         * */

//        1.
        File file = new File("PhoneBook.txt");
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
//        2. 메모리 로드
        String buf = "";
//        좌측: 인터페이스 = 우측:클래스
        List<Phonebook> list = new ArrayList<Phonebook>();

        while ((buf = br.readLine()) != null) {
//            System.out.println(buf);
            String[] datas = buf.split(" ");

            int id = Integer.parseInt(datas[0]);
            String name = datas[1];
            String hp = datas[2];
            String email = datas[3];

//            System.out.printf("%d %s %s %s\n", id, name, hp, email);
            Phonebook pb = new Phonebook(id, name, hp, email);
            list.add(pb);
        }

        System.out.println(list);

//        새로운 PhoneBook 객체를 생성하고 객체의 모든 내용을 텍스트파일 형식으로 쓰기하시오.
        Phonebook pb2 = new Phonebook(5, "김민수", "010-6666-6666", "min@naver.com");
        list.add(pb2);
        System.out.println(list);

        BufferedWriter bw = new BufferedWriter(new FileWriter("PhoneBook.txt"));

        int index=1;
        for (Phonebook p : list) {
            String inputdate = p.getId() + " " + p.getName() + " " + p.getHp() + " " + p.getEmail();
            bw.write(inputdate);
            if (index!=list.size()) {
                bw.newLine();
            }
            index++;
        }
        bw.flush();
        bw.close();
        /*문제점: 마지막 줄에 라인이 추가되는 문제 발생
         * 마지막에 입력되는 줄은 newLine()함수를 생략한다.*/

        /*위에 내용 참고하여
        * 전화번호부 관리프로그램에 파일 불러오기 함수를 만들고
        * 이를 초기화 시 적용하기
        * (추가사항) 메뉴에 파일 불러오기, 파일 저장하기를 추가하여 함수를 완성하기
        * 파일 저장하기 함수는 프로그램 저장 시 자동으로 실행되도록 처리*/




    }
}
