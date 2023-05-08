package finalproject;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Calvin Stepan
 */
public class Person 
{
    private int person_id;
    private String first_name;
    private String last_name;

    public Person(String first_name, String last_name) 
    {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Person() 
    {
        
    }

    /**
     * 
     * @param connection
     * @param first_name
     * @param last_name
     * @return new Person object
     */
    public static void addPerson(Connection connection, String first_name, String last_name)//UPDATED
    {
        String insertPerson = "INSERT INTO Person (first_name, last_name) VALUES (?, ?)";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertPerson);
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            
            ResultSet rs = pstmt.executeQuery();
            
            System.out.println("person added");
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
    public static void removePerson(Connection connection, int person_id)//UPDATED
    {
        String deletePerson = "DELETE FROM stock_purchase where account_id = ?;" +
                            "DELETE From Account_Ownership Where person_id = ?;" +
                            "DELETE FROM Person WHERE person_id = ?;";
        // String deletePerson = "DELETE FROM Person WHERE person_id = ?;";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(deletePerson);
            pstmt.setInt(1, person_id);
            pstmt.setInt(2, person_id);
            pstmt.setInt(3, person_id);
            
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

    public void setPersonID(int person_id) 
    {
        this.person_id = person_id;
    }

    public void setFirstName(String first_name) 
    {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) 
    {
        this.last_name = last_name;
    }
}

