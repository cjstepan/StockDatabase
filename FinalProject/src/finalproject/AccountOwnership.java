package finalproject;
import java.sql.*;

/**
 *
 * @author Calvin Stepan
 */
public class AccountOwnership 
{
    /**
     * 
     * @param connection
     * @param person_id
     * @param account_id
     * @param account_type_id
     */
    public static void addAccountOwnership(Connection connection, int person_id, int account_id,int account_type_id)
    {
        String insertAccountOwnership = "INSERT INTO Account_Ownership (person_id, account_id,account_type_id) VALUES (?,?,?)";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertAccountOwnership);
            pstmt.setInt(1, person_id);
            pstmt.setInt(2, account_id);
            pstmt.setInt(3, account_type_id);
            
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
     */
    public static void getAccountOwnershipByAccountID(Connection connection, int account_id)
    {
        String selectAccountOwnership = "select first_name,last_name,description from account_ownership " +
            "left join account_type on account_ownership.account_type_id = account_type.account_type_id " +
            "left join person on account_ownership.person_id = person.person_id where account_id = ?";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectAccountOwnership);
            pstmt.setInt(1, account_id);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                System.out.println("Account Owner: " + rs.getString("first_name") + " " +
                        rs.getString("last_name") + "\nAccount Type: " + rs.getString("description"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

    public static void getAccountTotalValue(Connection connection, int account_id) {
        String selectSharesCompany = "select shares_purchased,company_id from stock_purchase " +
            "left join price_over_time on stock_purchase.time_id = price_over_time.time_id " +
            "where account_id = ?";
        String selectRecentPrice = "select price from price_over_time " +
            "where company_id = ? " +
            "and date = ( select max(date) from price_over_time )";
        
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectSharesCompany);
            pstmt.setInt(1, account_id);
            ResultSet rs = pstmt.executeQuery();
            ResultSet rs2;
            double total = 0;
            while( rs.next() )
            {
                pstmt = connection.prepareStatement(selectRecentPrice);
                pstmt.setInt(1, rs.getInt("company_id"));
                rs2 = pstmt.executeQuery();
                if(rs2.next())
                total = total + rs.getInt("shares_purchased") * rs2.getDouble("price");
            }
            System.out.println("Total Account Value is: " + total);
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
    }

}
