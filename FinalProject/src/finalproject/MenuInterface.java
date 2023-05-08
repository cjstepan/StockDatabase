package finalproject;

import java.util.Scanner;

public class MenuInterface 
{

    public static void showMenu() 
    {
        Scanner scanner = new Scanner(System.in);
        int mainMenuChoice = 0;
        
        while (mainMenuChoice != 6) 
        {
            String menuOptions = "\n\n-----Main Menu-----\n1. Company Information\n2. Person Information\n3. Price Information\n4. Purchases Information\n5. Accounts Information\n6. Exit\n\nEnter Your Choice: ";
            System.out.print(menuOptions);
            try
            {
                mainMenuChoice = scanner.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
                continue;
            }

            switch (mainMenuChoice) 
            {
                case 1:
                    companyInfoMenu();
                    break;

                case 2:
                    personInfoMenu();
                    break;

                case 3:
                    priceOverTimeMenu();
                    break;

                case 4:
                    purchaseMenu();
                    break;

                case 5:
                    accountOwnershipMenu();
                    break;

                case 6:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void companyInfoMenu() 
    {
        Scanner scanner = new Scanner(System.in);
        int companyInfoChoice = 0;

        while (companyInfoChoice != 5) 
        {
            String menuOptions = "\n\n-----Company Information Menu-----\n1. Get Company by Ticker\n2. Add Company\n3. Delete Company\n4. Display All Tickers\n5. Return to Main Menu?\n\nEnter Your Choice: ";
            System.out.print(menuOptions);
            try
            {
                companyInfoChoice = scanner.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
                continue;
            }

            switch (companyInfoChoice)
            {
                case 1:
                    System.out.println("\n\n-----Company by Ticker-----\n\nCompany Ticker: ");
                    Scanner scan1 = new Scanner(System.in);
                    String ticker = scan1.next();
                    Company.getCompanyByTicker(Dao.getConnection(), ticker);
                    break;

                case 2:
                    System.out.println("\n\n-----Add Company-----\n\nCompany Ticker: ");
                    Scanner scan2 = new Scanner(System.in);
                    String ticker2 = scan2.next();
                    System.out.println("Company Description:");
                    Scanner scan3 = new Scanner(System.in);
                    String description = scan3.nextLine();
                    Company.addCompany(Dao.getConnection(), ticker2, description);
                    break;

                case 3:
                    System.out.println("\n\n-----Delete Company-----\n\nInsert Ticker: ");
                    Scanner scan4 = new Scanner(System.in);
                    String ticker3 = scan4.next();
                    Company.deleteCompany(Dao.getConnection(), ticker3);
                    break;

                case 4:
                    System.out.print("\n\n-----Display All Company Tickers-----\n\n");
                    String[] str = Company.getAllTickers(Dao.getConnection());
                    for (int i = 0; i < str.length; i++) {
                        if (str[i] != null)
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
        }
    }

    private static void personInfoMenu() 
    {
        Scanner scanner = new Scanner(System.in);
        int personInfoChoice = 0;

        while (personInfoChoice != 4) 
        {
            String menuOptions = "\n\n-----Person Information Menu-----\n1. Add Person\n2. Remove Person\n3. Get Accounts Owned by Person\n4. Back to Main Menu\n\nEnter Your Choice: ";
            System.out.print(menuOptions);
            try
            {
                personInfoChoice = scanner.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
                continue;
            }

            switch (personInfoChoice) 
            {
                case 1:
                    System.out.println("\n\n-----Add Person-----\n\nFirst name: ");
                    Scanner scan1 = new Scanner(System.in);
                    String first_name = scan1.next();
                    System.out.println("Last name: ");
                    Scanner scan2 = new Scanner(System.in);
                    String last_name = scan2.next();
                    Person.addPerson(Dao.getConnection(), first_name, last_name);
                    break;

                case 2:
                    System.out.println("\n\n-----Remove Person-----\n\nInsert ID: ");
                    Scanner scan3 = new Scanner(System.in);
                    int id = scan3.nextInt();
                    Person.removePerson(Dao.getConnection(), id);
                    break;

                case 3:
                    System.out.println("\n\n-----Get Accounts Owned by Person-----\n\nInsert ID: ");
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
        }
    }

    private static void priceOverTimeMenu() 
    {
        Scanner scanner = new Scanner(System.in);
        int priceOverTimeChoice = 0;

        while (priceOverTimeChoice != 7) 
        {
            String menuOptions = "\n\n-----Price Over Time Menu-----\n1. Add New Price\n2. Get Price by Date\n3. Get Average Price by Ticker\n4. Get All Prices by Ticker\n5. Get Minimum and Maximum Price by Ticker\n6. Get Most Recent Price by Ticker\n7. Back to Main Menu\n\nEnter Your Choice: ";
            System.out.print(menuOptions);
            try
            {
                priceOverTimeChoice = scanner.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
                continue;
            }

            switch (priceOverTimeChoice) 
            {
                case 1:
                    System.out.println("\n\n-----Add new price-----\n\nCompany ID: ");
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
                    System.out.print("\n\n-----Get price by date-----\n\nCompany Ticker: ");
                    Scanner scan4 = new Scanner(System.in);
                    String id2 = scan4.next();
                    System.out.println("Current Date(YYYY-MM-DD): ");
                    Scanner scan5 = new Scanner(System.in);
                    String date2 = scan5.next();
                    PriceOverTime.getPriceByDate(Dao.getConnection(), date2, id2);
                    break;

                case 3:
                    System.out.print("\n\n-----Get Average Price by Ticker-----\n\nTicker: ");
                    Scanner scan7 = new Scanner(System.in);
                    String ticker2 = scan7.next();
                    PriceOverTime.getAvgPriceByTicker(Dao.getConnection(), ticker2);
                    break;

                case 4:
                    System.out.print("\n\n-----Get All Prices by Ticker-----\n\nTicker: ");
                    Scanner scan6 = new Scanner(System.in);
                    String ticker1 = scan6.next();
                    PriceOverTime.getAllPriceByTicker(Dao.getConnection(), ticker1);
                    break;

                case 5:
                    System.out.print("\n\n-----Get Minimum and Maximum Price by Ticker-----\n\nTicker: ");
                    Scanner scan8 = new Scanner(System.in);
                    String ticker3 = scan8.next();
                    PriceOverTime.getMinMaxPriceByTicker(Dao.getConnection(), ticker3);
                    break;

                case 6:
                    System.out.print("\n\n-----Get Most Recent Price by Ticker-----\n\nTicker: ");
                    Scanner scan9 = new Scanner(System.in);
                    String ticker4 = scan9.next();
                    PriceOverTime.getMostRecentPriceByTicker(Dao.getConnection(), ticker4);
                    break;

                case 7:
                    System.out.println("Returning to Main Menu");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void purchaseMenu() 
    {
        Scanner scanner = new Scanner(System.in);
        int purchaseChoice = 0;

        while (purchaseChoice != 3) 
        {
            String menuOptions = "\n\n-----Purchase Menu-----\n1. Add Purchase\n2. Update Purchase\n3. Back to Main Menu\n\nEnter Your Choice: ";
            System.out.print(menuOptions);
            try
            {
                purchaseChoice = scanner.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
                continue;
            }

            switch (purchaseChoice) 
            {
                case 1:
                    System.out.println("\n\n-----Add Purchase-----\n\nAccount_id: ");
                    Scanner scan1 = new Scanner(System.in);
                    int id = scan1.nextInt();
                    System.out.println("ID for the Time Created: ");
                    Scanner scan2 = new Scanner(System.in);
                    int tID = scan2.nextInt();
                    System.out.println("Number of Shares Purchased: ");
                    Scanner scan3 = new Scanner(System.in);
                    int shares = scan3.nextInt();
                    StockPurchase.addPurchase(Dao.getConnection(), id, tID, shares);
                    break;

                case 2:
                    System.out.println("\n\n-----Update Purchase-----\n\nAccount_id: ");
                    Scanner scan4 = new Scanner(System.in);
                    int id2 = scan4.nextInt();
                    System.out.println("ID for the Time Created: ");
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
        }
    }

    private static void accountOwnershipMenu() 
    {
        Scanner scanner = new Scanner(System.in);
        int accountOwnershipChoice = 0;

        while (accountOwnershipChoice != 4) 
        {
            String menuOptions = "\n\n-----Account Ownership Menu-----\n1. Add Account Ownership\n2. Get Account Ownership by Account ID\n3. Total Account Value\n4. Back to Main Menu\n\nEnter Your Choice: ";
            System.out.print(menuOptions);
            try
            {
                accountOwnershipChoice = scanner.nextInt();
            }
            catch (Exception e)
            {
                System.out.println("Invalid choice. Please try again.");
                scanner.next();
                continue;
            }

            switch (accountOwnershipChoice) 
            {
                case 1:
                    System.out.println("\n\n-----Add Account Ownership-----\n\nPerson ID: ");
                    Scanner scan1 = new Scanner(System.in);
                    int id = scan1.nextInt();
                    System.out.println("Account ID: ");
                    Scanner scan2 = new Scanner(System.in);
                    int id2 = scan2.nextInt();
                    System.out.println("What Type of Account: \n1. Roth IRA\n2. 529 Plan\n3. Individual 401(k)");
                    Scanner scan69 = new Scanner(System.in);
                    int id69 = scan69.nextInt();
                    AccountOwnership.addAccountOwnership(Dao.getConnection(), id, id2, id69);
                    break;

                case 2:
                    System.out.println("\n\n-----Account Ownership By Account ID-----\n\nAccount ID: ");
                    Scanner scan3 = new Scanner(System.in);
                    int id3 = scan3.nextInt();
                    AccountOwnership.getAccountOwnershipByAccountID(Dao.getConnection(), id3);
                    break;

                case 3:
                    System.out.println("\n\n-----Total Account Value-----\n\nAccount ID: ");
                    Scanner scan4 = new Scanner(System.in);
                    int id4 = scan4.nextInt();
                    AccountOwnership.getAccountTotalValue(Dao.getConnection(), id4);
                    break;
                case 4:
                    System.out.println("Returning to Main Menu");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
