package d260128;

import java.awt.*;
import java.awt.event.*;

public class Main5 {
    public static void main(String[] args) {
        MouseFrame f = new MouseFrame();
        f.addWindowListener(f);
        f.addMouseListener(f);
        f.addMouseMotionListener(f);
        f.addMouseWheelListener(f);
    }

}

class MouseFrame extends Frame
        implements WindowListener, MouseListener, MouseMotionListener, MouseWheelListener {
    private int sx=0;
    private int sy=0;
    private int ex=0;
    private int ey=0;

    public MouseFrame() {
        setBounds(900, 0, 500, 700);
        setVisible(true);

    }
    @Override
    public void paint(Graphics g) {
        g.drawLine(sx,sy,ex,ey);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("click=> " + "x: " + e.getX() + "y: " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Press=> " + "x: " + e.getX() + "y: " + e.getY());
//        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("move=> " + "x: " + e.getX() + "y: " + e.getY());
        sx=ex;
        sy=ey;
        ex=e.getX();
        ey=e.getY();
        repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

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