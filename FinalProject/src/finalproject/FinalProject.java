package finalproject;
import java.util.Scanner;

/**
 *
 * @author 
 */
import java.sql.*;

/**
 *
 * @author calvin nooh Trey
 */
public class FinalProject {

    public void start() {
        Dao.connectToDatabase();

        FinalProject mainMenu = new FinalProject();
        mainMenu.showMenu();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;
        do {
            System.out.println("\n-----Main Menu-----");
            System.out.println("1. Company Information");
            System.out.println("2. Person Information");
            System.out.println("3. Price Information");
            System.out.println("4. Purchases Information");
            System.out.println("5. Accounts Information");
            System.out.println("6. Exit\n");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();
            switch (mainChoice) {
                case 1:
                    option1Menu();
                    break;
                case 2:
                    option2Menu();
                    break;
                case 3:
                    option3Menu();
                    break;
                case 4:
                    option4Menu();
                    break;
                case 5:
                    option5Menu();
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (mainChoice != 6);
        scanner.close();
    }

    public void option1Menu() { // Put Company Here
        Scanner scanner = new Scanner(System.in);
        int option1Choice;
        do {
            System.out.println("\n\n-----Company Information Menu-----");
            System.out.println("1. Get Company by Ticker");
            System.out.println("2. Add Company");
            System.out.println("3. Delete Company");
            System.out.println("4. Display All Tickers");
            System.out.println("5. Return to Main Menu?\n");
            System.out.print("Enter your choice: ");
            option1Choice = scanner.nextInt();
            switch (option1Choice) {

                case 1:

                    System.out.println("\n\n-----Company by Ticker-----\n\n");
                    System.out.println("Company Ticker: ");
                    Scanner scan1 = new Scanner(System.in);
                    String ticker = scan1.next();
                    Company name = Company.getCompanyByTicker(Dao.getConnection(), ticker);
                    System.out.println(name.toString());
                    break;

                case 2:

                    System.out.println("\n\n-----Add Company-----\n\n");
                    System.out.println("Company Ticker: ");
                    Scanner scan2 = new Scanner(System.in);
                    String ticker2 = scan2.next();
                    System.out.println("Company Description:");
                    Scanner scan3 = new Scanner(System.in);
                    String description = scan3.next();
                    Company.addCompany(Dao.getConnection(), ticker2, description);
                    break;

                case 3:

                    System.out.println("\n\n-----Delete Company-----\n\n");
                    System.out.println("Insert ticker: ");
                    Scanner scan4 = new Scanner(System.in);
                    String ticker3 = scan4.next();
                    Company.deleteCompany(Dao.getConnection(), ticker3);
                    break;

                case 4:
                    System.out.print("\n\n-----Display All Company Tickers-----\n\n");
                    String[] str = Company.getAllTickers(Dao.getConnection());
                    for(int i = 0; i < str.length; i++) {
                        if(str[i] != null)
                        System.out.println(str[i]);
                    }
                    break;   
                    
                case 5:
                    System.out.println("Returning to Main Menu");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option1Choice != 5);
    }

    public void option2Menu() { //put Person here
        Scanner scanner = new Scanner(System.in);
        int option2Choice;
        do {
            System.out.println("\n-----Person Information Menu-----");
            System.out.println("1. Add Person");
            System.out.println("2. Remove Person");
            System.out.println("3. Get Accounts Owned by Person");
            System.out.println("4. Back to Main Menu\n");
            System.out.print("Enter your choice: ");
            option2Choice = scanner.nextInt();
            switch (option2Choice) {
                case 1:
                    System.out.println("\n\n-----Add Person-----\n\n");
                    System.out.println("First name: ");
                    Scanner scan1 = new Scanner(System.in);
                    String first_name = scan1.next();
                    System.out.println("Last name: ");
                    Scanner scan2 = new Scanner(System.in);
                    String last_name = scan2.next();
                    Person.addPerson(Dao.getConnection(), first_name, last_name);
                    break;
                case 2:
                    System.out.println("\n\n-----Remove Person-----\n\n");
                    System.out.println("Insert ID: ");
                    Scanner scan3 = new Scanner(System.in);
                    int id = scan3.nextInt();
                    Person.removePerson(Dao.getConnection(), id);
                    break;
                case 3:
                    System.out.println("\n\n-----Get Accounts Owned by Person-----\n\n");
                    System.out.println("Insert ID: ");
                    Scanner scan4 = new Scanner(System.in);
                    int id2 = scan4.nextInt();
                    Person.getAccountsOwnedByPerson(Dao.getConnection(), id2);
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option2Choice != 3);
    }

    public void option3Menu() {
        Scanner scanner = new Scanner(System.in);
        int option3Choice;
        do {
            System.out.println("\n-----Price Over Time Menu-----");
            System.out.println("1. Add New Price");
            System.out.println("2. Get Price by Date");
            System.out.println("3. Get Average Price by Ticker");
            System.out.println("4. Get All Prices by Ticker");
            System.out.println("5. Get Minimum and Maximum Price by Ticker");
            System.out.println("6. Back to Main Menu\n");
            System.out.print("Enter your choice: ");
            option3Choice = scanner.nextInt();
            switch (option3Choice) {
                case 1:

                    System.out.println("\n\n-----Add new price-----\n\n");
                    System.out.println("Company Id: ");
                    Scanner scan1 = new Scanner(System.in);
                    int id = scan1.nextInt();
                    System.out.println("Price Changed to: ");
                    Scanner scan2 = new Scanner(System.in);
                    double price = scan2.nextDouble();
                    System.out.println("Current Date(YYYY-MM-DD): ");
                    Scanner scan3 = new Scanner(System.in);
                    String date = scan3.next();
                    PriceOverTime.addNewPrice(Dao.getConnection(), id, price, date);
                    break;

                case 2:

                    System.out.print("\n\n-----Get price by date-----\n\n");
                    System.out.println("Company Ticker: ");
                    Scanner scan4 = new Scanner(System.in);
                    String id2 = scan4.next();
                    System.out.println("Current Date(YYYY-MM-DD): ");
                    Scanner scan5 = new Scanner(System.in);
                    String date2 = scan5.next();
                    PriceOverTime.getPriceByDate(Dao.getConnection(), date2, id2);
                    break;
                
                case 3:

                    System.out.print("\n\n-----Get Average Price by Ticker-----\n\n");
                    System.out.println("Ticker: ");
                    Scanner scan7 = new Scanner(System.in);
                    String ticker2 = scan7.next();
                    PriceOverTime.getAvgPriceByTicker(Dao.getConnection(), ticker2);
                    break;
                    
                case 4:
                    
                    System.out.print("\n\n-----Get All Prices by Ticker-----\n\n");
                    System.out.println("Ticker: ");
                    Scanner scan6 = new Scanner(System.in);
                    String ticker1 = scan6.next();
                    PriceOverTime.getAllPriceByTicker(Dao.getConnection(), ticker1);
                    break;
                
                case 5:
                    
                    System.out.print("\n\n-----Get Minimum and Maximum Price by Ticker-----\n\n");
                    System.out.println("Ticker: ");
                    Scanner scan8 = new Scanner(System.in);
                    String ticker3 = scan8.next();
                    PriceOverTime.getMinMaxPriceByTicker(Dao.getConnection(), ticker3);
                    break; 
                    
                case 6:
                    System.out.println("Returning to Main Menu");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option3Choice != 6);
    }

    public void option4Menu() {
        Scanner scanner = new Scanner(System.in);
        int option4Choice;
        do {
            System.out.println("\n------Purchase Menu------");
            System.out.println("1. add purchase");
            System.out.println("2. update purchase");
            System.out.println("3. Back to Main Menu\n");
            System.out.print("Enter your choice: ");
            option4Choice = scanner.nextInt();
            switch (option4Choice) {
                case 1:

                    System.out.println("\n\n-----Add Purchase-----\n\n");
                    System.out.println("Account_id: ");
                    Scanner scan1 = new Scanner(System.in);
                    int id = scan1.nextInt();
                    System.out.println("Id for the time created: ");
                    Scanner scan2 = new Scanner(System.in);
                    int tID = scan2.nextInt();
                    System.out.println("Number of Shares Purchased: ");
                    Scanner scan3 = new Scanner(System.in);
                    int shares = scan3.nextInt();
                    StockPurchase.addPurchase(Dao.getConnection(), id, tID, shares);
                    break;

                case 2:

                    System.out.println("\n\n-----Update Purchase-----\n\n");
                    System.out.println("Account_id: ");
                    Scanner scan4 = new Scanner(System.in);
                    int id2 = scan4.nextInt();
                    System.out.println("Id for the time created: ");
                    Scanner scan5 = new Scanner(System.in);
                    int tID2 = scan5.nextInt();
                    System.out.println("Number of Shares Purchased: ");
                    Scanner scan6 = new Scanner(System.in);
                    int shares2 = scan6.nextInt();
                    StockPurchase.updatePurchase(Dao.getConnection(), id2, tID2, shares2);
                    break;

                case 3:
                    
                    System.out.println("Returning to Main Menu");
                    break;
                    
                default:
                    
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option4Choice != 3);
    }

    public void option5Menu() {
        Scanner scanner = new Scanner(System.in);
        int option4Choice;
        do {
            System.out.println("\n-----Account Ownership Menu-----");
            System.out.println("1. add account ownership");
            System.out.println("2. get account ownership by account id");
            System.out.println("3. Back to Main Menu\n");
            System.out.print("Enter your choice: ");
            option4Choice = scanner.nextInt();
            switch (option4Choice) {
                case 1:
                    
                    System.out.println("\n\n-----Add Account Ownership-----\n\n");
                    System.out.println("Person ID: ");
                    Scanner scan1 = new Scanner(System.in);
                    int id = scan1.nextInt();
                    System.out.println("account ID: ");
                    Scanner scan2 = new Scanner(System.in);
                    int id2 = scan2.nextInt();
                    System.out.println("What type of Account: \n1. Roth IRA\n2. Money Market\n3. Mutual Fund");
                    Scanner scan69 = new Scanner(System.in);
                    int id69 = scan69.nextInt();
                    AccountOwnership.addAccountOwnership(Dao.getConnection(), id, id2,id69);
                    break;
                    
                case 2:
                    
                    System.out.println("\n\n-----Account Ownership By Account ID-----\n\n");//Not Getting Values
                    System.out.println("account ID: ");
                    Scanner scan3 = new Scanner(System.in);
                    int id3 = scan3.nextInt();
                    AccountOwnership.getAccountOwnershipByAccountID(Dao.getConnection(), id3);
                    break;
                    
                case 3:
                    
                    System.out.println("Returning to Main Menu");
                    break;
                    
                default:
                    
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option4Choice != 3);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FinalProject project = new FinalProject();
        project.start();

    }
}



