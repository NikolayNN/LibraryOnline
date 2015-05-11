package objects;

import test.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Nikolay on 11.05.2015.
 */
public class BookList {
    private ArrayList<Book> bookList;

    private ArrayList<Book> writeBookList() {
        try {

            Connection conn = ConnectionConfiguration.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book order by name");
            bookList = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book(rs.getString("name"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }




    public ArrayList<Book> getBookList(){
        if(bookList!=null) return bookList;
        bookList = new ArrayList<>();
        return writeBookList();
    }
}