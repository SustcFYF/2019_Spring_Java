public class BankAccount {
    private double balance;
    private Customer owner;
    public void setOwner(Customer owner){
        this.owner=owner;
    }
    public Customer getOwner(){
        return owner;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }
    BankAccount(Customer customer,double balance){
        setOwner(customer);
        setBalance(balance);
    }
}
