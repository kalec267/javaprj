package d260129_01_CarInterfaceEx.자동차기능구현2;

import d260129_01_CarInterfaceEx.소나타;
import d260129_01_CarInterfaceEx.아반떼;
import d260129_01_CarInterfaceEx.자동차기능구현;

public class 소나타생산 {
    public static void main(String[] args) {

        소나타 sonata1=new 소나타(new 자동차기능구현());
        sonata1.get기능().movehandle();

        소나타 sonata2=new 소나타(new 자동차기능구현2());
        sonata2.get기능().movehandle();

        아반떼 av6=new 아반떼();
        소나타 sonata3 =new 소나타();
//        현재까지 기능을 넣어주지 않은 상태

        sonata3.set기능(new 자동차기능구현());
        sonata3.get기능().movehandle();
    }
}
