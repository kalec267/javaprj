package d260126_03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PhonebookFrame2 extends Frame {

    public PhonebookFrame2() {
//        프레임-부품
//        프레임-패널-부품
//        프레임(layout)-패널(layout)-프레임에 패널 add
//        패널(layout)-부품 /패널에 부품을 add

        setBounds(0,0,500,200);
        setVisible(true);
        setTitle("전화번호부");

        setLayout(new GridLayout(2,1)); //프레임의 레이아웃

        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        panel1.setBackground(Color.BLUE);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel2.setBackground(Color.YELLOW);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        /*panel1.add(new Button("버튼1"));
        panel1.add(new Button("버튼2"));
        panel1.add(new Button("버튼3"));*/
        add(panel1);
        add(panel2);

//        panel2.setVisible(false);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("닫기");
                System.exit(0);
            }
        });
    }


}
