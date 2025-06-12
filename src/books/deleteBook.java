package src.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import src.DBConnection;

public class deleteBook {
    public static void getDeleteDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con=null;
        book book=new book();
        try{
            con= DBConnection.getConnection();
;        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }

        System.out.println("Enter Book ID you want to delete:- ");
        int bookID = sc.nextInt();
        book.setBid(bookID);
        sc.nextLine();

        deleteBook(con, book);
    }

    public static void deleteBook(Connection con, book book){
        String str = "delete from book where bid=?";
        try{
            PreparedStatement ps = con.prepareStatement(str);
            ps.setInt(1, book.getBid());
            ps.executeUpdate();
            System.out.println("Book deleted successfully");
        } catch (SQLException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }
    }
}
