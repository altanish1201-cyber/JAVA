class RunnableAccount {
    private double balance;

    public RunnableAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " -> Deposit  : " + amount + " | Balance : " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(Thread.currentThread().getName() + " -> Withdraw : " + amount + " | Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " -> Withdraw : " + amount + " | Balance : " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

class DepositTask implements Runnable {
    private RunnableAccount account;

    public DepositTask(RunnableAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        double[] deposits = {1500, 2000, 800};
        for (double amt : deposits) {
            account.deposit(amt);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class WithdrawTask implements Runnable {
    private RunnableAccount account;

    public WithdrawTask(RunnableAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        double[] withdrawals = {1000, 4000, 6000};
        for (double amt : withdrawals) {
            account.withdraw(amt);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class BankRunnableDemo {

    public static void main(String[] args) throws InterruptedException {
        RunnableAccount acc = new RunnableAccount(3000);
        System.out.println("Initial Balance : " + acc.getBalance());

        Thread depositThread = new Thread(new DepositTask(acc), "Depositor");
        Thread withdrawThread = new Thread(new WithdrawTask(acc), "Withdrawer");

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        System.out.println("Final Balance   : " + acc.getBalance());
    }
}
