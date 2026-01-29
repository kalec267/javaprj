package d260127;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListBoxMain {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setBounds(0,0,300,500);
        f.setTitle("listbox");
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);
            }
        });

//        레이아웃 설정
        f.setLayout(new FlowLayout());
        java.awt.List list = new List();
        list.add("사과");
        list.add("banana");
        list.add("mango");
        f.add(list);

//        아이템에 클릭을 했을 때 처리를 하기 위해서는 리스너 등록을 해야함
        list.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(list.getSelectedIndex());
                System.out.println(e.getItem());
                System.out.println(list.getSelectedItem());
                System.out.println(list.getName());
                System.out.println(e.getSource());
            }
        });
    }

}
