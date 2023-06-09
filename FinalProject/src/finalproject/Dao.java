package finalproject;
 
/**
 *
 * @author twey
 */
import java.sql.*;

/**
 *
 * @author calvin
 */
public class Dao {
    static String jdbcURL = "jdbc:postgresql://localhost:5432/FinalProject";
    static String username = "postgres";
    static String password = "Yi37JBBXS5cP";
        
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
