import java.text.DecimalFormat;
import java.util.ArrayList;

public class BankService {
    private double availableCash=100000;
    private ArrayList<BankAccount> accounts=new ArrayList<>();
    public BankAccount getAccount(Customer customer){
        for (BankAccount acc: accounts) {
            if(acc.getOwner()==customer){
                return acc;
            }
        }
        return null;
    }
    public BankAccount getAccount(String ssn){
        for (BankAccount acc: accounts) {
            if(acc.getOwner().getSocialSecurityNumber().equals(ssn)){
                return acc;
            }
        }
        return null;
    }
    public void checkAccountBalance(String ssn){
        BankAccount account=getAccount(ssn);
        if(account==null){
            System.out.println("No account found");
            return;
        }
        if(account.getOwner().getGender()==Gender.MALE){
            System.out.printf("Mr. %s, your account balance: %.2f \u00A5\n",account.getOwner().getLastName(),account.getBalance());
        }
        else System.out.printf("Ms. %s, your account balance: %.2f \u00A5\n",account.getOwner().getLastName(),account.getBalance());
    }
    public void createAccount(String firstName,String lastName,char gender,String ssn){
        Gender g;
        if(!(Customer.checkName(firstName)&&Customer.checkName(lastName))){
            System.out.println("Invalid name");
            return;
        }
        if(gender=='m'||gender=='M'){
            g=Gender.MALE;
        }
        else if(gender=='f'||gender=='F'){
            g=Gender.FEMALE;
        }
        else{
            System.out.println("Invalid input for gender");
            return;
        }
        if(!Customer.checkSSN(ssn)){
            System.out.println("Invalid social security number");
            return;
        }
        firstName=Customer.formatName(firstName);
        lastName=Customer.formatName(lastName);
        if(!(getAccount(ssn)==null)){
            if(g==Gender.MALE) System.out.printf("Mr. %s, you already have an account with a balance %.2f \u00A5.\n",lastName,getAccount(ssn).getBalance());
            else System.out.printf("Ms. %s, you already have an account with a balance %.2f \u00A5.\n",lastName,getAccount(ssn).getBalance());
            return;
        }
        Customer customer=new Customer(firstName,lastName,g,ssn);
        accounts.add(new BankAccount(customer,0));
        if(g==Gender.MALE){
            System.out.printf("Congrats, Mr. %s! Your account is created successfully.\n",accounts.get(accounts.size()-1).getOwner().getLastName());
        }
        else System.out.printf("Congrats, Ms. %s! Your account is created successfully.\n",accounts.get(accounts.size()-1).getOwner().getLastName());
    }
    public void makeDeposit(String ssn,double amount){
        if(!Customer.checkSSN(ssn)){
            System.out.println("Invalid social security number");
            return;
        }
        if(getAccount(ssn)==null){
            System.out.println("No account found");
            return;
        }
        if(amount<0){
            System.out.println("Invalid amount");
            return;
        }
        BankAccount account=getAccount(ssn);
        System.out.printf("Original balance: %.2f \u00A5\n",account.getBalance());
        account.setBalance(account.getBalance()+amount);
        System.out.printf("Balance after deposit: %.2f \u00A5\n",account.getBalance());
    }
    public void withdraw(String ssn,double amount){
        if(!Customer.checkSSN(ssn)){
            System.out.println("Invalid social security number");
            return;
        }
        if(getAccount(ssn)==null){
            System.out.println("No account found");
            return;
        }
        if(amount<0){
            System.out.println("Invalid amount");
            return;
        }
        BankAccount account=getAccount(ssn);
        if(amount>account.getBalance()||amount>availableCash){
            System.out.println("No enough balance or cash");
            return;
        }
        availableCash=availableCash-amount;
        System.out.printf("Original balance: %.2f \u00A5\n",account.getBalance());
        account.setBalance(account.getBalance()-amount);
        System.out.printf("Balance after withdrawal: %.2f \u00A5\n",account.getBalance());
    }
    public static void calculateMonthlyPayment(double loanAmount, int years){
        if(loanAmount>0&&years>=1){
            System.out.println("Calculation result:");
            System.out.printf("Loan amount: %s \u00A5\n",new DecimalFormat(",##0.00").format(loanAmount));
            if(years<=2){
                System.out.println("Yearly interest rate: 4.50%");
                System.out.printf("Number of installments (months): %d\n",years*12);
                double monthlyPayment=loanAmount*(0.045/12*Math.pow(1+0.045/12,years*12))/(Math.pow(1+0.045/12,years*12)-1);
                System.out.printf("Monthly payment: %s \u00A5\n",new DecimalFormat(",##0.00").format(monthlyPayment));
                System.out.printf("Total interest: %s \u00A5\n",new DecimalFormat(",##0.00").format(monthlyPayment*years*12-loanAmount));
            }
            else if(years<=5){
                System.out.println("Yearly interest rate: 4.75%");
                System.out.printf("Number of installments (months): %d\n",years*12);
                double monthlyPayment=loanAmount*(0.0475/12*Math.pow(1+0.0475/12,years*12))/(Math.pow(1+0.0475/12,years*12)-1);
                System.out.printf("Monthly payment: %s \u00A5\n",new DecimalFormat(",##0.00").format(monthlyPayment));
                System.out.printf("Total interest: %s \u00A5\n",new DecimalFormat(",##0.00").format(monthlyPayment*years*12-loanAmount));
            }
            else{
                System.out.println("Yearly interest rate: 4.90%");
                System.out.printf("Number of installments (months): %d\n",years*12);
                double monthlyPayment=loanAmount*(0.049/12*Math.pow(1+0.049/12,years*12))/(Math.pow(1+0.049/12,years*12)-1);
                System.out.printf("Monthly payment: %s \u00A5\n",new DecimalFormat(",##0.00").format(monthlyPayment));
                System.out.printf("Total interest: %s \u00A5\n",new DecimalFormat(",##0.00").format(monthlyPayment*years*12-loanAmount));
            }
        }
        else if(years<1||loanAmount<=0){
            System.out.println("invalid loan");
        }
    }
    BankService(){
        accounts.clear();
        System.out.println("Initializing bank service: no accounts yet, 100000.00 \u00A5 cash available");
    }
}
