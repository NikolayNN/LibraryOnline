package objects;

import test.ConnectionConfiguration;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nikolay on 11.05.2015.
 */
public class BookList {
    private ArrayList<Book> bookList;

    private ArrayList<Book> writeBookList(String sqlRequest) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionConfiguration.getConnection();
            stmt = conn.createStatement();
            System.out.println(sqlRequest);
            rs = stmt.executeQuery(sqlRequest);
            bookList = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book(rs.getString("name"));
                book.setId(rs.getInt("id"));
                book.setPages(rs.getString("pages"));
                book.setIsbn(rs.getString("isbn"));
                book.setGenre(rs.getString("genre"));
                book.setAuthor(rs.getString("author"));
                book.setYear(rs.getDate("year"));
                book.setImage(rs.getBytes("image"));
                bookList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }
            return bookList;
        }

    }

    public ArrayList<Book> setBookListByGenre(int id){
        return writeBookList(
                "SELECT b.id, "
                +"b.name as name, "
                +"b.page_count as pages, "
                +"b.isbn as isbn, "
                +"g.name as genre, "
                +"a.fio as author, "
                +"b.publish_year as year, "
                +"b.image as image "
                +"from book b "
                +"inner join  genre g on g.id = b.genre_id "
                +"inner join author a on a.id=b.author_id "
                +"where genre_id = "+id
                +" ORDER BY b.name");
    }

    public ArrayList<Book> setAllBooks(){
        return writeBookList(
                "SELECT b.id, "
                        +"b.name as name, "
                        +"b.page_count as pages, "
                        +"b.isbn as isbn, "
                        +"g.name as genre, "
                        +"a.fio as author, "
                        +"b.publish_year as year, "
                        +"b.image as image "
                        +"from book b "
                        +"inner join  genre g on g.id = b.genre_id "
                        +"inner join author a on a.id=b.author_id "
                        +" ORDER BY b.name");
    }

    public ArrayList<Book> setBooksByFirstLetter(String s){
        return writeBookList(
                "SELECT b.id, "
                        +"b.name as name, "
                        +"b.page_count as pages, "
                        +"b.isbn as isbn, "
                        +"g.name as genre, "
                        +"a.fio as author, "
                        +"b.publish_year as year, "
                        +"b.image as image "
                        +"from book b "
                        +"inner join  genre g on g.id = b.genre_id "
                        +"inner join author a on a.id=b.author_id "
                        +"where b.name like '"+s+"%'"
                        +" ORDER BY b.name");
    }




    public ArrayList<Book> getBookList(){
        return bookList;
    }
}