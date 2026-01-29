package d260129_01_washEx;

public class Main {
    public static void main(String[] args) {

        SamsungWash sw = new SamsungWash();
        LgWash lw = new LgWash();

        /*
        문제사항
        인터페이스로 세탁기를 변경할 경우 기본 기능만 사용함
        회사의 고유 기능은 사용 못함
        ***이를 해결하기 위해 wash 인터페이스에 default void 함수명(){};
        */
//        Wash wash = new SamsungWash(); //or LgWash();

//        뒤에 객체만 바꿔주면 기능 변경 가능
        Wash wash = new LgWash();
        wash.dry();

        LowWash lowWash=new LgWash();
        lowWash.startButton();
        lowWash.stopButton();

    }
}
