package d260122_03_BookProgram_Report;

import java.io.IOException;
import java.util.Scanner;

public class BookProgram {

    Scanner scan = new Scanner(System.in);
    BookManager bm = new BookManager();

    String searchAuthor=null;
    String author, isbn, date;
    int id;

    public BookProgram() throws IOException {
        while(true) {
            switch(menu()){
                case 1:
                    insert();
                    break;
                case 2:
                    views();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 0:
                    System.out.println("도서관리 프로그램을 종료합니다...");
                    System.exit(0);
                default:
                    System.out.println("0번부터 5번까지만 입력하세요.");
            }
        }
    }

    public int menu() {
        System.out.println("1. 도서 정보 등록");
        System.out.println("2. 모든 도서 출력");
        System.out.println("3. 도서 찾기");
        System.out.println("4. 도서 정보 수정");
        System.out.println("5. 도서 정보 삭제");

        return scan.nextInt();
    }

    public void insert() {
        System.out.print("도서 ID를 입력하세요.");
        id=scan.nextInt();

        System.out.print("저자를 입력하세요.");
        author= scan.next();

        System.out.print("ISBN을 입력하세요.");
        isbn=scan.next();

        System.out.print("발행일자를 입력하세요.");
        date= scan.next();

        bm.insert(author, isbn, date);
    }

    public void views() throws IOException{
        bm.select();
        System.in.read();
    }

    public void view() throws IOException {
        System.out.print("찾을 저자를 입력하세요.");
        searchAuthor=scan.next();
        bm.selectByName(searchAuthor);
        System.in.read();
    }

    public void update() {
        if(scan.hasNextLine()){
            scan.nextLine();
        }
        System.out.print("수정할 저자의 이름 입력");
        searchAuthor=scan.nextLine();

        if(bm.isExist(searchAuthor)){
            System.out.print("변경할 도서 이름을 입력하세요[변경사항이 없으면 enter]");
            author = scan.nextLine();
            System.out.print("변경할 ISBN을 입력하세요[변경사항이 없으면 enter]");
            isbn = scan.nextLine();
            System.out.print("변경할 날짜를 입력하세요[변경사항이 없으면 enter]");
            date = scan.nextLine();

            Book b=bm.getBookByName(searchAuthor);
            if(!author.equals("")){
                b.setAuthor(author);
            }
            if(!isbn.equals((""))){
                b.setIsbn(isbn);
            }
            if(!date.equals("")){
                b.setDate(date);
            }
            bm.update(searchAuthor, b);
        }else{
            System.out.println("수정할 도서 정보가 없습니다.");
        }
    }

    public void delete(){
        System.out.print("삭제할 도서를 입력하세요.");
        searchAuthor=scan.next();
        if(bm.isExist(searchAuthor)){
            bm.delete(searchAuthor);
        }
    }

    private void booksave(){
        System.out.print("저장할 파일명: ");
        String filename=scan.next();

        if(!bm.filesave(filename)){
            System.out.println("파일 저장 실패");
            return;
        }
        System.out.println("파일 저장 성공");
    }

    private void bookload(){
        System.out.print("로드할 파일 입력: ");
        String filename=scan.next();
        bm.fileload(filename);
    }

    private void selectByName(String searchAuthor) {

    }


}
