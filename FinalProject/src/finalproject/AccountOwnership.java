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

    public static void getAccountTotalValue(Connection connection, int account_id) 
    {
        String selectSharesCompany = "SELECT sp.shares_purchased, c.ticker, pot.time_id " +
                "FROM stock_purchase sp " +
                "LEFT JOIN price_over_time pot " +
                "ON sp.time_id = pot.time_id " +
                "LEFT JOIN company c " +
                "ON pot.company_id = c.company_id " +
                "WHERE sp.account_id = ?";
        String selectRecentPrice = "SELECT p.price " +
                "FROM price_over_time p " +
                "LEFT JOIN company c " +
                "ON p.company_id = c.company_id " +
                "WHERE p.company_id = ? " +
                "AND p.date = (SELECT MAX(date) FROM price_over_time WHERE company_id = c.company_id)";
        try (PreparedStatement pstmt1 = connection.prepareStatement(selectSharesCompany);
            PreparedStatement pstmt2 = connection.prepareStatement(selectRecentPrice)) 
        {
            pstmt1.setInt(1, account_id);
            ResultSet rs1 = pstmt1.executeQuery();
            double total = 0;
            while (rs1.next()) 
            {
                String symbol = rs1.getString("ticker");
                pstmt2.setInt(1, rs1.getInt("time_id"));
                ResultSet rs2 = pstmt2.executeQuery();
                if (rs2.next()) 
                {
                    double price = rs2.getDouble("price");
                    int shares_purchased = rs1.getInt("shares_purchased");
                    total += shares_purchased * price;
                    System.out.println("Symbol: " + symbol + "\tShares Purchased: " + shares_purchased + "\tPrice: $" + price);
                } 
                else 
                {
                    System.out.println("No price data found for company with symbol " + symbol);
                }
            }
            System.out.println("Total Account Value is: $" + total);
        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }
}
