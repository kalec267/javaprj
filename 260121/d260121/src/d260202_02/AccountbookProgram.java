package d260202_02;

import java.io.IOException;
import java.util.Scanner;

public class AccountbookProgram {

    AccountbookManager ab;
    Scanner scan = new Scanner(System.in);
    String category;
    int menu;

    public AccountbookProgram(AccountbookDAO dao) throws IOException {
        ab = new AccountbookManager(dao);

        while (true) {
            switch (menu()) {
                case 3:
                    selectByCategory();
                    break;
            }

        }
    }

    public int menu(){
        System.out.print("카테고리 검색은 3번");
        return Integer.parseInt(scan.nextLine());
    }

    public void selectByCategory() throws IOException {
        System.out.println("찾을 카테고리를 입력하세요.");
        category = scan.nextLine();
        ab.selectByCategory(category);
        System.in.read();
    }
}
