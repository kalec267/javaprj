package d260128;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame window에서 키보드를 누르면 콘솔에 해당 값을 확인하는 코드
public class Main4 {
    public static void main(String[] args) {
        KeyFrame f=new KeyFrame();
//        각각의 리스너는 별도로 등록 해야함
        f.addKeyListener(f);
        f.addWindowListener(f);
    }
}

class KeyFrame extends Frame implements KeyListener, WindowListener {
    Label label;
    public KeyFrame() {
        /*label = new Label("키");

        add(label);
        setBounds(0, 0, 500, 700);
        setVisible(true);*/

        setBounds(0,0,500,700);
        setLayout(new FlowLayout());
        setVisible(true);
        label=new Label();
        label.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(label);

        revalidate();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        엔터키를 누르면 화면 지우기
        System.out.println(e.getKeyChar()+":"+e.getKeyCode());
//        label.setText((e.getKeyChar()+": "+e.getKeyCode()));
        label.setText((label.getText()+e.getKeyChar()));

        if(e.getKeyCode()==10){
            label.setText("");
            revalidate();
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
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
}
