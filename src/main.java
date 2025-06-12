package src;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import src.books.*;
import src.issues.*;
import src.users.*;
import src.DBConnection;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con=null;
        con=DBConnection.getConnection();
        Scanner sc=new Scanner(System.in);
        int choice, option, yes_no=1;

        System.out.println("=========Library Management System ===========");

        while(yes_no==1){
            System.out.println("Following are the available options:- \n" +
                    "1. Books\n" +
                    "2. Users\n" +
                    "3. Issue and Return\n");

            System.out.println("Please enter your choice number: ");
            choice=sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Following are the available options for books:- \n" +
                            "1. Add Book\n" +
                            "2. View Books\n" +
                            "3. Update Books\n" +
                            "4. Delete Book\n" +
                            "5. Search a Book\n");
                    System.out.println("Please enter your option number: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            addBook.getDetails();
                            break;
                        case 2:
                            viewBooks.viewBooks();
                            break;
                        case 3:
                            updateBook.getUpdateDetails();
                            break;
                        case 4:
                            deleteBook.getDeleteDetails();
                            break;
                        case 5:
                            searchBook.getSearchDetails();
                            break;
                        default:
                            System.out.println("Please enter a valid option!");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Following are the available options for users:- \n" +
                            "1. Add User\n" +
                            "2. View User\n" +
                            "3. Update User information\n" +
                            "4. Delete User\n" +
                            "5. Search a User");
                    System.out.println("Please enter your option number: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            addUser.getDetails();
                            break;
                        case 2:
                            viewUser.viewUser();
                            break;
                        case 3:
                            updateUser.getUpdateDetails();
                            break;
                        case 4:
                            deleteUser.getDeleteDetails();
                            break;
                        case 5:
                            searchUser.getSearchDetails();
                            break;
                        default:
                            System.out.println("Please enter a valid option!");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Following are the available options:- \n" +
                            "1. Issue a Book\n" +
                            "2. Return a Book\n");
                    System.out.println("Please enter your option number: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            issueBook.getIssueDetails();
                            break;
                        case 2:
                            returnBook.getReturnDetails();
                            break;
                        default:
                            System.out.println("Please enter a valid option!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
            System.out.println("Do you want to continue (1/0):- ");
            yes_no=sc.nextInt();

            if (yes_no==0) {
                System.out.println("Thank you for using our system!");
                break;
            }
        }
    }
}
