package d260128;

import java.awt.*;

public class Main1 {
    public static void main(String[] args) {
//        awt에서 Frame 부품정리
        /*TextField, Label, Button, List, Checkbox(체크상자),
        CheckboxGroup(라디오버튼, 여러개 중 한 개 선택)
        Choice(선택상자/ 여러개 또는 한 개 선택 가능)
        ScrollBar
        */

        Frame f = new Frame();
        f.setTitle("부품 만들기");
//        f.setBackground(Color.LIGHT_GRAY);
        f.setBounds(0, 0, 500, 700);
        f.setLayout(new FlowLayout());
        f.setVisible(true);

        TextArea tbox = new TextArea(10, 30);
        f.add(tbox);
        tbox.setText("초기값");
        System.out.println(tbox.getText());

        Checkbox cb1 = new Checkbox("동의함");
        Checkbox cb2 = new Checkbox("알림 받기", true); // 기본 체크
        cb2.setState(false);
        f.add(cb1);
        f.add(cb2);
        System.out.println(cb2.getState()); //체크한거 확인, 상태확인
        System.out.println(cb2.getLabel()); //라벨 이름 가져오기
        System.out.println(cb2.getName()); //체크박스의 이름 가져오기

        CheckboxGroup gen = new CheckboxGroup();
        Checkbox male = new Checkbox("남자", gen, true);
        Checkbox female = new Checkbox("여자", gen, false);
        f.add(male);
        f.add(female);
        System.out.println(gen.getSelectedCheckbox());
//        선택된거에서 라벨 확인하기
        System.out.println(gen.getSelectedCheckbox().getLabel());

//        choice는 다중선택 불가 (다중선택시 list 사용)
        Choice choice = new Choice();
        choice.add("java");
        choice.add("파이썬");
        choice.add("html");
        f.add(choice);
//        위치, 선택도어있는 인덱스를 가리키면 위치 확인 가능
        System.out.println(choice.getSelectedIndex());
        System.out.println(choice.getSelectedItem());
        System.out.println(choice.getSelectedObjects());

        f.revalidate();
        f.repaint();


    }
}
