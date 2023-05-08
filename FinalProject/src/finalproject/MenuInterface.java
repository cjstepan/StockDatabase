package finalproject;

import java.util.Scanner;

public class MenuInterface 
{

    public static void showMenu(Scanner scanner) 
    {
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
                    companyInfoMenu(scanner);
                    break;

                case 2:
                    personInfoMenu(scanner);
                    break;

                case 3:
                    priceOverTimeMenu(scanner);
                    break;

                case 4:
                    purchaseMenu(scanner);
                    break;

                case 5:
                    accountOwnershipMenu(scanner);
                    break;

                case 6:
                    System.out.println("\n\nThank you for using the Stock Market Database. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void companyInfoMenu(Scanner scanner) 
    {
        int companyInfoChoice = 0;
        String ticker;

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
                    ticker = scanner.next();
                    Company.getCompanyByTicker(Dao.getConnection(), ticker);
                    break;

                case 2:
                    System.out.println("\n\n-----Add Company-----\n\nCompany Ticker: ");
                    ticker = scanner.next();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.println("Company Description:");
                    String description = scanner.nextLine();
                    Company.addCompany(Dao.getConnection(), ticker, description);
                    break;

                case 3:
                    System.out.println("\n\n-----Delete Company-----\n\nInsert Ticker: ");
                    ticker = scanner.next();
                    Company.deleteCompany(Dao.getConnection(), ticker);
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

    private static void personInfoMenu(Scanner scanner) 
    {
        int personInfoChoice = 0;
        int person_id;

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
                    String first_name = scanner.next();
                    System.out.println("Last name: ");
                    String last_name = scanner.next();
                    Person.addPerson(Dao.getConnection(), first_name, last_name);
                    break;

                case 2:
                    System.out.println("\n\n-----Remove Person-----\n\nInsert ID: ");
                    person_id = scanner.nextInt();
                    Person.removePerson(Dao.getConnection(), person_id);
                    break;

                case 3:
                    System.out.println("\n\n-----Get Accounts Owned by Person-----\n\nInsert ID: ");
                    person_id = scanner.nextInt();
                    Person.getAccountsOwnedByPerson(Dao.getConnection(), person_id);
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

    private static void priceOverTimeMenu(Scanner scanner) 
    {
        int priceOverTimeChoice = 0;
        String ticker, date;

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
                    int company_id = scanner.nextInt();
                    System.out.println("Price Changed to: ");
                    double price = scanner.nextDouble();
                    System.out.println("Current Date(YYYY-MM-DD): ");
                    date = scanner.next();
                    PriceOverTime.addNewPrice(Dao.getConnection(), company_id, price, date);
                    break;

                case 2:
                    System.out.print("\n\n-----Get price by date-----\n\nCompany Ticker: ");
                    ticker = scanner.next();
                    System.out.println("Current Date(YYYY-MM-DD): ");
                    date = scanner.next();
                    PriceOverTime.getPriceByDate(Dao.getConnection(), date, ticker);
                    break;

                case 3:
                    System.out.print("\n\n-----Get Average Price by Ticker-----\n\nTicker: ");
                    ticker = scanner.next();
                    PriceOverTime.getAvgPriceByTicker(Dao.getConnection(), ticker);
                    break;

                case 4:
                    System.out.print("\n\n-----Get All Prices by Ticker-----\n\nTicker: ");
                    ticker = scanner.next();
                    PriceOverTime.getAllPriceByTicker(Dao.getConnection(), ticker);
                    break;

                case 5:
                    System.out.print("\n\n-----Get Minimum and Maximum Price by Ticker-----\n\nTicker: ");
                    ticker = scanner.next();
                    PriceOverTime.getMinMaxPriceByTicker(Dao.getConnection(), ticker);
                    break;

                case 6:
                    System.out.print("\n\n-----Get Most Recent Price by Ticker-----\n\nTicker: ");
                    ticker = scanner.next();
                    PriceOverTime.getMostRecentPriceByTicker(Dao.getConnection(), ticker);
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

    private static void purchaseMenu(Scanner scanner) 
    {
        int purchaseChoice = 0;
        int account_id, time_id, shares;

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
                    account_id = scanner.nextInt();
                    System.out.println("ID for the Time Created: ");
                    time_id = scanner.nextInt();
                    System.out.println("Number of Shares Purchased: ");
                    shares = scanner.nextInt();
                    StockPurchase.addPurchase(Dao.getConnection(), account_id, time_id, shares);
                    break;

                case 2:
                    System.out.println("\n\n-----Update Purchase-----\n\nAccount_id: ");
                    account_id = scanner.nextInt();
                    System.out.println("ID for the Time Created: ");
                    time_id = scanner.nextInt();
                    System.out.println("Number of Shares Purchased: ");
                    shares = scanner.nextInt();
                    StockPurchase.updatePurchase(Dao.getConnection(), account_id, time_id, shares);
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

    private static void accountOwnershipMenu(Scanner scanner) 
    {
        int accountOwnershipChoice = 0;
        int account_id, person_id;

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
                    person_id = scanner.nextInt();
                    System.out.println("Account ID: ");
                    account_id = scanner.nextInt();
                    System.out.println("What Type of Account: \n1. Roth IRA\n2. 529 Plan\n3. Individual 401(k)");
                    int account_type_id = scanner.nextInt();
                    AccountOwnership.addAccountOwnership(Dao.getConnection(), person_id, account_id, account_type_id);
                    break;

                case 2:
                    System.out.println("\n\n-----Account Ownership By Account ID-----\n\nAccount ID: ");
                    account_id = scanner.nextInt();
                    AccountOwnership.getAccountOwnershipByAccountID(Dao.getConnection(), account_id);
                    break;

                case 3:
                    System.out.println("\n\n-----Total Account Value-----\n\nAccount ID: ");
                    account_id = scanner.nextInt();
                    AccountOwnership.getAccountTotalValue(Dao.getConnection(), account_id);
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
