final class Account {
    final int ACC_NO = 1001;
    String name = "Alex";

    final void display() {
        System.out.println("Account No: " + ACC_NO);
        System.out.println("Holder Name: " + name);
    }
}

public class FinalBank {
    public static void main(String[] args) {
        Account a = new Account();
        a.display();

        // System.out.println(a.ACC_NO = 1002); // Error: cannot assign a value to
        // finalvariable
    }
}