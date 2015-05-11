package test;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nikolay on 08.05.2015.
 */
public class TestConnection {
    public void check(){
        try {


//            InitialContext ic = new InitialContext();
//            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");
            Connection conn = ConnectionConfiguration.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from book");

            while (rs.next()){
                System.out.println(rs.getString("name"));

            }


        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
