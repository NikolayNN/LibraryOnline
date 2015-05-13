package objects;

import test.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Nikolay on 11.05.2015.
 */
public class GenreList {
    private ArrayList<Genre> genreList;

    private ArrayList<Genre> writeGenreList() {
        try {

            Connection conn = ConnectionConfiguration.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from genre order by name");
            genreList = new ArrayList<>();
            while (rs.next()){
                Genre genre =new Genre(rs.getString("name"));
                genre.setId(Integer.parseInt(rs.getString("id")));
                genreList.add(genre);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return genreList;
    }


    public ArrayList<Genre> getGenreList(){
        if(genreList!=null) return genreList;

        genreList = new ArrayList<>();
        genreList = writeGenreList();

        return genreList;
    }



}
