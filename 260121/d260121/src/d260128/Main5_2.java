package d260128;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseMotionListener;

//자동으로 마우스가 움직이면서 네모 박스를 그리는 코드 작성
public class Main5_2 {
    public static void main(String[] args) throws AWTException {
//        로봇은 시스템을 제어하는 객체 (전역프로그램 제어 가능)
        Robot robot = new Robot();

        /*for(int x=100; x<500;x++){
            robot.mouseMove(x,300);
            robot.delay(10);
        }*/

        robot.mouseMove(180,350);

        for(int i=0;i<2;i++){
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);
        }


    }
}