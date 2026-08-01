public class Mobile {
    String brand;
    int price;
    int units;

    Mobile(String brand, int price, int units) {
        this.brand = brand;
        this.price = price;
        this.units = units;
    }

    Mobile(Mobile a) {
        this.brand = a.brand;
        this.price = a.price;
        this.units = a.units;
    }

    void display() {
        System.out.println("brand: " + brand);
        System.out.println("price: " + price);
        System.out.println("units: " + units);
    }

    public static void main(String[] args) {
        Mobile m1 = new Mobile("Samsung", 10000, 5);
        m1.display();
        Mobile m2 = new Mobile("XIAOMI", 20000, 5);
        m2.display();
        Mobile m3 = new Mobile(m1);
        m3.display();
        Mobile m4 = new Mobile(m2);
        m4.display();
    }
}
