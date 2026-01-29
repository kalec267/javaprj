package d260129_01_washEx;

public class LgWash implements Wash, LowWash {
    private int speed;

    @Override
    public void startButton() {
        System.out.println("LG ??? ????");
    }

    @Override
    public void stopButton() {
        System.out.println("LG ??? ????");
    }

    @Override
    public void pauseButton() {
System.out.println("LG ??? ????");
    }

    @Override
    public void changeButton(int speed) {
        if(!(speed>=0 && speed<=100)){
            this.speed=0;
        }
        this.speed=0;
        System.out.println("???????: "+speed);

    }

    public void dry(){
        System.out.println("LG ??? ????");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
