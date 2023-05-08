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
import java.sql.Date;
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
    public static void addNewPrice(Connection connection, int company_id, double price, String date)//UPDATED
    {
        String insertPrice = "INSERT INTO price_over_time (company_id, price,date) VALUES (?, ?, CAST(? AS date))";
        PriceOverTime newPrice = new PriceOverTime();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertPrice);
            pstmt.setInt(1, company_id);
            pstmt.setDouble(2, price);
            pstmt.setString(3, date);
            
            pstmt.executeQuery();
            System.out.println("Price Updated.");
        }
        catch (SQLException sqle)
        {
        }
        
    }

    /**
     * 
     * @param connection
     * @param date
     * @param company_id
     * @return 
     */
    public static void getPriceByDate(Connection connection, String date, String company_ticker)
    {
        String selectPrice = "SELECT price FROM company right join price_over_time "
                + "on company.company_id = price_over_time.company_id " 
                + "where ticker = upper(?) and date = to_date( ? , 'YYYY-MM-DD')";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectPrice);
            pstmt.setString(1, company_ticker);
            pstmt.setString(2, date);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                System.out.println("Price: " + rs.getInt("price"));
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
    
    public static void getMostRecentPriceByTicker(Connection connection, String ticker) {
        String displayPrice = "SELECT price,date FROM company right join price_over_time " +
            "on company.company_id = price_over_time.company_id where ticker = upper(?) " +
            "and date = ( select max(date) from price_over_time )";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(displayPrice);
            pstmt.setString(1, ticker);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                System.out.println( "Price: " + rs.getString("price") 
                        + " | Date: " + rs.getString("date") );
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

    public static void getAllPriceByTicker(Connection connection, String ticker) {
        String displayPrice = "SELECT price,date FROM company "
                + "right join price_over_time on company.company_id = "
                + "price_over_time.company_id "
                + "where ticker = upper(?) "
                + "order by date desc";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(displayPrice);
            pstmt.setString(1, ticker);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println( "Price: " + rs.getString("price") 
                        + " | Date: " + rs.getString("date") );
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

    public static void getAvgPriceByTicker(Connection connection, String ticker) {
        String displayPrice = "SELECT avg(price) FROM company "
                + "right join price_over_time on company.company_id = "
                + "price_over_time.company_id "
                + "where ticker = upper(?) ";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(displayPrice);
            pstmt.setString(1, ticker);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                System.out.println( "Average Price: " + rs.getString("avg") );
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
    public static void getMinMaxPriceByTicker(Connection connection, String ticker) {
        String displayPrice = "SELECT min(price), max(price) FROM company "
                + "right join price_over_time on company.company_id = "
                + "price_over_time.company_id "
                + "where ticker = upper(?) ";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(displayPrice);
            pstmt.setString(1, ticker);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                System.out.println( "Minimum Price: " + rs.getString("min")
                + " | Maximum Price: " + rs.getString("max") );
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
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
