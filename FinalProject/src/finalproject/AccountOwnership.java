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
    private int account_ownership_id;
    private int person_id;
    private int account_id;

    public AccountOwnership(int person_id, int account_id) 
    {
        this.person_id = person_id;
        this.account_id = account_id;
    }

    public AccountOwnership() 
    {
        
    }

    public static AccountOwnership addAccountOwnership(Connection connection, int person_id, int account_id,int account_type_id)//Currently Working
    {
        String insertAccountOwnership = "INSERT INTO Account_Ownership (person_id, account_id,account_type_id) VALUES (?,?,?)";
        AccountOwnership newAccountOwnership = new AccountOwnership();
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
            System.out.println(sqle);
        }
        return newAccountOwnership;
    }

    public static AccountOwnership getAccountOwnershipByAccountID(Connection connection, int account_id)
    {
        String selectAccountOwnership = "SELECT * FROM Account_Ownership WHERE account_id = ?";
        AccountOwnership newAccountOwnership = new AccountOwnership();
        try 
        {
            PreparedStatement pstmt = connection.prepareStatement(selectAccountOwnership);
            pstmt.setInt(1, account_id);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                newAccountOwnership.setAccountOwnershipID(rs.getInt("account_type_id"));
                newAccountOwnership.setPersonID(rs.getInt("person_id"));
                newAccountOwnership.setAccountID(rs.getInt("account_id"));
            }
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return newAccountOwnership;
    }

    public void setAccountOwnershipID(int account_ownership_id) 
    {
        this.account_ownership_id = account_ownership_id;
    }

    public void setPersonID(int person_id) 
    {
        this.person_id = person_id;
    }

    public void setAccountID(int account_id) 
    {
        this.account_id = account_id;
    }
}
