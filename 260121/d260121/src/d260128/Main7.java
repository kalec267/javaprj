package d260128;

import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Main7 {
    public static void main(String[] args) {
        MenuBarFrame f=new MenuBarFrame();
//        f.copyitem.addActionListener(f);

        f.openitem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("open item 선택!!");
                FileDialog filedialog
                        =new FileDialog(f, "open file", FileDialog.LOAD);
                filedialog.setVisible(true);

//                파일 경로, 파일명을 추출
                System.out.println(filedialog.getDirectory());
                System.out.println(filedialog.getFile());

            }
        });
    }
}


class MenuBarFrame extends Frame  {
//    객체 선언
    MenuBar menubar;

    Menu filemenu;
    MenuItem newitem;
    MenuItem openitem;

    Menu editmenu;
    MenuItem copyitem;

    public MenuBarFrame (){
        setTitle("메뉴바 만들기");
        setBounds(0,0,500,600);
        setVisible(true);

        menubar = new MenuBar();

        filemenu=new Menu("File");
        newitem=new MenuItem("New");
        openitem=new MenuItem("Open");

        editmenu=new Menu("Edit");
        copyitem=new MenuItem("Copy");

//        메뉴바는 역조림 해야함
//        메뉴 아이템 추가
        filemenu.add(newitem);
        filemenu.add(openitem);

        editmenu.add(copyitem);

//        메뉴바에 메뉴를 추가
        menubar.add(filemenu);
        menubar.add(editmenu);

//        프레임에 메뉴바를 추가
        setMenuBar(menubar);

    }

}