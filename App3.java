public class App3 {
    static int counter;

    static int add(int a, int b) {
        counter++;
        return a + b;
    }

    static double add(double a, double b) {
        counter++;
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Addition of integers: " + add(25, 5));
        System.out.println("Addition of doubles: " + add(25.0, 5.0));
        System.out.println("Addition of integers: " + add(95, 5));
        System.out.println("Addition of doubles: " + add(255.0, 66.8));
        System.out.println("Counter: " + counter);
    }
}