package src.issues;

import src.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class issueBook {
    public static void getIssueDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con=null;
        issue issue=new issue();
        try{
            con= DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter Issue ID:- ");
        int issueID=sc.nextInt();
        issue.setIssue_id(issueID);
        sc.nextLine();

        System.out.println("Enter Book ID that is issued:- ");
        int bookID=sc.nextInt();
        issue.setBid(bookID);
        sc.nextLine();

        System.out.println("Enter User ID that issued the book:- ");
        int userID=sc.nextInt();
        issue.setUid(userID);
        sc.nextLine();

        System.out.println("Enter issue date:- ");
        String issueDate=sc.nextLine();
        issue.setIssue_date(issueDate);
        sc.nextLine();

        issueBook(con,issue);
    }

    public static void issueBook(Connection con, issue issue){
        String str="insert into issue_return (issue_id, bid, user_id, issue_date) values (?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(str);
            ps.setInt(1,issue.getIssue_id());
            ps.setInt(2,issue.getBid());
            ps.setInt(3,issue.getUid());
            ps.setString(4,issue.getIssue_date());
            ps.executeUpdate();
            System.out.println("Book Issued Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
