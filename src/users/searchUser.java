package src.users;

import src.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class searchUser {
    public static void getSearchDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con=null;
        user user=new user();
        try{
            con=DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter User ID you want to search:- ");
        int user_id=sc.nextInt();
        user.setUid(user_id);
        sc.nextLine();

        searchUser(con, user);
    }

    public static void searchUser(Connection con, user user){
        String str="select * from user where uid="+user.getUid();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(str);
            while(rs.next()){
                System.out.println("User ID:- "+rs.getInt(1));
                System.out.println("User Name:- "+rs.getString(2));
                System.out.println("User Contact:- "+rs.getString(3));
                System.out.println("User Address:- "+rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
