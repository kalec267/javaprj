package d260126_03;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameMain {
    public static void main(String[] args) {

        PhonebookFrame2 pb = new PhonebookFrame2();
        Frame f = new Frame();
        f.setBounds(0,0,500,200);
        f.setVisible(true);
        f.setTitle("전화번호부");

//        레이아웃 종류: flowlayout(html에서 inline, block), Borderlayout, cardlayout, gridlayout


        BorderLayout boardlayout = new BorderLayout();
        f.setLayout(boardlayout);

//        부품에 대한 설정
        Button btn1=new Button("input PhoneBook");
        f.add(btn1, BorderLayout.EAST);

        Button btn2=new Button("print all PhoneBook");
        f.add(btn2, BorderLayout.WEST);

        Button btn3=new Button("search PhoneBook");
        f.add(btn3, BorderLayout.SOUTH);

        Button btn4=new Button("update PhoneBook");
        f.add(btn4, BorderLayout.NORTH);

        Button btn5 =new Button("delete PhoneBook");
        f.add(btn5, BorderLayout.CENTER);

//        프레임에서 어떤 기능을 추가할 때는 add가 붙는 함수를 호출한다.
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("닫기 버튼이 눌리고 있네요");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

    }
}
