# 📚 Library Management System

A Java-based console application for managing books, users, and transactions in a library. This project uses JDBC to connect to a MySQL database.

## 🛠️ Features

- Add new books and users
- Update book and user information
- Issue and return books
- Search for books and users
- View list of issued books
- Simple CLI interface

## 💻 Technologies Used

- Java (JDK 17+ recommended)
- MySQL
- JDBC (Java Database Connectivity)
- IntelliJ IDEA / NetBeans (any Java IDE)
- Git & GitHub

## 🗃️ Database Schema

Create a MySQL database named `library_management_system` with the following tables:

```sql
CREATE TABLE book (
  bid INT PRIMARY KEY,
  bname VARCHAR(100),
  aname VARCHAR(100),
  pname VARCHAR(100),
  no_pages INT
);

CREATE TABLE user (
  uid INT PRIMARY KEY,
  uname VARCHAR(100),
  contact VARCHAR(20),
  address VARCHAR(200)
);

CREATE TABLE issue (
  iid INT PRIMARY KEY AUTO_INCREMENT,
  uid INT,
  bid INT,
  issue_date DATE,
  return_date DATE,
  FOREIGN KEY (uid) REFERENCES user(uid),
  FOREIGN KEY (bid) REFERENCES book(bid)
);
