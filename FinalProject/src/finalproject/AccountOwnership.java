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
public class AccountOwnership 
{
    public static void addAccountOwnership(Connection connection, int person_id, int account_id,int account_type_id)//Currently Working
    {
        String insertAccountOwnership = "INSERT INTO Account_Ownership (person_id, account_id,account_type_id) VALUES (?,?,?)";
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(insertAccountOwnership);
            pstmt.setInt(1, person_id);
            pstmt.setInt(2, account_id);
            pstmt.setInt(3, account_type_id);
            
            ResultSet rs = pstmt.executeQuery();
            
        }
        catch (SQLException sqle)
        {
        }
    }

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
}
