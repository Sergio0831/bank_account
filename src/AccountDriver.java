import java.util.Scanner;

public class AccountDriver {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
       
        // Create an array of accounts
        Account[] accounts = new Account[10];
        int numAccount = 0;

        int choise;

        do {
            
            choise = menu(in);
            System.out.println();

            if (choise == 1) {
                accounts[numAccount++] = createAccount(in);
            } else if (choise == 2) {
                doDeposit(accounts, numAccount, in);
            } else if (choise == 3) {
                doWithdraw(accounts, numAccount, in);
            } else if (choise == 4) {
                applyInterest(accounts, numAccount, in);
            } else {
                System.out.println("Goodbye!");
            }
            System.out.println();

        } while (choise != 5);
        
    } // main

    /**
     * Method to diplay account menu
     * @param in
     * @return
     */
    public static int accountMenu(Scanner in) {
        System.out.println("Select your account: ");
        System.out.println("1. Current Account");
        System.out.println("2. Saving Account");

        int choise;
        do {
            System.out.print("Enter option: ");
            choise = in.nextInt();
        } while (choise < 1 || choise > 2);

        return choise;
    }

    /**
     * Method to search account
     * @param accounts
     * @param count
     * @param accountNuber
     * @return
     */
    public static int searchAccount(Account[] accounts, int count, int accountNumber ) {
        
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccontNUmber() == accountNumber) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Method to perform deposit on a selected account
     * @param accounts
     * @param count
     * @param in
     */
    public static void doDeposit(Account[] accounts, int count, Scanner in) {

        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNUmber = in.nextInt();

        // Search for account
        int index = searchAccount(accounts, count, accountNUmber);

        if (index >= 0) {
            // Amount
            System.out.print("Pleade enter deposit amount: ");
            double amount = in.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account with account number " + accountNUmber);
        }
    }

    /**
     * Method to perform withdraw on selected account
     * @param accounts
     * @param count
     * @param in
     */
    public static void doWithdraw(Account[] accounts, int count, Scanner in) {
        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNUmber = in.nextInt();

        // Search for account
        int index = searchAccount(accounts, count, accountNUmber);

        if (index >= 0) {
            // Amount
            System.out.print("Pleade enter withdraw amount: ");
            double amount = in.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account with account number " + accountNUmber);
        }
    }
 
    public static void applyInterest(Account[] accounts, int count, Scanner in) {
        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNUmber = in.nextInt();

        // Search for account
        int index = searchAccount(accounts, count, accountNUmber);

        if (index >= 0) {

            // Must be instance of savings account
            if (accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("No account with account number " + accountNUmber);
        }
    }

    /**
     * Method to create a new account
     * @param in
     * @return 
     */
    public static Account createAccount(Scanner in) {

        Account account = null;

        int choise = accountMenu(in);

        System.out.print("Enter account number: ");
        int accountNumber = in.nextInt();

        if (choise == 1) {// Current account
            System.out.print("Enter transaction fee: ");
            double fee = in.nextDouble();

            account = new CheckingAccount(accountNumber, fee);
            
        } else { // Saving account

            System.out.print("Enter interest rate: ");
            double intRate = in.nextDouble();
            
            account = new SavingsAccount(accountNumber, intRate);
        }

        return account;
    }

    /**
     * Method to display options
     * @param in
     * @return choise
     */
    public static int menu(Scanner in) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit funds");
        System.out.println("3. Withdraw funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Exit");

        int choise;

        do {
            System.out.print("Enter option: ");
            choise = in.nextInt();
        } while (choise < 1 || choise > 5);

        return choise;
    }

} // class
