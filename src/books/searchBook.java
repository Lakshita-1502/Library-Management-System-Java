package src.books;

import src.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class searchBook {
    public static void getSearchDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con=null;
        book book=new book();
        try{
            con= DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter Book ID to search:- ");
        int bookID=sc.nextInt();
        book.setBid(bookID);
        sc.nextLine();

        searchBook(con,book);
    }

    public static void searchBook(Connection con, book book){
        String str="select * from book where bid="+book.getBid();
        try{
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(str);
            while(rs.next()){
                System.out.println("Books ID:- "+rs.getInt(1));
                System.out.println("Book Title:- "+rs.getString(2));
                System.out.println("Book Author:- "+rs.getString(3));
                System.out.println("Book Publisher:- "+rs.getString(4));
                System.out.println("Book total no. of pages:- "+rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
