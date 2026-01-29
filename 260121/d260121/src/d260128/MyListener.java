package d260128;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*implements WindowListener 인터페이스는 함수 구현이 안되어있다, 앞에 extends를 하면 필요한 함수만 구현 가능*/
public class MyListener extends WindowAdapter implements WindowListener {

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
