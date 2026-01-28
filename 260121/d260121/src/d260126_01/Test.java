package d260126_01;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("kim");
        list.add("lee");
        list.add("park");
        System.out.println(list);

//        배열은 중복이 가능함
        list.add("kim");
        System.out.println(list);
        System.out.println(list.get(0));
//        요소 제거
        list.remove(0);
        System.out.println(list);

    }
}
