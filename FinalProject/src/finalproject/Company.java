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
    private int company_id;//probably can remove
    String ticker;
    String description;
    
    public Company(String ticker, String description)
    {
        this.ticker = ticker;
        this.description = description;
    }
    
    public Company()
    {
        
    }
    
    public static void addCompany(Connection connection, String ticker, String description)//UPDATED
    {
        String insertCompany = "INSERT INTO Company (ticker, description) VALUES (?, ?)";
        Company newCompany = new Company();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertCompany);
            pstmt.setString(1, ticker);
            pstmt.setString(2, description);
            
            pstmt.executeQuery();

        }
        catch (SQLException sqle)
        {
            
        }
        
    }

    public static Company getCompanyByTicker(Connection connection, String ticker)//UPDATED
    {
        String selectCompany = "SELECT * FROM Company WHERE ticker = ?";
        Company newCompany = new Company();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectCompany);
            pstmt.setString(1, ticker);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newCompany.setCompanyID(rs.getInt("company_id"));
                newCompany.setTicker(rs.getString("ticker"));
                newCompany.setDescription(rs.getString("description"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newCompany;
    }

    public static void deleteCompany(Connection connection, String ticker)//UPDATED
    {
        String deleteCompany = "DELETE FROM Company WHERE ticker = ?";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(deleteCompany);
            pstmt.setString(1, ticker);
            
            pstmt.executeUpdate();
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
    private void setCompanyID(int company_id)
    {
        this.company_id = company_id;
    }

    private void setTicker(String ticker)
    {
        this.ticker = ticker;
    }

    private void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString() {
    return "Company{" +
            "company_id=" + company_id +
            ", ticker='" + ticker + '\'' +
            ", description='" + description + '\'' +
            '}';
}
}