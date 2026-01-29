package d260128;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main5_1 {
    public static void main(String[] args) {
        MouseFrame2 f=new MouseFrame2();
        f.addMouseMotionListener(f);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MouseFrame2 extends Frame implements MouseMotionListener{
    private int prex=-1;
    private int prey=-1;
    private int x;
    private int y;
    public MouseFrame2(){
        setBounds(0,0,900,500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        g.drawLine(prex,prey,x,y);
        prex=x;
        prey=y;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(e.getX()+", "+e.getY());
//        그래픽 객체를 얻은 후 paint함수를 호출하지 않고 그려주는 방법
//        repaint()함수는 화면을 새로고침하는 역할을 하므로 이전 그림이 다 지워짐
        x=e.getX();
        y=e.getY();
        Graphics g=getGraphics();
        g.drawLine(prex, prey, x, y);
        prex=x;
        prey=y;
    }
}
