package d260126_01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("kim");
        list.add("lee");
        list.add("park");

        for(String s:list){
            System.out.println(s);
        }

        /*
        1. list를 iterator로 변경
        2. hasnext로 다음 값이 있는지 확인
        */
//        iterator로 출력하는 방법
        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            String s=it.next();
            System.out.println("it:"+s);
            if(s.equals("park")){
                it.remove();
            }
        }
        System.out.println("it2: "+list);




    }
}
