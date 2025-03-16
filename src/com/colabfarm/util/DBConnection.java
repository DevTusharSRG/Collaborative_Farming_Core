package com.colabfarm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/ColabDB"; // Change to your database name
    private static final String USER = "your_username"; // Change to your PostgreSQL username
    private static final String PASSWORD = "your_password"; // Change to your PostgreSQL password

    // Private constructor to prevent instantiation
    private DBConnection() {}

    // Method to get database connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            // Establish connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed. Check the PostgreSQL credentials and server status.");
            e.printStackTrace();
        }
        return conn;
    }

    // Method to close connection
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection.");
            e.printStackTrace();
        }
    }
}
