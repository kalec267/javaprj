package d260126_03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PhonebookFrame extends Frame implements WindowListener {
    public void main(String[] args) {
        setBounds(0, 0, 500, 200);
        setTitle("전화번호부");
        setLayout(new FlowLayout());

        CardLayout mainlayout = new CardLayout();
        Panel mainPanel = new Panel();
        setLayout(mainlayout);
//        f.setLayout(new CardLayout(5, 1)); //5행 1열

        add(mainPanel);
        setVisible(true);

        mainPanel.setBackground(Color.BLACK);

//        전화번호부 입력 패널(부품을 만들고 상위 부품에 추가)
        Panel insertPanel = new Panel();
        insertPanel.setLayout(new CardLayout());
        mainPanel.add(insertPanel, "insertPanel");
        insertPanel.setBackground(Color.YELLOW);

        Panel allPrintPanel = new Panel();
        allPrintPanel.setLayout(new CardLayout());
        mainPanel.add(allPrintPanel, "allPrintPanel");
        allPrintPanel.setBackground(Color.ORANGE);

//        찾기, 수정, 삭제 패널
        Panel viewPanel = new Panel();
        viewPanel.setLayout(new CardLayout());
        mainPanel.add(viewPanel, "viewPanel");
        viewPanel.setBackground(Color.BLUE);

//        mainPanel에 버튼 부품을 추가하기
        Button insertbtn=new Button("입력버튼");
        mainPanel.add(insertbtn);
        insertbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("입력버튼 클릭");
                mainlayout.show(mainPanel, "insertPanel");
            }
        });


        setLayout(new GridLayout(5, 1, 10, 5)); //5행 1열 간격 추가

        for (int i = 0; i < 5; i++) {
            add(new Button("버튼" + i));
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("닫기");
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
