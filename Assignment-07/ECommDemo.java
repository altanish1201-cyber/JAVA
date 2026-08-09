interface Item {
    void showDetails();
}

class Product implements Item {
    String name = "Generic Product";
    double price = 0.0;

    public void showDetails() {
        System.out.println("Product: " + name + " -> Price: $" + price);
    }
}

class Electronic extends Product {
    int warranty = 2;

    void showWarranty() {
        System.out.println("Warranty: " + warranty + " years");
    }
}

class Clothing extends Product {
    String size = "M";

    void showSize() {
        System.out.println("Size: " + size);
    }
}

class Grocery extends Product {
    String expDate = "2026-12-31";

    void showExpiry() {
        System.out.println("Expiry: " + expDate);
    }
}

public class ECommDemo {
    public static void main(String[] args) {
        Electronic e = new Electronic();
        e.name = "Laptop";
        e.price = 999.99;
        e.showDetails();
        e.showWarranty();

        Clothing c = new Clothing();
        c.name = "Jacket";
        c.price = 49.99;
        c.showDetails();
        c.showSize();

        Grocery g = new Grocery();
        g.name = "Milk";
        g.price = 3.50;
        g.showDetails();
        g.showExpiry();
    }
}