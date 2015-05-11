package objects;

import test.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            ResultSet rs = stmt.executeQuery("select * from author");
            authorList = new ArrayList<Author>();
            while (rs.next()){
                Author author =new Author(rs.getString("fio"));
               authorList.add(author);

            }


        }catch (Exception e){
            e.printStackTrace();
        }


        return sort(authorList);
    }

    private ArrayList<Author> sort(ArrayList<Author> list){
        for(int j=0; j < list.size(); j++ ) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getName().compareTo(list.get(i + 1).getName()) > 0) {
                    Author a = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, a);
                }
            }
        }
return list;
    }

    public ArrayList<Author> getAuthorList(){
        if(authorList!=null) return authorList;

        authorList = new ArrayList<Author>();
        authorList = writeAuthorList();

        return authorList;
    }






}
