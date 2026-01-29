package d260129_01_CarInterfaceEx;

public class 아반떼 {
//    자동차의 기능은 맴버변수로 구현
    //자동차기능구현 기능; //아직 기능이 사용되는 상태 아님
    CarFunc 기능;

//
    public 아반떼(){
        기능=new 자동차기능구현();
    }

//    인터페이스가 멤버변수일 경우 get기능을 사용할 수 없다.
    public CarFunc get기능() {
        return 기능;
    }

    public void set기능(자동차기능구현 기능) {
        this.기능 = 기능;
    }
}
