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
public class StockPurchase 
{
    private int time_id;
    private int company_id;
    private int shares_purchased;

    public StockPurchase(int company_id, int time_id, int shares_purchased) 
    {
        this.company_id = company_id;
        this.shares_purchased = shares_purchased;
    }

    public StockPurchase() 
    {
        
    }

    /**
     * 
     * @param connection
     * @param company_id
     * @param time_id
     * @param shares_purchased
     * @return new StockPurchase object
     */
    public static StockPurchase addPurchase(Connection connection, int company_id, int time_id, int shares_purchased)
    {
        String insertPurchase = "INSERT INTO StockPurchase (company_id, time_id, shares_purchased) VALUES (?, ?, ?)";
        StockPurchase newPurchase = new StockPurchase();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertPurchase);
            pstmt.setInt(1, company_id);
            pstmt.setInt(2, time_id);
            pstmt.setInt(3, shares_purchased);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPurchase.setCompanyID(rs.getInt("company_id"));
                newPurchase.setTimeID(rs.getInt("time_id"));
                newPurchase.setSharesPurchased(rs.getInt("shares_purchased"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPurchase;
    }

    public static StockPurchase updatePurchase(Connection connection, int company_id, int time_id, int shares_purchased)
    {
        String updatePurchase = "UPDATE StockPurchase SET shares_purchased = ? WHERE company_id = ? AND time_id = ?";
        StockPurchase newPurchase = new StockPurchase();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(updatePurchase);
            pstmt.setInt(1, shares_purchased);
            pstmt.setInt(2, company_id);
            pstmt.setInt(3, time_id);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPurchase.setCompanyID(rs.getInt("company_id"));
                newPurchase.setTimeID(rs.getInt("time_id"));
                newPurchase.setSharesPurchased(rs.getInt("shares_purchased"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPurchase;
    }

    public void setCompanyID(int company_id) 
    {
        this.company_id = company_id;
    }

    public void setTimeID(int time_id) 
    {
        this.time_id = time_id;
    }

    public void setSharesPurchased(int shares_purchased) 
    {
        this.shares_purchased = shares_purchased;
    }
}
