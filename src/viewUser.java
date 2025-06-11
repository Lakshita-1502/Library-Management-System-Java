package src;

import src.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class viewUser {
    public static void viewUser(){
        Connection con = null;
        try{
            con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from user");
            while(rs.next()){
                System.out.println("User Id:- "+rs.getInt(1));
                System.out.println("User Name:- "+rs.getString(2));
                System.out.println("User Contact No.:- "+rs.getString(3));
                System.out.println("User Address:- "+rs.getString(4));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
