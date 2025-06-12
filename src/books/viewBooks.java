package src.books;

import src.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class viewBooks {
    public static void viewBooks(){
        Connection con = null;
        try{
            con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from book");
            while(rs.next()){
                System.out.println("Books ID:- "+rs.getInt(1));
                System.out.println("Book Title:- "+rs.getString(2));
                System.out.println("Book Author:- "+rs.getString(3));
                System.out.println("Book Publisher:- "+rs.getString(4));
                System.out.println("Book total no. of pages:- "+rs.getInt(5));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }
    }
}
