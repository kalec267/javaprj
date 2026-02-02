package d260127_Phonebook_Report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFunc implements ActionListener {
    PhonebookFrame f;
    java.util.List<Phonebook> datas;

    public ButtonFunc(PhonebookFrame phonebookFrame, java.util.List<Phonebook> list) {
        this.f = phonebookFrame;
        this.datas = list;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.setVisible();
        f.getListBox().removeAll();
        String header = "id name hp                               ";
        f.getListBox().add(header);
        for (Phonebook p : datas) {
            f.getListBox().add(p.getId() + " " + p.getName() + " " + p.getHp());
        }
        f.getListBox().setVisible(true);
        f.revalidate();
        f.repaint();
        //list.setVisible(false);

    }

}