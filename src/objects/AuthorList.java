package objects;

import test.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Nikolay on 11.05.2015.
 */
public class AuthorList {

    private ArrayList<Author> authorList;

    private ArrayList<Author> writeAuthorList() {
        try {

            Connection conn = ConnectionConfiguration.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from author order by fio");
            authorList = new ArrayList<>();
            while (rs.next()){
                Author author =new Author(rs.getString("fio"));
               authorList.add(author);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return authorList;
    }

    public ArrayList<Author> getAuthorList(){
        if(authorList!=null) return authorList;

        authorList = new ArrayList<>();
        authorList = writeAuthorList();

        return authorList;
    }






}
