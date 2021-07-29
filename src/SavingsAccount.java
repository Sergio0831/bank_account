// Saving Account child class
// has an interest rate
// a method to apply interest

public class SavingsAccount extends Account {
    
    // Interest rate
    private double interestRate;
    
    /**
     * Parameter constructor to initialize saving account
     * @param accountNumber
     * @param interestRate
     */
    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    // Get interestRate
    public double getInterestRate() {
        return this.interestRate;
    }

    // Set interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Calculate interst
    public double calcInterest() {
        return balance * interestRate;
    }
    
    // Apply interest
    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Amount interest %.2f added to balance", interest);
        deposit(interest);
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
            if (amount <= balance) {
                balance -= amount;
                System.out.printf("Amount withdrew %.2f euro.", amount);
                System.out.printf("Your balance is %.2f", balance);
            }

        } else {
            System.out.println("Enter amount greater than zero!");
        }
    }
}
