package src.users;

import src.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class addUser {
    public static void getDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con=null;
        try{
            con= DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter User Id:- ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter User Name:- ");
        String name = sc.nextLine();

        System.out.println("Enter User Contact Number:- ");
        String contact = sc.nextLine();

        System.out.println("Enter User Address:- ");
        String address = sc.nextLine();

        user user=new user(id,name,contact,address);
        addUser(con, user);
    }

    public static void addUser(Connection con, user user){
        String str="insert into user values(?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setInt(1, user.getUid());
            ps.setString(2, user.getUname());
            ps.setString(3, user.getContact());
            ps.setString(4, user.getAddress());
            ps.executeUpdate();
            System.out.println("User Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
