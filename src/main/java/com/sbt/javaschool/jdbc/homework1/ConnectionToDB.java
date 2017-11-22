package com.sbt.javaschool.jdbc.homework1;

import java.sql.*;

public class ConnectionToDB {
    public static final String DB_URL = "jdbc:h2:C:\\JavaSchool\\Homeworks\\HomeWork_21\\jdbc";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";
    public static final String COLUMN_AUTHOR = "first_name";
    public static final String COLUMN_TEXT = "last_name";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM SCHEDULE.STUDENTS;")) {
            while (resultSet.next()) {
                String author = resultSet.getString(COLUMN_AUTHOR);
                String text = resultSet.getString(COLUMN_TEXT);
                System.out.println(author + " : " + text);
            }
        } catch (SQLException e) {
            System.out.println("Can't get connection: " + e.getMessage());
        }
    }
}