public class Restro {
    static int c;

    static double order(double price, double tax) {
        c++;
        return price + (price * tax);
    }

    static double order(double price, double tax, double packageCharge) {
        c++;
        return price + (price * tax) + packageCharge;
    }

    static double order(double price, double deliveryCharge, double tax, double packageCharge) {
        c++;
        return price + deliveryCharge + (price * tax) + packageCharge;
    }

    public static void main(String[] args) {
        System.out.println("Dine in: " + order(100, 0.05));
        System.out.println("Takeaway: " + order(100, 0.05, 10));
        System.out.println("Delivery: " + order(100, 5, 0.05, 10));
        System.out.println("Total orders: " + c);
    }
}