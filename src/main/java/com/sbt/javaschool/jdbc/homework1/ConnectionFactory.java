package com.sbt.javaschool.jdbc.homework1;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String H2_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:C:\\JavaSchool\\Homeworks\\HomeWork_21\\jdbc";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        try {
            Class.forName(H2_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found class " + H2_DRIVER, e);
        }
    }

    public static synchronized ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
    }
}