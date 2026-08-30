import java.util.Scanner;

class invalidWithdrawalAmountException extends Exception{
    public invalidWithdrawalAmountException(String message){
        super(message);
    }
}
public class Atm {
    Scanner sc = new Scanner(System.in);
    double balance;

    void withdraw(double amount)throws invalidWithdrawalAmountException{
        if(amount > balance){
            throw new invalidWithdrawalAmountException("Insufficient Balance");
        }
        balance -= amount;
    }
    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.balance = 100;
        try{
            System.out.println("Current Balance: "+atm.balance);
            System.out.print("Enter amount to withdraw: ");
            atm.withdraw(atm.sc.nextDouble());
            System.out.println("Current Balance after withdrawal: "+atm.balance);
        }
        catch(invalidWithdrawalAmountException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}