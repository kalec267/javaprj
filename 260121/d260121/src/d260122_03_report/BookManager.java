package d260122_03_report;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BookManager {
//    private Book[] b= new Book[100];
    private ArrayList<Book> bb = new ArrayList<Book>();
//    private int index=0;

    public BookManager(){
        try{
            fileload("book.txt");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void fileload(String filename){
        bb=new ArrayList<Book>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String data="";
            while((data=br.readLine())!=null){
                insert(
                        Integer.parseInt(data.split(" ")[0]),
                        data.split(" ")[1],
                        data.split(" ")[2],
                        data.split(" ")[3]
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean filesave (String filename){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(filename));
            int i=0;
            for(Book b:bb){
                bw.write(b.getId()+" "+
                        b.getAuthor()+" "+
                        b.getIsbn()+" "+
                        b.getDate()+" "
                );
                if(i !=(bb.size() -1)){
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

    public void insert(String author, String isbn, String date){
        bb.add(new Book(author, isbn, date));
    }
    public void insert(int id, String author, String isbn, String date){
        bb.add(new Book(bb.size()+1, author, isbn, date));
    }

    public void select() {
        for(Book b:bb){
            if(b.getId()!=0){
                System.out.println(b);
            }
        }
    }

    public void update(String searchAuthor, Book b){
        for(Book _b :bb){
            if(searchAuthor.equals(_b.getAuthor())){
                if(_b.getAuthor()!=null){
                    _b.setAuthor(_b.getAuthor());
                }
                if(_b.getIsbn()!=null){
                    _b.setIsbn(_b.getIsbn());
                }
                if(_b.getDate()!=null){
                    _b.setDate(_b.getDate());
                }
                return;
            }
        }
    }

    public void delete(String name){
        Iterator<Book> it = bb.iterator();
        while(it.hasNext()){
            Book b=it.next();
            if(b.getAuthor().equals(name)){
                it.remove();
                break;
            }
        }
    }

    public void selectByName(String searchAuthor){
        int i=0;
        for(Book b:bb){
            if(b.getAuthor().equals(searchAuthor)){
                System.out.println(b);
                break;
            }
            i++;
        }
        if(bb.size()==i){
            System.out.println("저자가 없습니다.");
        }
    }

    public boolean isExist(String searchname){
        for(Book b:bb){
            if(b.getAuthor().equals(searchname)){
                return true;
            }
        }
        return false;
    }

    public Book getBookByName(String name){
        int i=0;
        for(Book b:bb){
            if(b.getAuthor().equals(name)){
                return new Book(b.getAuthor(), b.getIsbn(), b.getDate());
            }
        }
        return null;
    }


}
