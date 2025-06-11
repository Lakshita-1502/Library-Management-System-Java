package src.issues;

import src.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class returnBook {
    public static void getReturnDetails(){
        Scanner sc = new Scanner(System.in);
        Connection con=null;
        issue issue=new issue();
        try{
            con= DBConnection.getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter Issue ID whose book returned:- ");
        int issueID=sc.nextInt();
        issue.setIssue_id(issueID);
        sc.nextLine();

        System.out.println("Enter Return Date:- ");
        String returnDate=sc.nextLine();
        issue.setReturn_date(returnDate);

        returnBook(con,issue);
    }

    public static void returnBook(Connection con, issue issue){
        String str="update issue_return set return_date=?, returned='Yes' where issue_id=?";
        try{
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, issue.getReturn_date());
            pst.setInt(2, issue.getIssue_id());
            pst.executeUpdate();
            System.out.println("Book Returned successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
