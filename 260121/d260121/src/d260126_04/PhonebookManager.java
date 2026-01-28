package d260126_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhonebookManager {
    //    private Phonebook[] pb = new Phonebook[100];
//
    private ArrayList<Phonebook> pb = new ArrayList<>();

    public PhonebookManager() {
        /*
        insert("홍길동", "010-1111-1111","hong@gmail.com");
        insert("김길동", "010-1111-2222","kim@gmail.com");
        insert("류길동", "010-1111-3333","ryu@gmail.com");
        */
        try {
            fileload("phonebook.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(pb[0].hashCode());
    }

    public void fileload(String filename) {
        //phonebook.txt파일을 메모리로 로드
//        pb = new Phonebook[100];
//        pb.removeAll(null);
        pb = new ArrayList<Phonebook>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String data = "";
            while ((data = br.readLine()) != null) {
                insert(
                        Integer.parseInt(data.split(" ")[0])
                        , data.split(" ")[1]
                        , data.split(" ")[2]
                        , data.split(" ")[3]
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean filesave(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            int i = 0;
            for (Phonebook p : pb) {
                bw.write(p.getId() + " " +
                        p.getName() + " " +
                        p.getHp() + " " +
                        p.getEmail() + " "
                );
                if (i != (pb.size() - 1)) {
                    bw.newLine();
                }
                i++;
            }
            bw.flush();
            bw.close();

//            파일 저장 성공 여부 확인용
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public void insert(int id, String name, String hp, String email) {
//        pb[index] = new Phonebook(id, name, hp, email);
        pb.add(new Phonebook(id, name, hp, email));
    }

    public void insert(String name, String hp, String email) {
//        pb[index] = new Phonebook(index + 1, name, hp, email);
        pb.add(new Phonebook(pb.size() + 1, name, hp, email));

//        index = index + 1;
    }

    public void select() {
        /*for (int i = 0; i < index; i++) {
            if (pb[i].getId() != 0) {
                System.out.println(pb[i]);
            }
        }*/

        for (Phonebook p : pb) {
//            id를 가져와서 0이 아닌것을 출력
            if (p.getId() != 0) {
                System.out.println(p);
            }
        }

    }

    public void update(String searchname, Phonebook p) {

        for (Phonebook _p : pb) {
            if (searchname.equals(_p.getName())) {
                if (_p.getName() != null) {
                    _p.setName(_p.getName());
                }
                if (_p.getHp() != null) {
                    _p.setHp(_p.getHp());
                }
                if (_p.getEmail() != null) {
                    _p.setEmail(_p.getEmail());
                }
                return;
            }
        }

    }

    public void delete(String name) {
        /*for (Phonebook p : pb) {
            if (p.getName().equals(name)) {
                p.setId(0);
            }
        }*/

//        // p.remove(); } } list pb에서 찾은 p의 위치는 어떻게 확인 가능할까
//        첫 번째 방법
        /*for (int i=0;i< pb.size();i++) {
            Phonebook p=pb.get(i);
            if (p.getName().equals(name)) {
//                객체 제거 방법
                pb.remove(i);
                break;  //or return;
            }
        }*/

/*//        두 번째 방법
        for (Phonebook p : pb) {
            if (p.getName().equals(name)) {
//                객체 제거 방법, indexOf로 현재 p의 위치를 찾는 방법
                pb.remove(pb.indexOf(p));
                break;  //or return;
            }
        }*/

        //        세 번째 방법
        Iterator<Phonebook> it = pb.iterator();
        while (it.hasNext()) {
            Phonebook p = it.next();
            if (p.getName().equals(name)) {
                it.remove();
                break;
            }
        }
    }

    public void selectByName(String name) {
        int i = 0;
        for (Phonebook p : pb) {
            if (p.getName().equals(name)) {
                System.out.println(p);
                break;
            }
            i++;

            //i, index를 조건문으로 처리해도 가능함(for int로 정의될때)
        }
        //System.out.println("index:"+index);
        //System.out.println("i:"+i);
        if (pb.size() == i) {
            System.out.println("전화번호부가 존재하지 않습니다.");
        }
    }

    //찾는 사람이 배열에 존재하는 여부 확인하는 함수
    public boolean isExist(String searchname) {
        for (Phonebook p : pb) {
            if (p.getName().equals(searchname)) {
                return true;
            }
        }
        return false;
    }

    public Phonebook getPhonebookByName(String name) {
        int i = 0;
        for (Phonebook p : pb) {
            if (p.getName().equals(name)) {
                //return pb[i]; //참조에 의한 전달이므로 문제의 소지가 발생
                //이를 해결하기 위한 방법은 객체의 복사방법
                return new Phonebook(p.getName(), p.getHp(), p.getEmail());
                //BeanUtils.copyProperties(); //spring 객체

            }
        }


        return null;
    }


}