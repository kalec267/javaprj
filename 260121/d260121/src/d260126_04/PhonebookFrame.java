package d260126_04;

import d260122_01_v2.PhonebookManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhonebookFrame extends Frame {

    PhonebookManager pm = new PhonebookManager();



    public PhonebookFrame(){
        setTitle("전화번호부");
        setBounds(0,0,400,700);
        setLayout(new FlowLayout());
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);
            }
        });
//        부품 만들기
        Button insertbtn=new Button("전화번호부 입력");
        Button allprintbtn=new Button("전화번호부 전체출력");
        Button viewbtn=new Button("전화번호부 찾기");
        Button updatebtn=new Button("전화번호부 수정");
        Button deletebtn=new Button("전화번호부 삭제");

        insertbtn.setPreferredSize(new Dimension(300, 50));
        allprintbtn.setPreferredSize(new Dimension(300, 50));
        viewbtn.setPreferredSize(new Dimension(300, 50));
        updatebtn.setPreferredSize(new Dimension(300, 50));
        deletebtn.setPreferredSize(new Dimension(300, 50));

//        부품 추가하기
        add(insertbtn);
        add(allprintbtn);
        add(viewbtn);
        add(updatebtn);
        add(deletebtn);

//        추가한 부품을 처리하기 위한 버튼 이벤트 추가
        insertbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label namelb=new Label("이름: ");
                Label hplb=new Label("전화번호: ");
                Label emaillb=new Label("이메일: ");

                TextField nametf=new TextField();
                TextField hptf=new TextField();
                TextField emailtf=new TextField();

                Button insertbtn = new Button("전화번호부 입력");
                add(namelb);
                add(nametf);

                add(hplb);
                add(hptf);

                add(emaillb);
                add(emailtf);

                add(insertbtn);

                namelb.setPreferredSize(new Dimension(100, 50));
                namelb.setAlignment(Label.RIGHT);
                nametf.setColumns(30);

                hplb.setPreferredSize(new Dimension(100, 50));
                hptf.setColumns(30);

                emaillb.setPreferredSize(new Dimension(100, 50));
                emailtf.setColumns(30);

                insertbtn.setPreferredSize(new Dimension(300, 50));
//                화면을 새로 그리기 위해서는 2개의 함수 동시 호출
                revalidate();
                repaint();

//                insertbtn 눌렀을 때 이벤트 처리
                insertbtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(nametf.getText());
                        System.out.println(hptf.getText());
                        System.out.println(emailtf.getText());

                        pm.insert(nametf.getText(), hptf.getText(), emailtf.getText());
                        System.out.println(pm.getList());
                        nametf.setText("");
                        hptf.setText("");
                        emailtf.setText("");
                        nametf.setFocusable(true);

                    }
                });
            }
        });

    }

}
