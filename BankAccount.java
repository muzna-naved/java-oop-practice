public class BankAccount {

        private int balance;

        public int  getBalance() {
            return balance;
        }

        public void setBalance(int amount) {
            this.balance = amount;
        }
   
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setBalance(1000); // Setting the balance of the account
        System.out.println(account.getBalance()); // Accessing the balance of the account

    }

}