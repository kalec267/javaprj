package d260128;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main6 {
    public static void main(String[] args) throws IOException, AWTException {

        Robot robot = new Robot();
        Rectangle screenRect=new Rectangle (Toolkit.getDefaultToolkit().getScreenSize());
        System.err.println(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenFullScreen=robot.createScreenCapture(screenRect);
        ImageIO.write(screenFullScreen, "png", new File("screen.png"));
        System.out.println("완료");
//        Toolkit.getDefaultToolkit(): 컴퓨터에 대한 정보를 획득할 수 있는 개체
    }
}
