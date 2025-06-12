package src.users;

import src.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteUser {
    public static void getDeleteDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        user user=new user();
        try{
            con=DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }

        System.out.println("Enter User ID you want to delete:- ");
        int userID = sc.nextInt();
        user.setUid(userID);
        sc.nextLine();

        deleteUser(con, user);
    }

    public static void deleteUser(Connection con, user user){
        String str="delete from user where uid=?";
        try{
            PreparedStatement pst=con.prepareStatement(str);
            pst.setInt(1, user.getUid());
            pst.executeUpdate();
            System.out.println("User deleted successfully");
        } catch (SQLException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }
    }
}
