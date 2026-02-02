package BookFrameProgram;

import java.awt.*;
import java.awt.event.*;

public class BookFrame extends Frame {
    BookManager bm = new BookManager();

    // 메인메뉴 부품
    Button menuInsertbtn;
    Button menuAllprintbtn;
    Button menuViewbtn;
    Button menuUpdatebtn;
    Button menuDeletebtn;

    // 입력 부품 (도서명, 저자, ISBN 대응)
    Label insertTitlelb;
    Label insertAuthorlb;
    Label insertIsbnlb;
    TextField insertTitletf;
    TextField insertAuthortf;
    TextField insertIsbntf;
    Button insertInsertbtn;

    // 전체 출력 부품
    List listBox;
    Label viewIdlb, viewTitlelb, viewAuthorlb, viewIsbnlb;

    // 찾기 부품
    Label updateTitlelb;
    TextField updateaSearchtf;
    Button updateSearchbtn;
    List updateSearchListBox;

    // 수정 부품
    Label editTitlelb;
    Label editAuthorlb;
    Label editIsbnlb;
    TextField editTitletf;
    TextField editAuthortf;
    TextField editIsbntf;
    Button editbtn;

    // 삭제 부품
    Label delTitlelb;
    TextField delTitletf;
    Button delbtn;

    public BookFrame() {
        setTitle("도서 관리 프로그램1");
        setBounds(0, 0, 400, 700);
        setLayout(new FlowLayout());
        setVisible(true);

        // 윈도우 닫기 이벤트 처리
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 메인메뉴 부품 만들기
        menuInsertbtn = new Button("add Book");
        menuAllprintbtn = new Button("print all Book");
        menuViewbtn = new Button("search Book");
        menuUpdatebtn = new Button("update Book");
        menuDeletebtn = new Button("delete Book");

        // 부품에 대한 설정
        menuInsertbtn.setPreferredSize(new Dimension(300, 50));
        menuAllprintbtn.setPreferredSize(new Dimension(300, 50));
        menuViewbtn.setPreferredSize(new Dimension(300, 50));
        menuUpdatebtn.setPreferredSize(new Dimension(300, 50));
        menuDeletebtn.setPreferredSize(new Dimension(300, 50));

        // 부품을 추가하기
        add(menuInsertbtn);
        add(menuAllprintbtn);
        add(menuViewbtn);
        add(menuUpdatebtn);
        add(menuDeletebtn);

        // insert 기능 부품 생성 및 초기화
        insertTitlelb = new Label("도서명:");
        insertAuthorlb = new Label("저자:");
        insertIsbnlb = new Label("ISBN:");
        insertTitletf = new TextField();
        insertAuthortf = new TextField();
        insertIsbntf = new TextField();
        insertInsertbtn = new Button("input Book");

        insertTitlelb.setVisible(false);
        insertAuthorlb.setVisible(false);
        insertIsbnlb.setVisible(false);
        insertTitletf.setVisible(false);
        insertAuthortf.setVisible(false);
        insertIsbntf.setVisible(false);
        insertInsertbtn.setVisible(false);

        add(insertTitlelb); add(insertTitletf);
        add(insertAuthorlb); add(insertAuthortf);
        add(insertIsbnlb); add(insertIsbntf);
        add(insertInsertbtn);

        insertTitlelb.setPreferredSize(new Dimension(60, 50));
        insertAuthorlb.setAlignment(Label.RIGHT);
        insertTitletf.setColumns(20);
        insertAuthorlb.setPreferredSize(new Dimension(60, 50));
        insertAuthortf.setColumns(20);
        insertIsbnlb.setPreferredSize(new Dimension(60, 50));
        insertIsbntf.setColumns(20);
        insertInsertbtn.setPreferredSize(new Dimension(300, 50));

        // menuInsertbtn 이벤트 처리
        menuInsertbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(); // 모든 부품 숨기기
                insertTitlelb.setVisible(true);
                insertTitletf.setVisible(true);
                insertAuthorlb.setVisible(true);
                insertAuthortf.setVisible(true);
                insertIsbnlb.setVisible(true);
                insertIsbntf.setVisible(true);
                insertInsertbtn.setVisible(true);

                revalidate();
                repaint();

                insertInsertbtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bm.insert(insertTitletf.getText(),
                                insertAuthortf.getText(),
                                insertIsbntf.getText());
                        insertTitletf.setText("");
                        insertAuthortf.setText("");
                        insertIsbntf.setText("");
                        insertTitletf.setFocusable(true);
                    }
                });
            }
        });

        // 전체출력 부품 설정
        listBox = new List(10);
        listBox.setPreferredSize(new Dimension(500, 0));
        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());
        panel.add(listBox);
        add(panel);
        listBox.setVisible(false);

        // 전체 리스트 보기 버튼 (ButtonFunc가 구현되어 있어야 함)
        // menuAllprintbtn.addActionListener(new ButtonFunc(this, bm.getList()));

        // 상세보기 레이블 설정
        viewIdlb = new Label("id:");
        viewIdlb.setBackground(Color.ORANGE);
        viewIdlb.setPreferredSize(new Dimension(200, 30));
        viewIdlb.setVisible(false);
        add(viewIdlb);

        viewTitlelb = new Label("title:");
        viewTitlelb.setBackground(Color.YELLOW);
        viewTitlelb.setPreferredSize(new Dimension(200, 30));
        viewTitlelb.setVisible(false);
        add(viewTitlelb);

        viewAuthorlb = new Label("author:");
        viewAuthorlb.setBackground(Color.cyan);
        viewAuthorlb.setPreferredSize(new Dimension(200, 30));
        viewAuthorlb.setVisible(false);
        add(viewAuthorlb);

        viewIsbnlb = new Label("isbn:");
        viewIsbnlb.setBackground(Color.LIGHT_GRAY);
        viewIsbnlb.setPreferredSize(new Dimension(200, 30));
        viewIsbnlb.setVisible(false);
        add(viewIsbnlb);

        // 리스트 선택 시 상세보기 이벤트
        listBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                setVisible();
                listBox.setVisible(true);
                viewIdlb.setVisible(true);
                viewTitlelb.setVisible(true);
                viewAuthorlb.setVisible(true);
                viewIsbnlb.setVisible(true);

                int id = Integer.parseInt(listBox.getSelectedItem().split(" ")[0]);
                for (d260122_03_BookProgram_Report.Book b : bm.getList()) {
                    if (b.getId() == id && listBox.getSelectedIndex() != 0) {
                        viewIdlb.setText("id:" + b.getId());
                        viewTitlelb.setText("title:" + b.getAuthor()); // 원본 필드 매칭에 따라 수정 가능
                        viewAuthorlb.setText("author:" + b.getIsbn());
                        viewIsbnlb.setText("isbn:" + b.getDate());
                    }
                }
                revalidate();
                repaint();
            }
        });

        // 찾기 부품 초기화
        updateTitlelb = new Label("search title: ");
        updateaSearchtf = new TextField(20);
        updateSearchbtn = new Button("search");
        updateSearchListBox = new List();

        updateTitlelb.setVisible(false);
        updateaSearchtf.setVisible(false);
        updateSearchbtn.setVisible(false);
        updateSearchListBox.setVisible(false);

        add(updateTitlelb); add(updateaSearchtf); add(updateSearchbtn); add(updateSearchListBox);

        menuViewbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                updateTitlelb.setVisible(true);
                updateaSearchtf.setVisible(true);
                updateSearchbtn.setVisible(true);
                revalidate();
                repaint();
            }
        });

        updateSearchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                updateTitlelb.setVisible(true);
                updateaSearchtf.setVisible(true);
                updateSearchbtn.setVisible(true);
                updateSearchListBox.setVisible(true);

                // 검색 로직 (저자명으로 검색하도록 매니저와 연동)
                bm.selectByName(updateaSearchtf.getText());

                revalidate();
                repaint();
            }
        });

        // 수정 부품 초기화
        editTitlelb = new Label("edit Title: ");
        editTitletf = new TextField(20);
        editAuthorlb = new Label("edit Author: ");
        editAuthortf = new TextField(20);
        editIsbnlb = new Label("edit Isbn: ");
        editIsbntf = new TextField(20);
        editbtn = new Button("update");

        editTitlelb.setVisible(false); editTitletf.setVisible(false);
        editAuthorlb.setVisible(false); editAuthortf.setVisible(false);
        editIsbnlb.setVisible(false); editIsbntf.setVisible(false);
        editbtn.setVisible(false);

        add(editTitlelb); add(editTitletf); add(editAuthorlb);
        add(editAuthortf); add(editIsbnlb); add(editIsbntf); add(editbtn);

        menuUpdatebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                editTitlelb.setVisible(true); editTitletf.setVisible(true);
                editAuthorlb.setVisible(true); editAuthortf.setVisible(true);
                editIsbnlb.setVisible(true); editIsbntf.setVisible(true);
                editbtn.setVisible(true);
            }
        });

        // 삭제 부품 초기화
        delTitlelb = new Label("삭제할 도서명 입력");
        delTitletf = new TextField(20);
        delbtn = new Button("삭제");
        delTitlelb.setVisible(false); delTitletf.setVisible(false); delbtn.setVisible(false);

        add(delTitlelb); add(delTitletf); add(delbtn);

        menuDeletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                delTitlelb.setVisible(true);
                delTitletf.setVisible(true);
                delbtn.setVisible(true);
            }
        });

        delbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible();
                new DialogFrame(delbtn); // 다이얼로그 호출
            }
        });
    }

    public List getListBox() { return listBox; }
    public void setListBox(List listBox) { this.listBox = listBox; }

    // 모든 부품을 숨기는 함수 (전화번호부와 동일한 이름)
    public void setVisible() {
        insertTitlelb.setVisible(false); insertAuthorlb.setVisible(false);
        insertIsbnlb.setVisible(false); insertTitletf.setVisible(false);
        insertAuthortf.setVisible(false); insertIsbntf.setVisible(false);
        insertInsertbtn.setVisible(false);

        viewIdlb.setVisible(false); viewTitlelb.setVisible(false);
        viewAuthorlb.setVisible(false); viewIsbnlb.setVisible(false);
        listBox.setVisible(false);

        updateTitlelb.setVisible(false); updateaSearchtf.setVisible(false);
        updateSearchbtn.setVisible(false); updateSearchListBox.setVisible(false);

        editTitlelb.setVisible(false); editTitletf.setVisible(false);
        editAuthorlb.setVisible(false); editAuthortf.setVisible(false);
        editIsbnlb.setVisible(false); editIsbntf.setVisible(false);
        editbtn.setVisible(false);

        delTitlelb.setVisible(false); delTitletf.setVisible(false);
        delbtn.setVisible(false);
    }
}

// 다이얼로그 클래스 (PhonebookFrame의 DialogFrame과 동일)
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

    public DialogFrame(Button button) { this.button = button; }
    public DialogFrame() {}
    public Button getButton() { return button; }
    public Dialog getDialog() { return dialog; }
}