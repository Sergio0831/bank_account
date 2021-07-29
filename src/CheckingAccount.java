public class CheckingAccount extends Account {

    // Default transaction fee
    private static double FEE = 2.5;

    // Default constructor
    public CheckingAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize checking account
     * with a custom account number and a custom transaction 
     * @param accountNumber
     * @param fee
     */
    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    /**
     * Function to deposit funds into the account as long the amount parameter is > 0
     * 
     * Apply Transaction fee for the CheckingAccount
     * 
     * @param amount value to be deposited
     */
    public void deposit(double amount) {
        // First check the amount
        if (amount > 0 ) {
            balance += amount;
            System.out.printf("Deposited %.2f euro.", amount);

            // Aply transaction fee
            balance -= FEE;
            System.out.printf("Fees applied %.2f", FEE);
            System.out.printf("Your balance is %.2f", balance);
        } else {
            System.out.println("Amount cannot be less than zero!");
        }
    }
    
    /**
     * Function to withdrawn funds from the account
     * 1. Amount to withdrawn must be > o
     * 2. Amount to withdrawn must be <= balance
     * 
     * @param amount value to be withdrawn
     */
    public void withdraw(double amount) {
        // First check the amount
        if (amount > 0) {
            if ((balance + FEE) <= balance) {
                balance -= amount;
                System.out.printf("Amount withdrew %.2f euro.", amount);

                // Apply transaction fee
                balance -= FEE;
                System.out.printf("Fees applied %.2f", FEE);
                System.out.printf("Your balance is %.2f", balance);
            }

        } else {
            System.out.println("Enter amount greater than zero!");
        }
    }


} // class
