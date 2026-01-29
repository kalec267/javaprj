package d260128;

import javax.swing.*;
import java.awt.*;

public class Main9 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("JFrame 실습");
        f.setBounds(0,0,300,500);
        f.setVisible(true);
        f.setLayout(new FlowLayout());
        f.add(new Button("열기"));


    }
}
