package finalproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Calvin Stepan
 */
public class PriceOverTime 
{
    private int time_id;
    private int company_id;
    private double price;
    private String date;

    public PriceOverTime(int company_id, double price, String date) 
    {
        this.company_id = company_id;
        this.price = price;
        this.date = date;
    }

    public PriceOverTime() 
    {
        
    }

    /**
     * 
     * @param connection
     * @param company_id
     * @param price
     * @param date
     * @return 
     */
    public static PriceOverTime addNewPrice(Connection connection, int company_id, double price, String date)
    {
        String insertPrice = "INSERT INTO PriceOverTime (company_id, price, date) VALUES (?, ?, ?)";
        PriceOverTime newPrice = new PriceOverTime();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertPrice);
            pstmt.setInt(1, company_id);
            pstmt.setDouble(2, price);
            pstmt.setString(3, date);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPrice.setTimeID(rs.getInt("time_id"));
                newPrice.setCompanyID(rs.getInt("company_id"));
                newPrice.setPrice(rs.getDouble("price"));
                newPrice.setDate(rs.getString("date"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPrice;
    }

    /**
     * 
     * @param connection
     * @param company_id
     * @return
     */
    public static PriceOverTime getPriceByCompanyID(Connection connection, int company_id)
    {
        String selectPrice = "SELECT * FROM PriceOverTime WHERE company_id = ?";
        PriceOverTime newPrice = new PriceOverTime();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectPrice);
            pstmt.setInt(1, company_id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPrice.setTimeID(rs.getInt("time_id"));
                newPrice.setCompanyID(rs.getInt("company_id"));
                newPrice.setPrice(rs.getDouble("price"));
                newPrice.setDate(rs.getString("date"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPrice;
    }

    /**
     * 
     * @param connection
     * @param date
     * @param company_id
     * @return 
     */
    public static PriceOverTime getPriceByDate(Connection connection, String date, int company_id)
    {
        String selectPrice = "SELECT * FROM PriceOverTime WHERE date = ? AND company_id = ?";
        PriceOverTime newPrice = new PriceOverTime();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectPrice);
            pstmt.setString(1, date);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newPrice.setTimeID(rs.getInt("time_id"));
                newPrice.setCompanyID(rs.getInt("company_id"));
                newPrice.setPrice(rs.getDouble("price"));
                newPrice.setDate(rs.getString("date"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newPrice;
    }

    public void setTimeID(int time_id) 
    {
        this.time_id = time_id;
    }

    public void setCompanyID(int company_id) 
    {
        this.company_id = company_id;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public void setDate(String date) 
    {
        this.date = date;
    }
}
