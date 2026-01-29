package d260128_02;

public class Dog3 extends Dog2{
    public Dog3(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("¸Û¸Û");
    }

    @Override
    public void callName() {
        System.out.println("My name is "+getName());
    }
}
