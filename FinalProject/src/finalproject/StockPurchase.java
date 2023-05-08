package finalproject;
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
    public static void addPurchase(Connection connection, int account_id, int time_id, int shares_purchased)//UPDATED
    {
        String insertPurchase = "INSERT INTO stock_purchase (account_id, time_id, shares_purchased) VALUES (?, ?, ?)";
        StockPurchase newPurchase = new StockPurchase();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertPurchase);
            pstmt.setInt(1, account_id);
            pstmt.setInt(2, time_id);
            pstmt.setInt(3, shares_purchased);
            
            pstmt.executeQuery();
        }
        catch (SQLException sqle)
        {
        }

    }

    public static void updatePurchase(Connection connection, int account_id, int time_id, int shares_purchased)//Updated
    {
        String updatePurchase = "UPDATE stock_purchase SET shares_purchased = ? WHERE account_id = ? AND time_id = ?";
        StockPurchase newPurchase = new StockPurchase();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(updatePurchase);
            pstmt.setInt(1, shares_purchased);
            pstmt.setInt(2, account_id);
            pstmt.setInt(3, time_id);
            
            ResultSet rs = pstmt.executeQuery();
            
        }
        catch (SQLException sqle)
        {
        }
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
