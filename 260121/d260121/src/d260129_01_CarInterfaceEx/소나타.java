package d260129_01_CarInterfaceEx;

public class 소나타 {
//    맴버변수는 인터페이스
//    멤버변수가 클래스이고, 생성자에 new를 사용하여 객체가 존재할 경우 get함수를 사용할 수 없다.
    CarFunc 기능;
//    생성자는 기본적으로 입력되는 값을 디폴트로 가지기 때문에 고정값이 되므로 유연하지 않다.
    public 소나타(){
//        기능=new 자동차기능구현();
    }
    public 소나타(자동차기능구현 구현){
        기능=구현;
    };

    public CarFunc get기능() {
        return 기능;
    }

    public void set기능(CarFunc 기능) {
        this.기능 = 기능;
    }


}
