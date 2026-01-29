package d260128_02;

public class Cat implements Animal{
    public String name;

    public Cat(String name) {
        this.name=name;
    }

    @Override
    public void sound() {
        System.out.println("야옹야옹");
    }

    @Override
    public void callName() {
        System.out.println("내 이름은 "+name+"이야!!");
    }

    public void jump() {
        System.out.println("고양이 점프!!");
    }
}
