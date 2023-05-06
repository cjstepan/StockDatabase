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
    public static Person addPerson(Connection connection, String first_name, String last_name)
    {
        String insertPerson = "INSERT INTO Person (first_name, last_name) VALUES (?, ?)";
        Person newPerson = new Person();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertPerson);
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPerson.setPersonID(rs.getInt("person_id"));
                newPerson.setFirstName(rs.getString("first_name"));
                newPerson.setLastName(rs.getString("last_name"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPerson;
    }

    public static Person getPersonByLastName(Connection connection, String last_name)
    {
        String selectPerson = "SELECT * FROM Person WHERE last_name = ?";
        Person newPerson = new Person();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectPerson);
            pstmt.setString(1, last_name);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPerson.setPersonID(rs.getInt("person_id"));
                newPerson.setFirstName(rs.getString("first_name"));
                newPerson.setLastName(rs.getString("last_name"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPerson;
    }

    public static Person getPersonByFirstName(Connection connection, String first_name)
    {
        String selectPerson = "SELECT * FROM Person WHERE first_name = ?";
        Person newPerson = new Person();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectPerson);
            pstmt.setString(1, first_name);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPerson.setPersonID(rs.getInt("person_id"));
                newPerson.setFirstName(rs.getString("first_name"));
                newPerson.setLastName(rs.getString("last_name"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPerson;
    }

    public static Person getPersonById(Connection connection, int person_id)
    {
        String selectPerson = "SELECT * FROM Person WHERE person_id = ?";
        Person newPerson = new Person();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectPerson);
            pstmt.setInt(1, person_id);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPerson.setPersonID(rs.getInt("person_id"));
                newPerson.setFirstName(rs.getString("first_name"));
                newPerson.setLastName(rs.getString("last_name"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPerson;
    }

    public static void removePerson(Connection connection, int person_id)
    {
        String deletePerson = "DELETE FROM Person WHERE person_id = ?";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(deletePerson);
            pstmt.setInt(1, person_id);
            
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

    public static void updatePersonFirstName(Connection connection, int person_id, String first_name)
    {
        String updatePerson = "UPDATE Person SET first_name = ? WHERE person_id = ?";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(updatePerson);
            pstmt.setString(1, first_name);
            pstmt.setInt(2, person_id);
            
            pstmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

    public static void updatePersonLastName(Connection connection, int person_id, String last_name)
    {
        String updatePerson = "UPDATE Person SET last_name = ? WHERE person_id = ?";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(updatePerson);
            pstmt.setString(1, last_name);
            pstmt.setInt(2, person_id);
            
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

