package finalproject;

import java.util.Scanner;

/**
 *
 * @author Big PaPPaPaai
 */

/**
 *
 * @author calvin
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
            System.out.println("\n\n-----Main Menu-----");
            System.out.println("1. Company Information");
            System.out.println("2. Person Information");
            System.out.println("3. Price Information");
            System.out.println("4. Purchases Information");
            System.out.println("5. Accounts Information");
            System.out.println("6. Exit");
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
            System.out.println("4. Back to Main Menu");
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
                    System.out.println("Company added.");
                    break;

                case 3:

                    System.out.println("\n\n-----Delete Company-----\n\n");
                    Scanner scan4 = new Scanner(System.in);
                    String ticker3 = scan4.next();
                    Company.deleteCompany(Dao.getConnection(), ticker3);
                    System.out.println("Company Deleted.");

                    break;

                case 4:
                    System.out.println("Returning to Main Menu");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option1Choice != 4);
    }

    public void option2Menu() { //put Person here
        Scanner scanner = new Scanner(System.in);
        int option2Choice;
        do {
            System.out.println("\n-----Person Information Menu-----");
            System.out.println("1. Add Person");
            System.out.println("2. Remove Person");
            System.out.println("3. Back to Main Menu");
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
                    System.out.println("Person removed.");
                    break;
                case 3:
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
            System.out.println("1. add new price");
            System.out.println("2. current price");
            System.out.println("3. Back to Main Menu");
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
                    System.out.println("Price Updated.");
                    break;

                case 2:

                    System.out.println("\n\n-----Get price by date-----\n\n");
                    System.out.println("Company Id: ");
                    Scanner scan4 = new Scanner(System.in);
                    int id2 = scan4.nextInt();
                    System.out.println("Current Date(YYYY-MM-DD): ");
                    Scanner scan5 = new Scanner(System.in);
                    String date2 = scan5.next();
                    PriceOverTime.getPriceByDate(Dao.getConnection(), date2, id2);
                    break;

                case 3:
                    System.out.println("Returning to Main Menu");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option3Choice != 3);
    }

    public void option4Menu() {
        Scanner scanner = new Scanner(System.in);
        int option4Choice;
        do {
            System.out.println("\n------Purchase Menu------");
            System.out.println("1. Add Purchase");
            System.out.println("2. Update Purchase");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option4Choice = scanner.nextInt();
            switch (option4Choice) {
                case 1:

                    System.out.println("\n\n-----Add Purchase-----\n\n");
                    System.out.println("Company Id: ");
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
                    System.out.println("Company Id: ");
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
            System.out.println("1. Add Account Ownership");
            System.out.println("2. Get Account Ownership by Account ID");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option4Choice = scanner.nextInt();
            switch (option4Choice) {
                case 1:
                    
                    System.out.println("\n\n-----Add Account Ownership-----\n\n");
                    System.out.println("Person ID: ");
                    Scanner scan1 = new Scanner(System.in);
                    int id = scan1.nextInt();
                    System.out.println("Account ID: ");
                    Scanner scan2 = new Scanner(System.in);
                    int id2 = scan2.nextInt();
                    AccountOwnership.addAccountOwnership(Dao.getConnection(), id, id2);
                    break;
                    
                case 2:
                    
                    System.out.println("\n\n-----Account Ownership By Account ID-----\n\n");
                    System.out.println("Account ID: ");
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



