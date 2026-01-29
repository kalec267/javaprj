package d260128;
//        listener 정리
        /*Frame ->window 리스너를 소유하고있다.
         * Button 등은 부품은 각 부품별 리스너를 모두 소유하고 있다.
         * 결론: 객체마다 리스너(이벤트 등록) 존재
         * 이벤트: 클릭, 마우스, 키보드 관련
         * */

/*window리스너 등록 방법
        * 1. 자신의 객체 내에 직접 선언하는 방법
        * 2. 자신의 객체 내에 함수를 만들어서 처리하는 방법
        * 3. 별도의 클래스를 만들어서 처리하는 방법
        * */
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main2 {
    public static void main(String[] args) {
        MyFrame f=new MyFrame();

//        1. 자신의 객체 내에 직접 선언하는 방법(익명 내부 클래스)

//        어댑터를 사용하면 특정 함수만을 추출하여 구현 가능(추상 클래스)
        /*f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });*/

//        리스너를 사용하면 모든 구현함수를 구핸 해야함(인터페이스)
        /*f.addWindowListener(new WindowListener() {
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
        });*/

//        2.구현한 프레임 내에 리스너 추가 방법
        f.addWindowListener(f);
//        f.addWindowListener(this); //Main2 클래스에 implements WindowListener 구현

//        3. 별도의 클래스를 만들어서 리스너 모두 처리
        f.addWindowListener(new MyListener());

    }
}

//2. 구현한 프레임 내에 리스너 등록 방법(implements)
class MyFrame extends Frame implements WindowListener{
    public MyFrame() {
        setTitle("리스너 등록");
        setBounds(0, 0, 500, 700);
        setVisible(true);
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