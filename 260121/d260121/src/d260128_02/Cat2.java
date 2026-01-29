package d260128_02;

public abstract class Cat2 {
    public String name;
    public abstract void sound();
    public abstract void callName();

    public Cat2(String name) {
        this.name=name;
    }


    public void jump() {
        System.out.println("고양이 점프!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
