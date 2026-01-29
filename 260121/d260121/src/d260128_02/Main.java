package d260128_02;

public class Main {
    public static void main(String[] args) {
//        설계 관점에서는 Dog, Cat을 구현한 객체를 사용해야 모든 기능을 사용할 수 있다.
        Dog dog = new Dog("멍멍이");
        dog.sound();
        dog.callName();
        dog.run(); //객체 생성 시 모든 기능을 이용하려면 객체변수로 선언
//        이를 해결하기 위해 위의 객체는 추상클래스로 만든다.


//        인터페이스를 변수로 사용시에는 기능제한을 가진다.
        Animal cat = new Cat("야옹");
        cat.sound();
        cat.callName();
    }

    Cat2 cat2 = new Cat2("야옹이2") {

        @Override
        public void callName() {
            System.out.println("내 이름은 " + getName() + "이야!!");
        }

        @Override
        public void sound() {
            System.out.println("야옹이 2호");
        }
    };

//    Dog2 dog2 = new Dog2("장군이!!");
    Dog3 dog3 = new Dog3("장군이!!");
}
