package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import src.books.*;
import src.addUser;
import src.viewUser;
import src.updateUser;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management_system",
                "root", "MYsql@2005");
        System.out.println("Connection Successfull...");
        Scanner sc=new Scanner(System.in);

        System.out.println("=====Library Management System =====");
        System.out.println("Following are the available options:- \n" +
                "1. Books\n" +
                "2. Users\n" +
                "3. Issue and Return\n");

        int choice, option;
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
                option=sc.nextInt();
                switch(option) {
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
                }
                break;
            case 2:
                System.out.println("Following are the available options for users:- \n" +
                        "1. Add User\n" +
                        "2. View User\n" +
                        "3. Update User information\n" +
                        "4. Delete User\n");
                System.out.println("Please enter your option number: ");
                option=sc.nextInt();
                switch(option) {
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
                        break;
                    default:
                        System.out.println("Please enter a valid option!");
                }
                break;
            case 3:
                System.out.println("Following are the available options:- \n" +
                        "1. Issue a Book\n" +
                        "2. Return a Book\n");
                System.out.println("Please enter your option number: ");
                option=sc.nextInt();
                switch(option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Please enter a valid option!");
                }
                break;
        }
    }
}
