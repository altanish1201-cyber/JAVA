abstract class FoodOrder {
    abstract void calculateBill();

    void message() {
        System.out.println("Generating Bill...");
    }
}

class DineInOrder extends FoodOrder {
    double itemPrice = 200.0;
    double serviceTax = 20.0;

    void calculateBill() {
        double total = itemPrice + serviceTax;
        System.out.println("Dine-In Total Bill: $" + total);
    }
}

class TakeAwayOrder extends FoodOrder {
    double itemPrice = 200.0;
    double packingFee = 10.0;

    void calculateBill() {
        double total = itemPrice + packingFee;
        System.out.println("Take-Away Total Bill: $" + total);
    }
}

public class AbstractFoodOrder {
    public static void main(String[] args) {
        DineInOrder d = new DineInOrder();
        d.message();
        d.calculateBill();

        TakeAwayOrder t = new TakeAwayOrder();
        t.message();
        t.calculateBill();
    }
}