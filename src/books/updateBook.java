package src.books;

import src.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateBook {
    public static void getUpdateDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con=null;
        book book=new book();
        try{
            con= DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter Book ID:- ");
        int bookID = sc.nextInt();
        book.setBid(bookID);
        sc.nextLine();

        System.out.println("Enter the information you want to update:- ");
        String information = sc.nextLine();

        switch (information){
            case "Book Name":
                System.out.println("Enter new Book Name: :- ");
                String bookName = sc.nextLine();
                book.setBname(bookName);
                updateBookName(con,book);
                break;
            case "Author":
                System.out.println("Enter new Author: :- ");
                String author = sc.nextLine();
                book.setAname(author);
                updateAuthorName(con,book);
                break;
            case "Publisher":
                System.out.println("Enter new Publisher: :- ");
                String publisher = sc.nextLine();
                book.setPname(publisher);
                updatePublisherName(con,book);
                break;
            case "Page count":
                System.out.println("Enter new Page Count: :- ");
                int pageCount = sc.nextInt();
                book.setNo_pages(pageCount);
                updatePageCount(con,book);
                break;
            default:
                System.out.println("Enter valid information");
                break;
        }
    }

    public static void updateBookName(Connection con, book book){
        String str="update book set bname=? where bid=?";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setString(1,book.getBname());
            ps.setInt(2, book.getBid());
            ps.executeUpdate();
            System.out.println("Book Name Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAuthorName(Connection con, book book){
        String str="update book set aname=? where bid=?";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setString(1,book.getAname());
            ps.setInt(2, book.getBid());
            ps.executeUpdate();
            System.out.println("Author Name Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePublisherName(Connection con, book book){
        String str="update book set pname=? where bid=?";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setString(1,book.getPname());
            ps.setInt(2, book.getBid());
            ps.executeUpdate();
            System.out.println("Publisher Name Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePageCount(Connection con, book book){
        String str="update book set no_pages=? where bid=?";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setInt(1,book.getNo_pages());
            ps.setInt(2, book.getBid());
            ps.executeUpdate();
            System.out.println("Page Count Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
