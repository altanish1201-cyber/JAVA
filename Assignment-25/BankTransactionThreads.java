class SharedAccount {
    private double balance;

    public SharedAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(String threadName, double amount) {
        balance += amount;
        System.out.println(threadName + " | Deposited : " + amount + " | Balance : " + balance);
    }

    public synchronized void withdraw(String threadName, double amount) {
        if (amount > balance) {
            System.out.println(threadName + " | Withdraw  : " + amount + " | Failed - Insufficient Balance (" + balance + ")");
            return;
        }
        balance -= amount;
        System.out.println(threadName + " | Withdrawn : " + amount + " | Balance : " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private SharedAccount account;
    private double[] amounts;

    public DepositThread(SharedAccount account, double[] amounts) {
        super("DepositThread");
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amt : amounts) {
            account.deposit(getName(), amt);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class WithdrawThread extends Thread {
    private SharedAccount account;
    private double[] amounts;

    public WithdrawThread(SharedAccount account, double[] amounts) {
        super("WithdrawThread");
        this.account = account;
        this.amounts = amounts;
    }

    @Override
    public void run() {
        for (double amt : amounts) {
            account.withdraw(getName(), amt);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class BankTransactionThreads {

    public static void main(String[] args) throws InterruptedException {
        SharedAccount acc = new SharedAccount(5000);
        System.out.println("Opening Balance : " + acc.getBalance());
        System.out.println("-------------------------------------------------");

        DepositThread d = new DepositThread(acc, new double[] {1000, 2500, 1500, 500});
        WithdrawThread w = new WithdrawThread(acc, new double[] {2000, 3000, 7000, 1000});

        d.start();
        w.start();

        d.join();
        w.join();

        System.out.println("-------------------------------------------------");
        System.out.println("Closing Balance : " + acc.getBalance());
    }
}
