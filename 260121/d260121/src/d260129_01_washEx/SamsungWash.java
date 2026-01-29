package d260129_01_washEx;

public class SamsungWash implements Wash {
    private int speed;

    @Override
    public void startButton() {
        System.out.println("?Ｚ ??? ????");
    }

    @Override
    public void stopButton() {
        System.out.println("?Ｚ ??? ????");
    }

    @Override
    public void pauseButton() {
        System.out.println("?Ｚ ??? ????");
    }

    @Override
    public void changeButton(int speed) {
        if(!(speed>=0 && speed<=100)){
            this.speed=speed;
        }
        this.speed=speed;
        System.out.println("?Ｚ ???????: "+speed);

    }

    /*public void dry() {
        System.out.println("?Ｚ ???? ??");
    }*/

    public void clean() {
        System.out.println("?Ｚ ??? ??");
    }
}
