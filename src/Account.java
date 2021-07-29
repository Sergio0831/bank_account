public abstract class Account {
    
    // Private instance variables
    private int accountNumber;
    protected double balance;

    // Default constructor
    public Account() {}

    // Parameter constructor
    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    // Get balance
    public double getBalance() {
        return this.balance;
    }

    public int getAccontNUmber() {
        return this.accountNumber;
    }

    // Abstract methods
    /**
     * Function to deposit funds into the account as long the amount parameter is > 0
     * 
     * Apply Transaction fee for the CheckingAccount
     * 
     * @param amount value to be deposited
     */
    public abstract void deposit(double amount);
    
    /**
     * Function to withdrawn funds from the account
     * 1. Amount to withdrawn must be > o
     * 2. Amount to withdrawn must be <= balance
     * 
     * @param amount value to be withdrawn
     */
    public abstract void withdraw(double amount);

} // class
