package BookFrameProgram;

import d260122_03_BookProgram_Report.Book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookManager {
    private List<Book> bk = new ArrayList<Book>();

    public BookManager() {
        fileload("book.txt");
    }

    public boolean filesave(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            int i = 0;
            for (Book b : bk) {
                bw.write(
                        b.getId() + " " +
                                b.getAuthor() + " " +
                                b.getIsbn() + " " +
                                b.getDate()
                );
                if (i != (bk.size() - 1)) {
                    bw.newLine();
                }
                i++;
            }
            bw.flush();
            bw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void fileload(String filename) {
        // bk=new Book[100];
        // bk.removeAll(null);
        bk = new ArrayList<Book>();
        // index=0;
        // book.txt 파일을 메모리로 로드
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String data = "";
            while ((data = br.readLine()) != null) {
                insert(
                        Integer.parseInt(data.split(" ")[0]),
                        data.split(" ")[1],
                        data.split(" ")[2],
                        data.split(" ")[3]
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filesave() {

    }

    public void insert(int id, String author, String isbn, String date) {
        // bk[index]=new Book(id, author, isbn, date);
        bk.add(new Book(id, author, isbn, date));
        // index=index+1;
    }

    public void insert(String author, String isbn, String date) {
        // bk[index]=new Book(index+1, author, isbn, date);
        bk.add(new Book(bk.size() + 1, author, isbn, date));
        // index=index+1;
    }

    public void select() {
		/*
		for(int i=0;i<index;i++) {
			if(bk[i].getId()!=0) {
				System.out.println(bk[i]);
			}
		}
		*/
        for (Book b : bk) {
            if (b.getId() != 0) {
                System.out.println(b);
            }
        }
    }

    public void update(String searchAuthor, Book b) {
		/*
		for(int i=0;i<index;i++) {
			if(searchAuthor.equals(bk[i].getAuthor())) {
				if(b.getAuthor()!=null) {bk[i].setAuthor(b.getAuthor());}
				if(b.getIsbn()!=null) {bk[i].setIsbn(b.getIsbn());}
				if(b.getDate()!=null) {bk[i].setDate(b.getDate());}
				return;
			}
		}
		*/
        for (Book _b : bk) {
            if (searchAuthor.equals(_b.getAuthor())) {
                if (b.getAuthor() != null) {
                    _b.setAuthor(b.getAuthor());
                }
                if (b.getIsbn() != null) {
                    _b.setIsbn(b.getIsbn());
                }
                if (b.getDate() != null) {
                    _b.setDate(b.getDate());
                }
                return;
            }
        }
    }

    public void delete(String author) {
		/*
		for(int i=0;i<index;i++) {
			if(bk[i].getAuthor().equals(author)) {
				bk[i].setId(0);
			}
		}
		*/
        // 첫번째 방법
        for (int i = 0; i < bk.size(); i++) {
            Book b = bk.get(i);
            if (b.getAuthor().equals(author)) {
                bk.remove(i);
                break; // or return;
            }
        }

        // 두번째 방법
		/*
		for(Book b:bk) {
			if(b.getAuthor().equals(author)) {
				bk.remove(bk.indexOf(b));
				break;
			}
		}
		*/

        // 세번째 방법(이터레이터)
		/*Iterator<Book> it=bk.iterator();
		while(it.hasNext()) {
			Book b=it.next();
			if(b.getAuthor().equals(author)) {
				it.remove();
				break;
			}
		}*/
    }

    public Book selectByName(String author) {
        int i = 0;
        for (Book b : bk) {
            if (b.getAuthor().equals(author)) {
                System.out.println(b);
                return b;
            }
            i++;
        }

        if (bk.size() == i) {
            System.out.println("도서 정보가 존재하지 않습니다.");
            return null;
        }
        return null;
    }

    // 찾는 저자가 리스트에 존재하는 여부 확인하는 함수
    public boolean isExist(String searchAuthor) {
        for (Book b : bk) {
            if (b.getAuthor().equals(searchAuthor)) {
                return true;
            }
        }
        return false;
    }

    public Book getBookByName(String author) {
        for (Book b : bk) {
            if (b.getAuthor().equals(author)) {
                return new Book(b.getAuthor(), b.getIsbn(), b.getDate());
            }
        }
        return null;
    }

    public List<Book> getList() {
        return bk;
    }
}