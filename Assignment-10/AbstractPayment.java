abstract class Payment {
    abstract void pay();

    void message() {
        System.out.println("Processing Payment...");
    }
}

class CreditCard extends Payment {
    void pay() {
        System.out.println("Paid via Credit Card");
    }
}

class UPI extends Payment {
    void pay() {
        System.out.println("Paid via UPI");
    }
}

public class AbstractPayment {
    public static void main(String[] args) {
        CreditCard c = new CreditCard();
        c.message();
        c.pay();

        UPI u = new UPI();
        u.message();
        u.pay();
    }
}