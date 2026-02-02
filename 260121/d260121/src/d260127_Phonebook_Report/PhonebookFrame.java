package d260127_Phonebook_Report;

import java.awt.*;
import java.awt.event.*;

public class PhonebookFrame extends Frame {
    PhonebookManager pm = new PhonebookManager();

    //        메인메뉴 부품
    Button menuInsertbtn;
    Button menuAllprintbtn;
    Button menuViewbtn;
    Button menuUpdatebtn;
    Button menuDeletebtn;

    //        입력 부품
    Label insertNamelb;
    Label insertHplb;
    Label insertEmaillb;
    TextField insertNametf;
    TextField insertHptf;
    TextField insertEmailtf;
    Button insertInsertbtn;
    //        전체 출력 부품
    List listBox;
    Label viewIdlb, viewNamelb, viewHplb, viewEmaillb;


    //     찾기 부품
    Label updateNamelb;
    TextField updateaSearchtf;
    Button updateSearchbtn;
    List updateSearchListBox;

    //    수정 부품
    Label editNamelb;
    Label editHplb;
    Label editEmaillb;

    TextField editNametf;
    TextField editHptf;
    TextField editEmailtf;

    Button editbtn;

    //    삭제 부품
    Label delNamelb;
    TextField delNametf;
    Button delbtn;

    public PhonebookFrame() {
        setTitle("전화번호부 프로그램1");
        setBounds(0, 0, 400, 700);
        setLayout(new FlowLayout());
        setVisible(true);
        //윈도우 닫기 이벤트 처리
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //메인메뉴 부품 만들기
        menuInsertbtn = new Button("add Phonebook");
        menuAllprintbtn = new Button("print all Phonebook");
        menuViewbtn = new Button("search Phonebook");
        menuUpdatebtn = new Button("update Phonebook");
        menuDeletebtn = new Button("delete Phonebook");

//         부품에 대한 설정
        menuInsertbtn.setPreferredSize(new Dimension(300, 50));
        menuAllprintbtn.setPreferredSize(new Dimension(300, 50));
        menuViewbtn.setPreferredSize(new Dimension(300, 50));
        menuUpdatebtn.setPreferredSize(new Dimension(300, 50));
        menuDeletebtn.setPreferredSize(new Dimension(300, 50));
        //부품을 추가하기
        add(menuInsertbtn);
        add(menuAllprintbtn);
        add(menuViewbtn);
        add(menuUpdatebtn);
        add(menuDeletebtn);

//        insert 기능에 대한 부품을 만들고 add 해야함
        insertNamelb = new Label("이름:");
        insertHplb = new Label("전화번호:");
        insertEmaillb = new Label("이메일:");
        insertNametf = new TextField();
        insertHptf = new TextField();
        insertEmailtf = new TextField();
        insertInsertbtn = new Button("input Phonebook");

        insertNamelb.setVisible(false);
        insertHplb.setVisible(false);
        insertEmaillb.setVisible(false);
        insertNametf.setVisible(false);
        insertHptf.setVisible(false);
        insertEmailtf.setVisible(false);
        insertInsertbtn.setVisible(false);

        add(insertNamelb);
        add(insertNametf);
        add(insertHplb);
        add(insertHptf);
        add(insertEmaillb);
        add(insertEmailtf);
        add(insertInsertbtn);

        insertNamelb.setPreferredSize(new Dimension(60, 50));
        insertHplb.setAlignment(Label.RIGHT);
        insertNametf.setColumns(20);
        insertHplb.setPreferredSize(new Dimension(60, 50));
        insertHptf.setColumns(20);
        insertEmaillb.setPreferredSize(new Dimension(60, 50));
        insertEmailtf.setColumns(20);
        insertInsertbtn.setPreferredSize(new Dimension(300, 50));


//        updateNamelb.setPreferredSize(new Dimension(60, 50));
//        updateaSearchtf.setColumns(20);
//        updateSearchbtn.setPreferredSize(new Dimension(300, 50));

        //추가한 부품을 처리하기 위한 버튼 이벤트 추가
        menuInsertbtn.addActionListener(new ActionListener() {

            //입력에 대한 부품
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                insertNamelb.setVisible(true);
                insertNametf.setVisible(true);
                insertHplb.setVisible(true);
                insertHptf.setVisible(true);
                insertEmaillb.setVisible(true);
                insertEmailtf.setVisible(true);
                insertInsertbtn.setVisible(true);

                //화면을 새로 그리기 위해서는 2개의 함수가 동시 호출
                revalidate();
                repaint();
                //insertbtn을 눌렀을 때 이벤트처리
                insertInsertbtn.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(insertNametf.getText());
                        System.out.println(insertHptf.getText());
                        System.out.println(insertEmailtf.getText());
                        pm.insert(insertNametf.getText(),
                                insertHptf.getText(),
                                insertEmailtf.getText());
                        System.out.println(pm.getList());
                        insertNametf.setText("");
                        insertHptf.setText("");
                        insertEmailtf.setText("");
                        insertNametf.setFocusable(true);
                    }
                });
            }
        });

//        전체출력 부품생성 및 설정
        listBox = new List(10);
        listBox.setPreferredSize(new Dimension(500, 0));
        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());
        panel.setSize(500, 0);
        panel.add(listBox);

        add(panel);
        listBox.setVisible(false);

//        전체 리스트 보기
        menuAllprintbtn.addActionListener(new ButtonFunc(this, pm.getList()));

        //상세보기 BorderLayout의 south에 구현
        viewIdlb = new Label("id:");
        viewIdlb.setBackground(Color.ORANGE);
        viewIdlb.setPreferredSize(new Dimension(200, 30));
        viewIdlb.setVisible(false);
        add(viewIdlb);

        viewNamelb = new Label("name:");
        viewNamelb.setBackground(Color.YELLOW);
        viewNamelb.setPreferredSize(new Dimension(200, 30));
        viewNamelb.setVisible(false);
        add(viewNamelb);

        viewHplb = new Label("hp:");
        viewHplb.setBackground(Color.cyan);
        viewHplb.setPreferredSize(new Dimension(200, 30));
        viewHplb.setVisible(false);
        add(viewHplb);

        viewEmaillb = new Label("email:");
        viewEmaillb.setBackground(Color.LIGHT_GRAY);
        viewEmaillb.setPreferredSize(new Dimension(200, 30));
        viewEmaillb.setVisible(false);
        add(viewEmaillb);

        //    전체 리스트에서 하나의 아이템을 선택했을 때 상세보기
//        listBox.addItemListener(new ButtonFunc(this, pm.getList()));
        /*
         * 1. 리스트를 클릭할 때
         * 2. 리스트의 정보를 가져온 후 분리
         * 3. 분리된 데이터를 레이블에 표시 (레이블을 생성, 설정, 추가)*/
        listBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setVisible();
                listBox.setVisible(true);
                viewIdlb.setVisible(true);
                viewNamelb.setVisible(true);
                viewHplb.setVisible(true);
                viewEmaillb.setVisible(true);

//              아래의 데이터는 프레임에서 리스트박스에 있는 내용이므로 이메일 확인 불가
//                String[] datas = listBox.getSelectedItem().split(" ");

//                listBox에서 id를 구하고 전체 리스트 정보에서 id와 비교하여 같은 id를 출력하시오
                int id = Integer.parseInt(listBox.getSelectedItem().split(" ")[0]);
                for (Phonebook p : pm.getList()) {
                    if (p.getId() == id && listBox.getSelectedIndex() != 0) {
                        System.out.println(p);
                        viewIdlb.setText("id:" + p.getId());
                        viewNamelb.setText("name:" + p.getName());
                        viewHplb.setText("hp:" + p.getHp());
                        viewEmaillb.setText("email:" + p.getEmail());
                    }
                }

                Phonebook p = pm.getList().get((int) e.getItem());


                revalidate();
                repaint();
            }
        });


/*
        1. 찾기에 필요한 부품등록(맴버변수), 생성(new), 설정(set, 레이블, 편집창, 버튼)
        2. 전화번호부 찾기 버튼 클릭했을 때 이벤트 등록(리스너 등록)
        3. 화면에 이름찾기 창이 나타나도록 처리(리스너 코드 구현)
        4. 이름찾기 버튼을 클랙했을 때 리스트 결과 확인
        5. 리스트를 선택하면 상세보기
        */
        updateNamelb = new Label("search name: ");
        updateaSearchtf = new TextField(20);
        updateSearchbtn = new Button(("search"));

        updateNamelb.setVisible(false);
        updateaSearchtf.setVisible(false);
        updateSearchbtn.setVisible(false);

        updateSearchListBox = new List();
        updateSearchListBox.setVisible(false);

//        프레임에 추가
        add(updateNamelb);
        add(updateaSearchtf);
        add(updateSearchbtn);

        add(updateSearchListBox);

        menuViewbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                updateNamelb.setVisible(true);
                updateaSearchtf.setVisible(true);
                updateSearchbtn.setVisible(true);
                revalidate();
                repaint();
            }
        });

//        찾기 버튼 실행
        updateSearchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                pm.selectByName(updateaSearchtf.getText());

                setVisible();
                updateNamelb.setVisible(true);
                updateaSearchtf.setVisible(true);
                updateSearchbtn.setVisible(true);

                updateSearchListBox.setVisible(true);

                String search = updateaSearchtf.getText();
                Phonebook p = pm.selectByName(search);
                if (p != null) {
                    updateSearchListBox.add(p.getId() + " " + p.getName());
                }

                Button editbtn = new Button("수정");
                Button deletebtn = new Button("삭제");
                Button menubtn = new Button("메뉴");

                editbtn.setVisible(true);
                deletebtn.setVisible(true);
                menubtn.setVisible(true);
                revalidate();
                repaint();
            }
        });

//        검색한 리스트 박스를 클릭했을 때
        updateSearchListBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
//                상세보기를 재활용
                setVisible();
                listBox.setVisible(true);
                viewIdlb.setVisible(true);
                viewNamelb.setVisible(true);
                viewHplb.setVisible(true);
                viewEmaillb.setVisible(true);
            }
        });

        editNamelb = new Label("edit Name: ");
        editNametf = new TextField(20);
        editHplb = new Label("edit Hp: ");
        editHptf = new TextField(20);
        editEmaillb = new Label("edit Email");
        editEmailtf = new TextField(20);
        editbtn = new Button("update");

        editNamelb.setVisible(false);
        editNametf.setVisible(false);
        editHplb.setVisible(false);
        editHptf.setVisible(false);
        editEmaillb.setVisible(false);
        editEmailtf.setVisible(false);
        editbtn.setVisible(false);

        add(editNamelb);
        add(editNametf);
        add(editHplb);
        add(editHptf);
        add(editEmaillb);
        add(editEmailtf);
        add(editbtn);


        menuUpdatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();

                editNamelb.setVisible(true);
                editNametf.setVisible(true);
                editHplb.setVisible(true);
                editHptf.setVisible(true);
                editEmaillb.setVisible(true);
                editEmailtf.setVisible(true);
                editbtn.setVisible(true);

            }
        });

        editbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
            }
        });


        delNamelb = new Label("삭제할 이름 입력");
        delNametf = new TextField(20);
        delbtn = new Button("삭제");
        delNamelb.setVisible(false);
        delNametf.setVisible(false);
        delbtn.setVisible(false);
        add(delNamelb);
        add(delNametf);
        add(delbtn);

        menuDeletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                System.out.println("test");

                delNamelb.setVisible(true);
                delNametf.setVisible(true);
                delbtn.setVisible(true);
            }
        });

        delbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                System.out.println("삭제버튼 눌림");
                new DialogFrame(delbtn);
            }
        });
    }


    public List getListBox() {

        return listBox;
    }

    public void setListBox(List listBox) {
        this.listBox = listBox;
    }

    public void setVisible() {
        insertNamelb.setVisible(false);
        insertHplb.setVisible(false);
        insertEmaillb.setVisible(false);
        insertNametf.setVisible(false);
        insertHptf.setVisible(false);
        insertEmailtf.setVisible(false);
        insertInsertbtn.setVisible(false);

        viewIdlb.setVisible(false);
        viewNamelb.setVisible(false);
        viewHplb.setVisible(false);
        viewEmaillb.setVisible(false);

        listBox.setVisible(false);

        updateNamelb.setVisible(false);
        updateaSearchtf.setVisible(false);
        updateSearchbtn.setVisible(false);
        updateSearchListBox.setVisible(false);

        editNamelb.setVisible(false);
        editNametf.setVisible(false);
        editHplb.setVisible(false);
        editHptf.setVisible(false);
        editEmaillb.setVisible(false);
        editEmailtf.setVisible(false);
        editbtn.setVisible(false);

        delNamelb.setVisible(false);
        delNametf.setVisible(false);
        delbtn.setVisible(false);


    }
}

class DialogFrame extends Frame {
    private Button button;
    private Dialog dialog;

    public DialogFrame(Button button, Button button1) {
        this.button = button1;
        setBounds(100, 100, 450, 300);
        setLayout(new FlowLayout());
        setVisible(true);

        button = new Button("삭제하기");
        add(button);

        dialog = new Dialog(this, "삭제하기", true);
        dialog.setBounds(100, 100, 450, 300);
        dialog.setVisible(true);

    }

    public DialogFrame(Button button) {
        this.button = button;
    }

    public DialogFrame() {

    }

    public Button getButton() {
        return button;
    }
    public Dialog getDialog() {
        return dialog;
    }
}

