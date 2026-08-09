public class App1 {
    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static int sub(int a, int b) {
        return a - b;
    }

    static int mul(int a, int b) {
        return a * b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        int a = 25;
        int b = 5;

        System.out.println("Addition: " + add(a, b));
        System.out.println("Addition: " + add(a, b, 10));
        System.out.println("Addition: " + add(2.3, 3.5));
        System.out.println("Subtraction: " + sub(a, b));
        System.out.println("Multiplication: " + mul(a, b));
    }
}