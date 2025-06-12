package src.users;

import src.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateUser {
    public static void getUpdateDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con=null;
        user user=new user();
        try{
            con= DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }

        System.out.println("Enter User ID:- ");
        int userID = sc.nextInt();
        user.setUid(userID);
        sc.nextLine();

        System.out.println("Enter the information you want to update:- ");
        String information = sc.nextLine();

        switch (information){
            case "User Name":
                System.out.println("Enter new User Name:- ");
                String userName = sc.nextLine();
                user.setUname(userName);
                updateUserName(con,user);
                break;
            case "Contact":
                System.out.println("Enter new Contact Number:- ");
                String contact = sc.nextLine();
                user.setContact(contact);
                updateUserContact(con,user);
                break;
            case "Address":
                System.out.println("Enter new Address:- ");
                String address = sc.nextLine();
                user.setAddress(address);
                updateUserAddress(con,user);
                break;
            default:
                System.out.println("Enter valid information");
                break;
        }
    }

    public static void updateUserName(Connection con, user user){
        String str="update user set uname=? where uid=?";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setString(1,user.getUname());
            ps.setInt(2, user.getUid());
            ps.executeUpdate();
            System.out.println("User Name Updated");
        } catch (SQLException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }
    }

    public static void updateUserContact(Connection con, user user){
        String str="update user set contact=? where uid=?";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setString(1,user.getContact());
            ps.setInt(2, user.getUid());
            ps.executeUpdate();
            System.out.println("User Contact number Updated");
        } catch (SQLException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }
    }

    public static void updateUserAddress(Connection con, user user){
        String str="update user set address=? where uid=?";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setString(1,user.getAddress());
            ps.setInt(2, user.getUid());
            ps.executeUpdate();
            System.out.println("User Address Updated");
        } catch (SQLException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }
    }
}
