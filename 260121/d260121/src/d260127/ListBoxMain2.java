package d260127;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListBoxMain2 {

    public static void main(String[] args) {
        //기본사항 설정
        Frame f = new Frame();
        f.setBounds(0, 0, 300, 500);
        f.setTitle("list box");
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //레이아웃설정
        //f.setLayout(new FlowLayout());
        f.setLayout(new BorderLayout());
        Label label = new Label("id name hp");
        label.setBackground(Color.LIGHT_GRAY);
        label.setAlignment(Label.LEFT);
        f.add(label, BorderLayout.NORTH);

        java.awt.List list = new List();
        //list.add(label);//리스트에 값이 들어가지 않는 상태(flowlayout)
        list.add("1 hong 010-1111-1111");
        list.add("2 kim 010-1111-2222");
        list.add("3 ryo 010-1111-3333");
        f.add(list, BorderLayout.CENTER);

        //상세보기 BorderLayout의 south에 구현
        Label idlb = new Label("id:");
        idlb.setBackground(Color.ORANGE);
        idlb.setPreferredSize(new Dimension(200, 30));

        Label namelb = new Label("name:");
        namelb.setBackground(Color.YELLOW);
        namelb.setPreferredSize(new Dimension(200, 30));

        Label hplb = new Label("hp:");
        hplb.setBackground(Color.cyan);
        hplb.setPreferredSize(new Dimension(200, 30));

        Panel panel = new Panel();
        panel.setLayout(new FlowLayout());
        panel.add(idlb);
        panel.add(namelb);
        panel.add(hplb);
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        //f.invalidate();
        //f.repaint();
        //boardlayout에 아래와 같이 등록했을 때 마지막에 등록된 레이블만 표시
		/*
		f.add(idlb,BorderLayout.SOUTH);
		f.add(namelb,BorderLayout.SOUTH);
		f.add(hplb,BorderLayout.SOUTH);
		*/

        //아이템에 클릭을 했을 때 처리를 하기 위해서는 리스너 등록
        list.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                //e(이벤트)에서 getItem은 인덱스번호
                //list에서 getItem은 내용을 의미
                System.out.println(list.getItem((int) e.getItem()));
                System.out.println(list.getSelectedItem());
                System.out.println(list.getSelectedItem().split(" ")[0]);
                System.out.println(list.getSelectedItem().split(" ")[1]);
                System.out.println(list.getSelectedItem().split(" ")[2]);
                String[] datas = list.getSelectedItem().split(" ");
                idlb.setText("id:" + datas[0]);
                namelb.setText("name:" + datas[1]);
                hplb.setText("hp:" + datas[2]);

            }
        });


    }

}