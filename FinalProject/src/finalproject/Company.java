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
public class Company 
{
    public static void addCompany(Connection connection, String ticker, String description)
    {
        String insertCompany = "INSERT INTO Company (ticker, description) VALUES (upper(?), ?)";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertCompany);
            pstmt.setString(1, ticker);
            pstmt.setString(2, description);
            
            pstmt.executeQuery();
            System.out.println("Company added.");
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        
    }

    public static void getCompanyByTicker(Connection connection, String ticker)//UPDATED
    {
        String selectCompany = "SELECT * FROM Company WHERE ticker = upper(?)";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectCompany);
            pstmt.setString(1, ticker);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                System.out.println("Ticker: " + rs.getString("ticker") + "\nDescription: " + rs.getString("description"));
            }
            
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

    public static void deleteCompany(Connection connection, String ticker)//UPDATED
    {
        String deleteCompany = "DELETE FROM Company WHERE ticker = upper(?)";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(deleteCompany);
            pstmt.setString(1, ticker);
            pstmt.executeUpdate();
            System.out.println("Company Deleted.");
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
    public static String[] getAllTickers(Connection connection) {
        String displayAllTickers = "Select ticker FROM Company";
        String[] str = new String[100];
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(displayAllTickers);
            
            ResultSet rs = pstmt.executeQuery();
            int t = 0;
            while(rs.next()) {
                str[t] = rs.getString("ticker");
                t++;
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return str;
    }
}