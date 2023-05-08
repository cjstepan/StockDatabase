package finalproject;
import java.sql.*;

/**
 *
 * @author Calvin Stepan
 */
public class Person 
{
    /**
     * 
     * @param connection
     * @param first_name
     * @param last_name
     */
    public static void addPerson(Connection connection, String first_name, String last_name)
    {
        String insertPerson = "INSERT INTO Person (first_name, last_name) VALUES (?, ?)";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertPerson);
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            
            pstmt.executeQuery();
            
            System.out.println("person added");
        }
        catch (SQLException sqle)
        {
        }
    }

    /**
     * 
     * @param connection
     * @param person_id
     */
    public static void removePerson(Connection connection, int person_id)
    {
        String deletePerson = "DELETE FROM Stock_Purchase where account_id = ?";
        String deletePerson2 = "DELETE FROM Account_Ownership where person_id = ?";
        String deletePerson3 = "DELETE FROM Person where person_id = ?";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(deletePerson);
            pstmt.setInt(1, person_id);
            pstmt.executeUpdate();
            System.out.println("Person removed.");
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(deletePerson2);
            pstmt.setInt(1, person_id);
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(deletePerson3);
            pstmt.setInt(1, person_id);
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

    /**
     * 
     * @param connection
     * @param person_id
     */
    public static void getAccountsOwnedByPerson(Connection connection, int person_id)
    {
        String selectPersonAccounts = "select first_name,last_name,description from account_ownership " +
            "left join account_type on account_ownership.account_type_id = account_type.account_type_id " +
            "left join person on account_ownership.person_id = person.person_id " +
            "where account_ownership.person_id = ?";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectPersonAccounts);
            pstmt.setInt(1, person_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("description"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
}

