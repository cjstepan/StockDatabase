package finalproject;
import java.sql.*;

/**
 *
 * @author Calvin Stepan
 */
public class StockPurchase 
{
    /**
     * 
     * @param connection
     * @param account_id
     * @param time_id
     * @param shares_purchased
     */
    public static void addPurchase(Connection connection, int account_id, int time_id, int shares_purchased)
    {
        String insertPurchase = "INSERT INTO stock_purchase (account_id, time_id, shares_purchased) VALUES (?, ?, ?)";
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

    /**
     * 
     * @param connection
     * @param account_id
     * @param time_id
     * @param shares_purchased
     */
    public static void updatePurchase(Connection connection, int account_id, int time_id, int shares_purchased)//Updated
    {
        String updatePurchase = "UPDATE stock_purchase SET shares_purchased = ? WHERE account_id = ? AND time_id = ?";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(updatePurchase);
            pstmt.setInt(1, shares_purchased);
            pstmt.setInt(2, account_id);
            pstmt.setInt(3, time_id);
            
            pstmt.executeQuery();
            
        }
        catch (SQLException sqle)
        {
        }
    }
}
