package d260126_02;

import java.io.*;

public class ObjectStreamMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*
//        객체 자체를 스트림으로 저장하기 위한 것
        ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("object.ser"));
//        객체 생성, 이 객체를 스트림 형태로 썼다
        Phonebook pb =
                new Phonebook(1, "홍길동", "010-1111-1111", "hong@gmail.com");
        out.writeObject(pb);
*/

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.ser"));
        Phonebook p = (Phonebook) ois.readObject();
        System.out.println(p);
    }
}
