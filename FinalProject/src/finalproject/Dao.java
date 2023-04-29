package finalproject;
import java.sql.*;
/**
 *
 * @author Calvin Stepan
 */
public class Dao {
    private String jdbcURL = "jdbc:postgresql://localhost:5432/FinalProject";
    private String username = "postgres";
    private String password = "Yi37JBBXS5cP";
    private Connection connection;
    
    public Dao()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection
                (jdbcURL, username, password);
            System.out.println("Connection Success");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Cannot load Driver");
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
    
    public Connection getConnection()
    {
        return connection;
    }
}