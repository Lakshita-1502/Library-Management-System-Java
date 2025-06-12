package src.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import src.DBConnection;

public class addBook {
    public static void getDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con= null;
        try {
            con = DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }

        System.out.println("Enter Book Id:- ");
        int bookId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Book Name:- ");
        String bookName = sc.nextLine();

        System.out.println("Enter Book Author Name:- ");
        String bookAuthor = sc.nextLine();

        System.out.println("Enter Book Publisher Name:- ");
        String bookPublisher = sc.nextLine();

        System.out.println("Enter Book total no. of pages:- ");
        int bookTotal = sc.nextInt();
        sc.nextLine();

        book book = new book(bookId, bookName, bookAuthor, bookPublisher, bookTotal);
        addBook(con, book);
    }

    public static void addBook(Connection con, book book){
        String str="insert into book values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(str);
            ps.setInt(1,book.getBid());
            ps.setString(2, book.getBname());
            ps.setString(3, book.getAname());
            ps.setString(4,book.getPname());
            ps.setInt(5, book.getNo_pages());
            ps.executeUpdate();
            System.out.println("Book Added Successfully");
        } catch (SQLException e) {
            System.out.println("Exception caught");
            System.exit(1);
        }
    }
}
