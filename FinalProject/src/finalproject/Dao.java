/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.sql.*;

/**
 *
 * @author calvin
 */
public class Dao {
    static String jdbcURL = "jdbc:postgresql://localhost:5432/CompanyMgmt";
    static String username = "postgres";
    static String password = "postgres";
        
    private static Connection conn;
    
    public static void connectToDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(jdbcURL, username, password);
        }
        catch (ClassNotFoundException driverException) {
            System.out.println("Cannot load the dirver.");
            driverException.printStackTrace(); 
        }
        catch (SQLException sqlException) {
            System.out.println("Cannot connect to database.");
            sqlException.printStackTrace();
        }
    }
    
    public static void closeConnection () throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
    
    public static Connection getConnection() {
        if (conn == null) {
            connectToDatabase();
        }
        return conn;
    }
}
